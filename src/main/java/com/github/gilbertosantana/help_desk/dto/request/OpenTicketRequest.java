package com.github.gilbertosantana.help_desk.dto.request;

import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.enums.Priority;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OpenTicketRequest(@NotEmpty String title,
                                @NotEmpty String description,
                                Priority priority,
                                @NotNull Long categoryId) {
}
