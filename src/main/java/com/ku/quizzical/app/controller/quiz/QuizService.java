package com.ku.quizzical.app.controller.quiz;

import java.util.List;

public interface QuizService {
    QuizDto saveQuiz(QuizDto quiz);

    List<QuizDto> getAllQuizs();

    QuizDto getQuizById(String id);

    QuizDto updateQuiz(QuizDto quiz, String id);

    void deleteQuiz(String id);
}
