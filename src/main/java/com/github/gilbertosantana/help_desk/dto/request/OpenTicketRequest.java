package com.github.gilbertosantana.help_desk.dto.request;

import com.github.gilbertosantana.help_desk.entities.enums.Priority;

public record OpenTicketRequest(String title,
                                String description,
                                Priority priority,
                                Long categoryId) {
}