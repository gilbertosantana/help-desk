package com.github.gilbertosantana.help_desk.controllers;

import com.github.gilbertosantana.help_desk.config.TokenConfig;
import com.github.gilbertosantana.help_desk.dto.request.LoginRequest;
import com.github.gilbertosantana.help_desk.dto.request.RegisterUserRequest;
import com.github.gilbertosantana.help_desk.dto.response.LoginResponse;
import com.github.gilbertosantana.help_desk.dto.response.RegisterUserResponse;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import com.github.gilbertosantana.help_desk.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthController(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User)authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok().body(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setName(request.name());
        newUser.setEmail(request.email());

        if (request.profile() != null) {
            newUser.getProfiles().add(request.profile());
        } else {
            newUser.getProfiles().add(Profile.COMUM);
        }

        userRepository.save(newUser);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
