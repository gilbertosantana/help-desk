package com.github.gilbertosantana.help_desk.controllers;

import com.github.gilbertosantana.help_desk.dto.request.OpenTicketRequest;
import com.github.gilbertosantana.help_desk.dto.response.TicketResponse;
import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketController {

	private final TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TicketResponse> openTicket(@Valid @RequestBody OpenTicketRequest ticket) {
		TicketResponse ticketResponse = service.openTicket(ticket);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(ticketResponse.id())
				.toUri();
		return ResponseEntity.created(uri).body(ticketResponse);
	}

	@GetMapping(value = "/my")
	public ResponseEntity<List<TicketResponse>> findAllByUser() {
		List<TicketResponse> list = service.findAllByUser();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id) {
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
