package com.github.gilbertosantana.help_desk.config;

import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import lombok.Builder;

import java.util.List;

@Builder
public record JWTUserData(Long userId, String email, List<String> profiles) {
}
