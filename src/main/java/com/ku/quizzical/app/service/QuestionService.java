package com.ku.quizzical.app.service;

import java.util.List;
import com.ku.quizzical.app.models.Question;

public interface QuestionService {
    Question saveQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

    Question updateQuestion(Question question, String id);

    void deleteQuestion(String id);
}
