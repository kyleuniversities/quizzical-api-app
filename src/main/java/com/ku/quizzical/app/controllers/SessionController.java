package com.ku.quizzical.app.controllers;

import java.security.Principal;
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
import com.ku.quizzical.app.models.User;
import com.ku.quizzical.app.models.structure.UserLoginCredentials;
import com.ku.quizzical.app.models.structure.UserSession;
import com.ku.quizzical.app.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/sessions")
public final class SessionController {
    // READ Method
    // Gets the Session
    @GetMapping()
    public UserSession getSession(HttpServletRequest request, HttpSession session) {
        try {
            String userId = (String) session.getAttribute("userId");
            String username = (String) request.getSession().getAttribute("principalName");
            System.out.println("LOAD_SESSION_ID: " + session.getId());
            return UserSession.newInstance(userId + "", username + "");
        } catch (Exception exception) {
            return UserSession.newInstance("{NULL_ID}", "signedOut");
        }
    }
}
