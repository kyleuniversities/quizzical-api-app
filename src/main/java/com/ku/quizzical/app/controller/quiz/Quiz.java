package com.ku.quizzical.app.controller.quiz;

import jakarta.persistence.*;

/**
 * Model class for Quiz Quizzes+
 */
@Entity
@Table(name = "quiz")
public final class Quiz {

    // Instance Fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    // New Instance Method
    public static Quiz newInstance(String id, String title, String description,
            int numberOfMilliseconds) {
        return new Quiz(id, title, description, numberOfMilliseconds);
    }

    // Constructor Methods
    private Quiz() {
        super();
    }

    private Quiz(String id, String title, String description, int numberOfMilliseconds) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Accessor Methods
    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    // Mutator Methods
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // To String Method
    @Override
    public String toString() {
        return String.format("Quiz(\"%s\", \"%s\", \"%s\")", this.title, this.description,
                this.id);
    }
}
