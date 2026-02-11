package com.github.gilbertosantana.help_desk.entities.enums;

public enum Profile {
	
	COMUM(1),
	SUPORTE(2),
	ADMINISTRADOR(3);
	
	private int code;
	
	private Profile(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Profile valueOf(int code) {
		for(Profile value: Profile.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Perfil code");
	}
}
