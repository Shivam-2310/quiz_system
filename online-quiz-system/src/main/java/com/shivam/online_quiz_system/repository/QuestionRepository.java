package com.shivam.online_quiz_system.repository;

import com.shivam.online_quiz_system.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
