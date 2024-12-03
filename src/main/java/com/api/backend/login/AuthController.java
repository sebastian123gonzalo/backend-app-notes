package com.api.backend.login;

import com.api.backend.login.domain.model.LoginRequest;
import com.api.backend.login.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }


    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken(@RequestParam String token) {
        boolean isValid = authService.verifyToken(token);
        if (isValid) {
            return ResponseEntity.ok("Token is valid.");
        } else {
            return ResponseEntity.status(401).body("Invalid token.");
        }
    }
}