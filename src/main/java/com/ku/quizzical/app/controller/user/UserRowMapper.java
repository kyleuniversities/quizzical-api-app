package com.ku.quizzical.app.controller.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.ku.quizzical.app.controller.quiz.QuizRepository;

@Component
public class UserRowMapper implements RowMapper<User> {
    private QuizRepository quizRepository;

    public UserRowMapper(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        return null;
        // return new User(resultSet.getString("id"), resultSet.getString("username"),
        // resultSet.getString("email"), resultSet.getString("password"),
        // this.quizRepository.findById(resultSet.getString("quiz_id")).get());
    }
}
