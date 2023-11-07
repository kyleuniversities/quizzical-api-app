package com.ku.quizzical.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ku.quizzical.app.models.Question;
import com.ku.quizzical.app.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
    // Instance Fields
    private QuestionRepository repository;

    // Constructor Method
    public QuestionServiceImpl(QuestionRepository repository) {
        super();
        this.repository = repository;
    }

    // Interface Methods
    @Override
    public Question saveQuestion(Question question) {
        return this.repository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.repository.findAll();
    }

    @Override
    public Question getQuestionById(String id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Question updateQuestion(Question question, String id) {
        Question existingQuestion = this.repository.findById(id).get();
        existingQuestion.setQuestion(question.getQuestion());
        existingQuestion.setAnswer(question.getAnswer());
        existingQuestion.setNumberOfMilliseconds(question.getNumberOfMilliseconds());
        this.repository.save(existingQuestion);
        return existingQuestion;
    }

    @Override
    public void deleteQuestion(String id) {
        this.repository.deleteById(id);
    }
}
