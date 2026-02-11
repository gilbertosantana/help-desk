package com.github.gilbertosantana.help_desk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.repositories.TicketRepository;

@Service
public class TicketService {

	private final TicketRepository repository;

	public TicketService(TicketRepository repository) {
		this.repository = repository;
	}

	public Ticket abrirChamado(Ticket ticket) {
		return repository.save(ticket);
	}

	public List<Ticket> findAll() {
		return repository.findAll();
	}

	public Ticket findById(Long id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.get();
	}
}
