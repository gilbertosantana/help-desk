package com.github.gilbertosantana.help_desk.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email obrigatório") String email,
                           @NotEmpty(message = "Senha é obrigatória") String password) {
}
