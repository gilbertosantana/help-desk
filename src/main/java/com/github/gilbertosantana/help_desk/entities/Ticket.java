package com.github.gilbertosantana.help_desk.entities;

import com.github.gilbertosantana.help_desk.entities.enums.Priority;
import com.github.gilbertosantana.help_desk.entities.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime openingDate;
	private String description;
	private Priority priority;
	private TicketStatus ticketStatus;

	@OneToOne
	private Category category;

	public Ticket() {
	}

	public Ticket(Long id, LocalDateTime openingDate, String description, Priority priority,
				  TicketStatus ticketStatus, Category category) {
		this.id = id;
		this.openingDate = openingDate;
		this.description = description;
		this.priority = priority;
		this.ticketStatus = ticketStatus;
		this.category = category;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
}
