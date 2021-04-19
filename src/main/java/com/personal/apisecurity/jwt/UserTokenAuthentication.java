package com.personal.apisecurity.jwt;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserTokenAuthentication extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	public UserTokenAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	public UserTokenAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// true se for o mesmo objeto
		if (this == obj) {
			return true;
		}
		// Falso se o equals da superclasse não retornar true
		if (!super.equals(obj)) {
			return false;
		}

		// Falso se for de classe diferente
		return getClass() == obj.getClass();
	}

}
