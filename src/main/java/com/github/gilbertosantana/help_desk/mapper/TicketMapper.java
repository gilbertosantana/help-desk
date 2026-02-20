package com.github.gilbertosantana.help_desk.mapper;

import com.github.gilbertosantana.help_desk.dto.request.OpenTicketRequest;
import com.github.gilbertosantana.help_desk.dto.request.TicketResponse;
import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.entities.enums.TicketStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TicketMapper {

    public Ticket toEntity(OpenTicketRequest ticketRequest, Optional<Category> category) {
        Ticket ticket = new Ticket();
        ticket.setOpeningDate(LocalDateTime.now());
        ticket.setTitle(ticketRequest.title());
        ticket.setDescription(ticketRequest.description());
        ticket.setPriority(ticketRequest.priority());
        ticket.setTicketStatus(TicketStatus.ABERTO);
        category.ifPresent(ticket::setCategory);

        return ticket;
    }

    public TicketResponse toOpenTicketResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getOpeningDate(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getPriority(),
                ticket.getTicketStatus(),
                ticket.getCategory()
        );
    }
}
