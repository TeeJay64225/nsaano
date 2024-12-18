package com.nsa.ano.controller;

import com.nsa.ano.dto.LoginRequest;
import com.nsa.ano.dto.RegisterRequest;
import com.nsa.ano.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String response = authService.register(request);
        if (response.equals("Registration successful.")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = authService.login(request);
        if (success) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password.");
        }
    }
}
