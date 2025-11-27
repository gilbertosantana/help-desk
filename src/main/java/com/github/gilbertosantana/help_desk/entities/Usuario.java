package com.github.gilbertosantana.help_desk.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.gilbertosantana.help_desk.entities.enums.Perfil;
import com.github.gilbertosantana.help_desk.entities.enums.StatusUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Integer perfil;
	private Integer statusUsuario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Chamado> chamados = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha, Perfil perfil, StatusUsuario statusUsuario) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		setPerfil(perfil);
		setStatusUsuario(statusUsuario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return Perfil.valueOf(perfil);
	}

	public void setPerfil(Perfil perfil) {
		if (perfil != null) {
			this.perfil = perfil.getCode();
		}
	}

	public StatusUsuario getStatusUsuario() {
		return StatusUsuario.valueOf(statusUsuario);
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
		if (statusUsuario != null) {
			this.statusUsuario = statusUsuario.getCode();
		}
	}

	public List<Chamado> getChamados() {
		return chamados;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
