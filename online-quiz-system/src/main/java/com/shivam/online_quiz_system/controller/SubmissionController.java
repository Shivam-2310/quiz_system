package com.shivam.online_quiz_system.controller;

import com.shivam.online_quiz_system.model.Submission;
import com.shivam.online_quiz_system.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public Submission submitQuiz(@RequestBody Submission submission) {
        return submissionService.submitQuiz(submission);
    }
}
