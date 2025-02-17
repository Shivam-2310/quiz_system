package com.shivam.online_quiz_system.service.impl;

import com.shivam.online_quiz_system.model.Question;
import com.shivam.online_quiz_system.repository.QuestionRepository;
import com.shivam.online_quiz_system.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.findAll()
                .stream()
                .filter(question -> question.getQuiz().getId().equals(quizId))
                .toList();
    }
}
