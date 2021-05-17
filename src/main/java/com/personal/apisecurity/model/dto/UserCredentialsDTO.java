package com.personal.apisecurity.model.dto;

public class UserCredentialsDTO {
	
	private String email;
	
	private String password;
	
	//TODO: Implementação destinanda a N sistemas.
	private String system;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	
}
