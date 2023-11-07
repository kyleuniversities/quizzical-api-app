package com.ku.quizzical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ku.quizzical.app.models.Question;

public interface QuestionRepository extends JpaRepository<Question, String> {

}
