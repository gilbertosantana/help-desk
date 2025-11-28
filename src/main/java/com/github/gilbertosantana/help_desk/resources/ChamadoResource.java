package com.github.gilbertosantana.help_desk.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gilbertosantana.help_desk.entities.Chamado;
import com.github.gilbertosantana.help_desk.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;
	
	@GetMapping
	public ResponseEntity<List<Chamado>> findAll() {
		List<Chamado> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Chamado> findById(@PathVariable Long id) {
		Chamado obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
