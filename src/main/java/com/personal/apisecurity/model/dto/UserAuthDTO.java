package com.personal.apisecurity.model.dto;

public class UserAuthDTO {

	private String login;

	private String senha;
	
	private String sistema;

	private boolean autenticado;
	
	public UserAuthDTO() {
	}

	public UserAuthDTO(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public UserAuthDTO(String login, boolean autenticado) {
		this.login = login;
		this.autenticado = autenticado;
	}

	// getters and setters

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

}
