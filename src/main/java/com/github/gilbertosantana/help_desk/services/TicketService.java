package com.github.gilbertosantana.help_desk.services;

import java.util.List;
import java.util.Optional;

import com.github.gilbertosantana.help_desk.dto.request.OpenTicketRequest;
import com.github.gilbertosantana.help_desk.dto.response.TicketResponse;
import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.mapper.TicketMapper;
import com.github.gilbertosantana.help_desk.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.repositories.TicketRepository;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;
	private final CategoryRepository categoryRepository;
	private final TicketMapper ticketMapper;

	public TicketService(TicketRepository ticketRepository, CategoryRepository categoryRepository, TicketMapper ticketMapper) {
		this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ticketMapper = ticketMapper;
    }

	public TicketResponse openTicket(OpenTicketRequest ticket) {
		Optional<Category> category = categoryRepository.findById(ticket.categoryId());
		Ticket response = ticketMapper.toEntity(ticket, category);
		response = ticketRepository.save(response);
		return ticketMapper.toOpenTicketResponse(response);
	}

	public List<TicketResponse> findAll() {
		List<Ticket> list = ticketRepository.findAll();
		return list.stream()
				.map(ticket -> new TicketResponse(ticket.getId(),
						ticket.getOpeningDate(),
						ticket.getTitle(),
						ticket.getDescription(),
						ticket.getPriority(),
						ticket.getTicketStatus(),
						ticket.getCategory()))
				.toList();

	}

	public Ticket findById(Long id) {
		Optional<Ticket> obj = ticketRepository.findById(id);
		return obj.get();
	}
}
