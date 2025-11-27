package com.github.gilbertosantana.help_desk.entities.enums;

public enum Prioridade {
	
	ALTA(1),
	MEDIA(2),
	BAIXA(3);
	
	private int code;
	
	private Prioridade(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Prioridade valueOf(int code) {
		for(Prioridade value: Prioridade.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Prioridade code");
	}
}
