package com.ku.quizzical.app.models;

import jakarta.persistence.*;

/**
 * Model class for Quiz Questions+
 */
@Entity
@Table(name = "question")
public final class Question {

    // Instance Fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "question", unique = true, nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "number_of_milliseconds", nullable = false)
    private int numberOfMilliseconds;

    // New Instance Method
    public static Question newInstance(String id, String question, String answer,
            int numberOfMilliseconds) {
        return new Question(id, question, answer, numberOfMilliseconds);
    }

    // Constructor Methods
    private Question() {
        super();
    }

    private Question(String id, String question, String answer, int numberOfMilliseconds) {
        super();
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.numberOfMilliseconds = numberOfMilliseconds;
    }

    // Accessor Methods
    public String getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getNumberOfMilliseconds() {
        return this.numberOfMilliseconds;
    }

    // Mutator Methods
    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setNumberOfMilliseconds(int numberOfMilliseconds) {
        this.numberOfMilliseconds = numberOfMilliseconds;
    }

    // To String Method
    @Override
    public String toString() {
        return String.format("Question(\"%s\", \"%s\", %d, \"%s\")", this.question, this.answer,
                this.numberOfMilliseconds, this.id);
    }
}
