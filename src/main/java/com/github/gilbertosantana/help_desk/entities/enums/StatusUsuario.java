package com.github.gilbertosantana.help_desk.entities.enums;

public enum StatusUsuario {
	
	ATIVO(1),
	INATIVO(2);
	
	private int code;
	
	private StatusUsuario(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusUsuario valueOf(int code) {
		for(StatusUsuario value: StatusUsuario.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Perfil code");
	}
}
