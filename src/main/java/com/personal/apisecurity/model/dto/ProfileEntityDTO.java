package com.personal.apisecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntityDTO {

	@Getter @Setter
	private Integer Id;
	
	@Getter @Setter
	private String prfName;
	
}
