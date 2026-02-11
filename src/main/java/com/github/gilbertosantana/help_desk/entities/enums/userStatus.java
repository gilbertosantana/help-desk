package com.github.gilbertosantana.help_desk.entities.enums;

public enum userStatus {
	
	ATIVO(1),
	INATIVO(2);
	
	private int code;
	
	private userStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static userStatus valueOf(int code) {
		for(userStatus value: userStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Perfil code");
	}
}
