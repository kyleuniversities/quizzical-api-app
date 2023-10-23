package com.ku.quizzical.app.controllers;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ku.quizzical.app.models.Question;
import com.ku.quizzical.app.service.QuestionService;
import com.ku.quizzical.app.service.QuestionServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/question")
public final class QuestionController {
    // Instance Fields
    private QuestionServiceImpl service;

    // Constructor Method
    public QuestionController(QuestionServiceImpl service) {
        super();
        this.service = service;
    }

    // CREATE Method
    // Saves a Questions
    @PostMapping()
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return new ResponseEntity<Question>(this.service.saveQuestion(question), HttpStatus.OK);
    }

    // TEST Method
    // Collects the time
    @GetMapping("/time")
    public String time() {
        return "\"QUESTION: " + Instant.now().toString() + "\"";
    }
}
