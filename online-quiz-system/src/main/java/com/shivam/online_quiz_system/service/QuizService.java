package com.shivam.online_quiz_system.service;

import com.shivam.online_quiz_system.model.Quiz;
import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    List<Quiz> getAllQuizzes();
}
