package com.github.gilbertosantana.help_desk.mapper;

import com.github.gilbertosantana.help_desk.dto.request.RegisterUserRequest;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import com.github.gilbertosantana.help_desk.entities.enums.UserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User toEntity(RegisterUserRequest dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setUserStatus(UserStatus.ATIVO);
        user.getProfiles().add(Optional.ofNullable(dto.profile()).orElse(Profile.COMMON));
        return user;
    }
}
