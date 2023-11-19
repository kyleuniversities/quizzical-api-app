package com.ku.quizzical.app.controller.question;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

    Question updateQuestion(Question question, String id);

    void deleteQuestion(String id);
}
