package com.personal.apisecurity.model.dto;

/**
 * Classe DTO utilizada para representar atributos do usuario que serão
 * utilizados no token de acesso ao sistema
 *
 */
public class UserTokenDetailsDTO {

	private Integer id;

	public UserTokenDetailsDTO() {
		super();
	}

	public UserTokenDetailsDTO(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
