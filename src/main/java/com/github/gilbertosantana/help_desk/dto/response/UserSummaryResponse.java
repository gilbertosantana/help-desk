package com.github.gilbertosantana.help_desk.dto.response;

import com.github.gilbertosantana.help_desk.entities.enums.Profile;
import com.github.gilbertosantana.help_desk.entities.enums.UserStatus;

import java.util.Set;

public record UserSummaryResponse(Long id,
                                  String name,
                                  boolean ativo) {
}
