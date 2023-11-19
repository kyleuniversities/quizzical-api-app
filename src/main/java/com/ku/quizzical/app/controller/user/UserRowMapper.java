package com.ku.quizzical.app.controller.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        return User.newInstance(resultSet.getString("id"), resultSet.getString("username"),
                resultSet.getString("email"), resultSet.getString("password"));
    }
}
