package com.github.gilbertosantana.help_desk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gilbertosantana.help_desk.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
