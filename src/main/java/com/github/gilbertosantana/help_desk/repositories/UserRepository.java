package com.github.gilbertosantana.help_desk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gilbertosantana.help_desk.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
