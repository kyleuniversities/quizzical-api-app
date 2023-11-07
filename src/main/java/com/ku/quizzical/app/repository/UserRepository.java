package com.ku.quizzical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ku.quizzical.app.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
