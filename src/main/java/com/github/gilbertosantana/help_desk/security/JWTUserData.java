package com.github.gilbertosantana.help_desk.security;

import lombok.Builder;

import java.util.List;

@Builder
public record JWTUserData(Long userId, String email, List<String> profiles) {
}
