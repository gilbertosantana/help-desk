package com.github.gilbertosantana.help_desk.repositories;

import com.github.gilbertosantana.help_desk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findUserByEmail(String username);

}
