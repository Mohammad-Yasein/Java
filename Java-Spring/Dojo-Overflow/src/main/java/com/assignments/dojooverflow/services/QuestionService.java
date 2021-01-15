package com.assignments.dojooverflow.services;

import com.assignments.dojooverflow.models.Question;
import com.assignments.dojooverflow.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public void createQuestion(Question question) {
        questionRepository.save(question);
    }
}
