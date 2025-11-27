package com.github.gilbertosantana.help_desk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gilbertosantana.help_desk.entities.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}
