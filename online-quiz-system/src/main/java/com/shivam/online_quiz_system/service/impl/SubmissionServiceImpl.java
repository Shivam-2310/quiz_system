package com.shivam.online_quiz_system.service.impl;

import com.shivam.online_quiz_system.model.Submission;
import com.shivam.online_quiz_system.repository.SubmissionRepository;
import com.shivam.online_quiz_system.service.SubmissionService;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Submission submitQuiz(Submission submission) {
        return submissionRepository.save(submission);
    }
}
