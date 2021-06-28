package com.personal.apisecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

	@Getter @Setter
	private Integer usrId;
	
	@Getter @Setter
	private String usrName;
	
	@Getter @Setter
	private String usrEmail;
	
	@Getter @Setter
	private Boolean usrStatus;
	
	@Getter @Setter
	private Integer idProfile;

}
