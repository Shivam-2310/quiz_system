package com.shivam.online_quiz_system.controller;

import com.shivam.online_quiz_system.model.Question;
import com.shivam.online_quiz_system.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
        return questionService.getQuestionsByQuizId(quizId);
    }
}
