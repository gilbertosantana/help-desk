package com.github.gilbertosantana.help_desk.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.github.gilbertosantana.help_desk.entities.enums.Prioridade;
import com.github.gilbertosantana.help_desk.entities.enums.StatusChamado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Chamado")
public class Chamado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dataAbertura;
	private String descricao;
	private Integer prioridade;
	private Integer statusAtual;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Chamado() {
	}

	public Chamado(Long id, Instant dataAbertura, String descricao, Usuario usuario, Prioridade prioridade, StatusChamado status) {
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.descricao = descricao;
		this.usuario = usuario;
		setPrioridade(prioridade);
		setStatusAtual(status);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Instant dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Prioridade getPrioridade() {
		return Prioridade.valueOf(prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		if (prioridade != null) {
			this.prioridade = prioridade.getCode();
		}
	}

	public StatusChamado getStatusAtual() {
		return StatusChamado.valueOf(statusAtual);
	}

	public void setStatusAtual(StatusChamado statusAtual) {
		if (statusAtual != null) {
			this.statusAtual = statusAtual.getCode();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}
}
