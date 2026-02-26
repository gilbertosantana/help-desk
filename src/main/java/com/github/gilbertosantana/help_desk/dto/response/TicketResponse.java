package com.github.gilbertosantana.help_desk.dto.response;

import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.enums.Priority;
import com.github.gilbertosantana.help_desk.entities.enums.TicketStatus;

import java.time.LocalDateTime;

public record TicketResponse(Long id,
                             LocalDateTime openingDate,
                             String title,
                             String description,
                             Priority priority,
                             TicketStatus ticketStatus,
                             UserSummaryResponse user,
                             Category category) {
}
