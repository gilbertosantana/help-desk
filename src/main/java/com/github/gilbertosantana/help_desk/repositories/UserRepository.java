package com.github.gilbertosantana.help_desk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gilbertosantana.help_desk.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<UserDetails> findUserByEmail(String username);

}
