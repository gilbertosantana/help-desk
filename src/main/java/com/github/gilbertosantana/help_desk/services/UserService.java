package com.github.gilbertosantana.help_desk.services;

import com.github.gilbertosantana.help_desk.config.TokenConfig;
import com.github.gilbertosantana.help_desk.dto.request.LoginRequest;
import com.github.gilbertosantana.help_desk.dto.request.RegisterUserRequest;
import com.github.gilbertosantana.help_desk.dto.response.LoginResponse;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import com.github.gilbertosantana.help_desk.mapper.UserMapper;
import com.github.gilbertosantana.help_desk.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public UserService(UserRepository userRepository, UserMapper userMapper, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    public LoginResponse login(@Valid LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);
        User user = (User)authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return new LoginResponse(token);
    }

    public User register(@Valid RegisterUserRequest request) {
        User newUser = userMapper.toEntity(request);
        return userRepository.save(newUser);
    }
}
