package com.github.gilbertosantana.help_desk.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
