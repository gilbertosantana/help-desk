package com.github.gilbertosantana.help_desk.services;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import com.github.gilbertosantana.help_desk.dto.request.OpenTicketRequest;
import com.github.gilbertosantana.help_desk.dto.response.TicketResponse;
import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.mapper.TicketMapper;
import com.github.gilbertosantana.help_desk.mapper.UserMapper;
import com.github.gilbertosantana.help_desk.repositories.CategoryRepository;
import com.github.gilbertosantana.help_desk.repositories.UserRepository;
import com.github.gilbertosantana.help_desk.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.repositories.TicketRepository;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;
	private final CategoryRepository categoryRepository;
	private final TicketMapper ticketMapper;
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public TicketService(TicketRepository ticketRepository, CategoryRepository categoryRepository, TicketMapper ticketMapper, UserRepository userRepository, UserMapper userMapper) {
		this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ticketMapper = ticketMapper;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public TicketResponse openTicket(OpenTicketRequest ticket) {
        String userEmailCurrent;
		try {
			userEmailCurrent = SecurityUtils.getCurrentUser().email();
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }
        Optional<User> user = userRepository.findUserByEmail(userEmailCurrent);
		Optional<Category> category = categoryRepository.findById(ticket.categoryId());
		Ticket response = ticketMapper.toEntity(ticket, user.get(), category);
		response = ticketRepository.save(response);
		return ticketMapper.toResponse(response);
	}

	public List<TicketResponse> findAllByUser() {
        String userEmailCurrent;
        try {
            userEmailCurrent = SecurityUtils.getCurrentUser().email();
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }
        Optional<User> user = userRepository.findUserByEmail(userEmailCurrent);
		List<Ticket> list = ticketRepository.findTicketByUser(user.get());
		return list.stream()
				.map(ticketMapper::toResponse)
				.toList();
	}

	public Ticket findById(Long id) {
		Optional<Ticket> obj = ticketRepository.findById(id);
		return obj.get();
	}
}
