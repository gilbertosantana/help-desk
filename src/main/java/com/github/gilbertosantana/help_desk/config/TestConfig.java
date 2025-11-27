package com.github.gilbertosantana.help_desk.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.gilbertosantana.help_desk.entities.Usuario;
import com.github.gilbertosantana.help_desk.entities.enums.Perfil;
import com.github.gilbertosantana.help_desk.entities.enums.StatusUsuario;
import com.github.gilbertosantana.help_desk.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario(null, "Gilberto", "gilberto@gmail.com", "qwert", Perfil.ADMINISTRADOR, StatusUsuario.ATIVO);
		Usuario usuario2 = new Usuario(null, "Moises", "moises@gmail.com", "zxcvb", Perfil.ADMINISTRADOR, StatusUsuario.ATIVO);
		Usuario usuario3 = new Usuario(null, "Junior", "junior@gmail.com", "nm,.;", Perfil.ADMINISTRADOR, StatusUsuario.ATIVO);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
		
		
	}

}
