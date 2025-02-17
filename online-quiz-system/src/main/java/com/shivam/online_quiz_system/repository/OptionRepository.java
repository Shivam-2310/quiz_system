package com.shivam.online_quiz_system.repository;

import com.shivam.online_quiz_system.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
