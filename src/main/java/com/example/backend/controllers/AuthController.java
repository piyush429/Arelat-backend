package com.example.backend.controllers;

import com.example.backend.configurations.JwtUtil;
import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.authResponse;
import com.example.backend.dto.authResponseLogin;
import com.example.backend.dto.signUpRequest;
import com.example.backend.model.User;
import com.example.backend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<authResponseLogin> login(@RequestBody LoginRequest request) {
        // Placeholder authentication logic
        var user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(request.getPassword())) {
                return ResponseEntity.ok(
                        new authResponseLogin("Login successful",
                                jwtUtil.generateToken(request.getEmail(), user.get().getId())));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new authResponseLogin("Invalid credentials", null));
    }

    @PostMapping("/signup")
    public ResponseEntity<authResponse> signUp(@RequestBody signUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new authResponse("Already Exists"));
        }
        var user = User.createUser(request.getEmail(), request.getName(), request.getPassword());
        userRepository.save(user);
        // In reality, you'd save the user to the database
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new authResponse("Registration successful"));
    }
}



