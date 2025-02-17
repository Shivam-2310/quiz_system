package com.shivam.online_quiz_system.repository;

import com.shivam.online_quiz_system.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
