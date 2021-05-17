package com.personal.apisecurity.service;

import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.model.dto.UserAuthDTO;
import com.personal.apisecurity.model.dto.UserCredentialsDTO;

public interface AuthService {

	UserAuthDTO authenticate(UserCredentialsDTO userLogin, String token) throws InvalidLoginException;

}
