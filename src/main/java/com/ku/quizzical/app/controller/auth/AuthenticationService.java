package com.ku.quizzical.app.controller.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        // TODO
    }
}
