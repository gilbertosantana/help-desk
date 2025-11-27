package com.github.gilbertosantana.help_desk.entities.enums;

public enum Perfil {
	
	COMUM(1),
	SUPORTE(2),
	ADMINISTRADOR(3);
	
	private int code;
	
	private Perfil(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Perfil valueOf(int code) {
		for(Perfil value: Perfil.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Perfil code");
	}
}
