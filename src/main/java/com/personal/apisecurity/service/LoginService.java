package com.personal.apisecurity.service;

import com.personal.apisecurity.exception.InvalidLoginException;

public interface LoginService {

	public String login(String username, String password, String system) throws InvalidLoginException;
}
