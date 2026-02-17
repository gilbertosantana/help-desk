package com.github.gilbertosantana.help_desk.entities.enums;

public enum UserStatus {
	
	ATIVO(1),
	INATIVO(2);
	
	private int code;
	
	private UserStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static UserStatus valueOf(int code) {
		for(UserStatus value: UserStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Perfil code");
	}
}
