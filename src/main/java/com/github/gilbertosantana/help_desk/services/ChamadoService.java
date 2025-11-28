package com.github.gilbertosantana.help_desk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.help_desk.entities.Chamado;
import com.github.gilbertosantana.help_desk.repositories.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado findById(Long id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.get();
	}
}
