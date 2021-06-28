package com.personal.apisecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserAuthDTO {
	
	@Getter
	private Integer id;

	@Getter @Setter
	private String login;
	
	@Getter @Setter
	private String senha;

	@Getter @Setter
	private String sistema;

}
