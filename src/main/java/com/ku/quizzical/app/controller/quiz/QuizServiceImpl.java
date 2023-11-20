package com.ku.quizzical.app.controller.quiz;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    // Instance Fields
    private QuizRepository repository;

    // Constructor Method
    public QuizServiceImpl(QuizRepository repository) {
        super();
        this.repository = repository;
    }

    // Interface Methods
    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return this.repository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizs() {
        return this.repository.findAll();
    }

    @Override
    public Quiz getQuizById(String id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, String id) {
        Quiz existingQuiz = this.repository.findById(id).get();
        existingQuiz.setTitle(quiz.getTitle());
        existingQuiz.setDescription(quiz.getDescription());
        this.repository.save(existingQuiz);
        return existingQuiz;
    }

    @Override
    public void deleteQuiz(String id) {
        this.repository.deleteById(id);
    }
}
