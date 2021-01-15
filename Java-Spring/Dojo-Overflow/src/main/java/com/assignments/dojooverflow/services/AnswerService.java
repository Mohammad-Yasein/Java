package com.assignments.dojooverflow.services;

import com.assignments.dojooverflow.models.Answer;
import com.assignments.dojooverflow.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
