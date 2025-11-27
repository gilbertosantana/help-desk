package com.github.gilbertosantana.help_desk.entities.enums;

public enum StatusChamado {
	
	ABERTO(1),
	EM_ANALISE(2),
	AGUARDANDO_USUARIO(3),
	FINALIZADO(4),
	CANCELADO(5);
	
	private int code;
	
	private StatusChamado(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusChamado valueOf(int code) {
		for(StatusChamado value: StatusChamado.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusChamado code");
	}
}
