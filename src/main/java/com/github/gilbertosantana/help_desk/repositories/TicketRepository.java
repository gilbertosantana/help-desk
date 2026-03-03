package com.github.gilbertosantana.help_desk.repositories;

import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

    List<Ticket> findTicketByUser(User user);
}
