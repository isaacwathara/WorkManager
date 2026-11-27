package com.workmanager.presentation.controller;

import com.workmanager.application.service.AuthService;
import com.workmanager.domain.model.User;
import com.workmanager.presentation.dto.AuthResponse;
import com.workmanager.presentation.dto.LoginRequest;
import com.workmanager.presentation.dto.RegisterRequest;
import com.workmanager.presentation.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        User user = authService.register(request.firstName(), request.lastName(), request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        AuthService.AuthToken result = authService.login(request.email(), request.password());
        return new AuthResponse(result.token(), "Bearer", result.expiresInSeconds());
    }

    // authentication.getName() = id de l'utilisateur, posé par le filtre JWT
    @GetMapping("/me")
    public UserResponse me(Authentication authentication) {
        return UserResponse.from(authService.getCurrentUser(authentication.getName()));
    }

    @PostMapping("/logout")
    public ResponseEntity<UserResponse> logout(Authentication authentication) {
        return ResponseEntity.ok(UserResponse.from(authService.getCurrentUser(authentication.getName())));
    }
}