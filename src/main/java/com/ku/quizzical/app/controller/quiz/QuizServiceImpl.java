package com.ku.quizzical.app.controller.quiz;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ku.quizzical.common.helper.ListHelper;

@Service
public class QuizServiceImpl implements QuizService {
    // Instance Fields
    private QuizRepository repository;
    private QuizDtoMapper dtoMapper;

    // Constructor Method
    public QuizServiceImpl(QuizRepository repository) {
        super();
        this.repository = repository;
        this.dtoMapper = new QuizDtoMapper();
    }

    // Interface Methods
    @Override
    public QuizDto saveQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.title());
        quiz.setDescription(quizDto.description());
        quiz.setQuestions(ListHelper.newArrayList());
        return this.dtoMapper.apply(this.repository.save(quiz));
    }

    @Override
    public List<QuizDto> getAllQuizs() {
        return ListHelper.map(this.repository.findAll(), this.dtoMapper::apply);
    }

    @Override
    public QuizDto getQuizById(String id) {
        return this.dtoMapper.apply(this.repository.findById(id).get());
    }

    @Override
    public QuizDto updateQuiz(QuizDto quiz, String id) {
        Quiz existingQuiz = this.repository.findById(id).get();
        existingQuiz.setTitle(quiz.title());
        existingQuiz.setDescription(quiz.description());
        this.repository.save(existingQuiz);
        return this.dtoMapper.apply(existingQuiz);
    }

    @Override
    public void deleteQuiz(String id) {
        this.repository.deleteById(id);
    }
}
