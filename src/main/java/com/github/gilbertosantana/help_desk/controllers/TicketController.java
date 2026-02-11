package com.github.gilbertosantana.help_desk.controllers;

import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/chamados")
public class TicketController {

	private final TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}

	@PostMapping(value = "/chamados")
	public ResponseEntity<Ticket> abrirChamado(@RequestBody Ticket ticket) {
		Ticket obj = service.abrirChamado(ticket);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/chamados")
	public ResponseEntity<List<Ticket>> findAll() {
		List<Ticket> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/chamados/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id) {
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
