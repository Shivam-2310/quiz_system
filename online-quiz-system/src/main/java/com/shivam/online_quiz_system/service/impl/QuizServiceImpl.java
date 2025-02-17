package com.shivam.online_quiz_system.service.impl;

import com.shivam.online_quiz_system.model.Quiz;
import com.shivam.online_quiz_system.repository.QuizRepository;
import com.shivam.online_quiz_system.service.QuizService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
