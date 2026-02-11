package com.github.gilbertosantana.help_desk.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.entities.enums.Priority;
import com.github.gilbertosantana.help_desk.entities.enums.TicketStatus;
import com.github.gilbertosantana.help_desk.repositories.CategoryRepository;
import com.github.gilbertosantana.help_desk.repositories.TicketRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private final TicketRepository ticketRepository;
	private final CategoryRepository categoryRepository;

	public TestConfig(TicketRepository ticketRepository, CategoryRepository categoryRepository) {
		this.ticketRepository = ticketRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category(null, "Computador");
		Category category2 = new Category(null, "Impressora");
		Category category3 = new Category(null, "E-mail");
		Category category4 = new Category(null, "Reset de senha");
		Category category5 = new Category(null, "Sistema CS");
		Category category6 = new Category(null, "Criação de Script");
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4, category5, category6));
		
		Ticket ticket1 = new Ticket(null, LocalDateTime.now(), "Está dando erro ao fazer o encerramento", Priority.ALTA, TicketStatus.ABERTO, category5);
		Ticket ticket2 = new Ticket(null, LocalDateTime.now(), "Preciso de um script de abastecimento", Priority.MEDIA, TicketStatus.EM_ANALISE, category6);
		
		ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));
		
		
		
	}

}
