package com.github.gilbertosantana.help_desk.config;

import com.github.gilbertosantana.help_desk.entities.Category;
import com.github.gilbertosantana.help_desk.entities.Ticket;
import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.entities.enums.Priority;
import com.github.gilbertosantana.help_desk.entities.enums.TicketStatus;
import com.github.gilbertosantana.help_desk.repositories.CategoryRepository;
import com.github.gilbertosantana.help_desk.repositories.TicketRepository;
import com.github.gilbertosantana.help_desk.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	private final TicketRepository ticketRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public TestConfig(TicketRepository ticketRepository, CategoryRepository categoryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.ticketRepository = ticketRepository;
		this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public void run(String... args) throws Exception {
		User userAdmin = new User();
		userAdmin.setName("Gilberto");
		userAdmin.setEmail("gilbertosantoss307@gmail.com");
		userAdmin.setPassword(passwordEncoder.encode("1234567"));
		userAdmin.getProfiles().add(com.github.gilbertosantana.help_desk.entities.enums.Profile.ADMINISTRADOR);

		userRepository.save(userAdmin);

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
