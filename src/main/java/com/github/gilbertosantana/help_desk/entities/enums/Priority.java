package com.github.gilbertosantana.help_desk.entities.enums;

public enum Priority {
	
	ALTA(1),
	MEDIA(2),
	BAIXA(3);
	
	private int code;
	
	private Priority(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Priority valueOf(int code) {
		for(Priority value: Priority.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Prioridade code");
	}
}
