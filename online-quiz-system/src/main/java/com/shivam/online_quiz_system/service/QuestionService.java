package com.shivam.online_quiz_system.service;

import com.shivam.online_quiz_system.model.Question;
import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByQuizId(Long quizId);
}
