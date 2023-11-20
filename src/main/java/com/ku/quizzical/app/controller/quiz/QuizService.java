package com.ku.quizzical.app.controller.quiz;

import java.util.List;

public interface QuizService {
    Quiz saveQuiz(Quiz quiz);

    List<Quiz> getAllQuizs();

    Quiz getQuizById(String id);

    Quiz updateQuiz(Quiz quiz, String id);

    void deleteQuiz(String id);
}
