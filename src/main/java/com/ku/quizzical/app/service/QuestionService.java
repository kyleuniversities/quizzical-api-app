package com.ku.quizzical.app.service;

import java.util.List;
import com.ku.quizzical.app.models.Question;

public interface QuestionService {
    Question saveQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(long id);

    Question updateQuestion(Question question, long id);

    void deleteQuestion(long id);
}
