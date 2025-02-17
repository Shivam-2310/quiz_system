package com.shivam.online_quiz_system.repository;

import com.shivam.online_quiz_system.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
