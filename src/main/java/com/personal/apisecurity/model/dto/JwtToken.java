package com.personal.apisecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class JwtToken {

	@Getter @Setter private String token;
}
