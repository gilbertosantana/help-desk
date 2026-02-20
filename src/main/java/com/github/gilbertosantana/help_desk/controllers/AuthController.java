package com.github.gilbertosantana.help_desk.controllers;

import com.github.gilbertosantana.help_desk.dto.request.LoginRequest;
import com.github.gilbertosantana.help_desk.dto.request.RegisterUserRequest;
import com.github.gilbertosantana.help_desk.dto.response.LoginResponse;
import com.github.gilbertosantana.help_desk.dto.response.RegisterUserResponse;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        User newUser = userService.register(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
