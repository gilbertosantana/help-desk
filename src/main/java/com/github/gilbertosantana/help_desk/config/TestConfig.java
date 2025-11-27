package com.github.gilbertosantana.help_desk.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.gilbertosantana.help_desk.entities.Chamado;
import com.github.gilbertosantana.help_desk.entities.Usuario;
import com.github.gilbertosantana.help_desk.entities.enums.Perfil;
import com.github.gilbertosantana.help_desk.entities.enums.Prioridade;
import com.github.gilbertosantana.help_desk.entities.enums.StatusChamado;
import com.github.gilbertosantana.help_desk.entities.enums.StatusUsuario;
import com.github.gilbertosantana.help_desk.repositories.ChamadoRepository;
import com.github.gilbertosantana.help_desk.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario(null, "Gilberto", "gilberto@gmail.com", "qwert", Perfil.SUPORTE, StatusUsuario.ATIVO);
		Usuario usuario2 = new Usuario(null, "Moises", "moises@gmail.com", "zxcvb", Perfil.SUPORTE, StatusUsuario.ATIVO);
		Usuario usuario3 = new Usuario(null, "Junior", "junior@gmail.com", "nm,.;", Perfil.ADMINISTRADOR, StatusUsuario.ATIVO);
		Usuario usuario4 = new Usuario(null, "Fernada Karla", "fernada@gmail.com", "asdfg", Perfil.COMUM, StatusUsuario.ATIVO);
		Usuario usuario5 = new Usuario(null, "Asteny", "asteny@gmail.com", "jkçl", Perfil.COMUM, StatusUsuario.ATIVO);
		
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5));
		
		Chamado chamado1 = new Chamado(null, Instant.now(), "Está dando erro ao fazer o encerramento", usuario4, Prioridade.ALTA, StatusChamado.ABERTO);
		Chamado chamado2 = new Chamado(null, Instant.now(), "Preciso de um script de abastecimento", usuario5, Prioridade.MEDIA, StatusChamado.EM_ANALISE);
		
		chamadoRepository.saveAll(Arrays.asList(chamado1, chamado2));
		
		
		
	}

}
