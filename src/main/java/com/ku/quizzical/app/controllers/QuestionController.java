package com.ku.quizzical.app.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ku.quizzical.app.models.Question;
import com.ku.quizzical.app.service.QuestionServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public final class QuestionController {
    // Instance Fields
    private QuestionServiceImpl service;

    // Constructor Method
    public QuestionController(QuestionServiceImpl service) {
        super();
        this.service = service;
    }

    // CREATE Method
    // Saves a Question
    @PostMapping()
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return new ResponseEntity<Question>(this.service.saveQuestion(question), HttpStatus.OK);
    }

    // READ Method
    // Gets all Questions
    @GetMapping()
    public List<Question> getAllQuestions() {
        return this.service.getAllQuestions();
    }

    // READ Method
    // Gets a Question by its id
    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable long id) {
        return new ResponseEntity<Question>(this.service.getQuestionById(id), HttpStatus.OK);
    }

    // UPDATE Method
    // Updates a Question
    @PatchMapping("{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable long id, @RequestBody Question question) {
        return new ResponseEntity<Question>(this.service.updateQuestion(question, id), HttpStatus.OK);
    }

    // DELETE Method
    // Deletes a Question
    @DeleteMapping("{id}")
    public String deleteQuestion(@PathVariable long id) {
        try {
            this.service.deleteQuestion(id);
        } catch (Exception e) {
            // Do Nothing
        }
        return "\"The Question with id \\\"" + id + "\\\" has been deleted.\"";
    }
}
