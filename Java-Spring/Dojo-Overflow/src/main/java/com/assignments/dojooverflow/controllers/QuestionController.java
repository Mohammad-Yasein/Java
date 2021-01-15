package com.assignments.dojooverflow.controllers;

import com.assignments.dojooverflow.models.Answer;
import com.assignments.dojooverflow.models.Question;
import com.assignments.dojooverflow.models.Tag;
import com.assignments.dojooverflow.services.AnswerService;
import com.assignments.dojooverflow.services.QuestionService;
import com.assignments.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @GetMapping("")
    public String displayAllQuestions(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "dashboard.jsp";
    }

    @GetMapping("/new")
    public String displayAddQuestion() {
        return "addQuestion.jsp";
    }

    @PostMapping("")
    public String addQuestion(
            @RequestParam(value = "question") String question,
            @RequestParam(value = "tags") String tags,
            RedirectAttributes redirectAttributes) {
        if (!question.equals("") && tagService.validateTagsString(tags)) {
            String[] subjects = tags.split(",");
            List<Tag> questionTags = new ArrayList<>();
            for (String subject : subjects) {
                Tag tag = tagService.getTagBySubject(subject.trim());
                if (tag == null) {
                    tag = new Tag(subject);
                    tagService.createTag(tag);
                }
                if (!questionTags.contains(tag))
                    questionTags.add(tag);
            }
            Question newQuestion = new Question(question, questionTags);
            questionService.createQuestion(newQuestion);
            return "redirect:/questions";
        }
        if (question.equals("")) {
            redirectAttributes.addFlashAttribute("qError", "THIS FIELD IS REQUIRED!");
        }
        if (!tagService.validateTagsString(tags)) {
            redirectAttributes.addFlashAttribute("tError", "MAX 3 TAGS SEPARATED BY COMMA!");
        }
        return "redirect:/questions/new";
    }

    @GetMapping("/{id}")
    public String displayQuestion(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.getQuestion(id));
        return "displayQuestion.jsp";
    }

    @PostMapping("/{id}")
    public String displayQuestion(@PathVariable("id") Long id, @RequestParam("answer") String answer) {
        if (!answer.equals("")) {
            Answer newAnswer = new Answer();
            newAnswer.setAnswer(answer);
            newAnswer.setQuestion(questionService.getQuestion(id));
            answerService.createAnswer(newAnswer);
        }
        return "redirect:/questions/" + id;
    }
}
