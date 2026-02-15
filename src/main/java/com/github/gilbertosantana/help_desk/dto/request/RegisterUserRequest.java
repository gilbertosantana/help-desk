package com.github.gilbertosantana.help_desk.dto.request;

import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatório") String name,
                                  @NotEmpty(message = "E-mail é obrigatório") String email,
                                  @NotEmpty(message = "Senha é obrigatória") String password,
                                  Profile profile) {
}
