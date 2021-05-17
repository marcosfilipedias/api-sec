package com.personal.apisecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.mapper.UserMapper;
import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;
import com.personal.apisecurity.repository.UserRepository;
import com.personal.apisecurity.service.TokenService;
import com.personal.apisecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	private TokenService tokenService;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TokenService tokenService) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.tokenService = tokenService;
	}

	@Override
	public UserViewDTO saveUser(UserEntityDTO user) {
		
		User savedUser = userMapper.toEntity(user);		
		savedUser.setToken(tokenService.generateToken(user));		
		savedUser = userRepository.saveAndFlush(savedUser);
		
		return userMapper.toViewDto(savedUser);
	}

	@Override
	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return getUserById(id) == null;
	}

	@Override
	public UserViewDTO getUserById(Long id) {
		try {
			return userMapper.toViewDto(userRepository.findById(id).get());
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<UserViewDTO> getAllUsers() {
		return userRepository.findAll().stream().map(x -> new UserViewDTO(x.getUsrId(), x.getUsrName(), x.getUsrEmail(), x.getUsrStatus())).collect(Collectors.toList());
	}

	@Override
	public UserEntityDTO getUserByEmail(String email) throws InvalidLoginException {	
		User user = userRepository.getUserByLogin(email);
		if(user != null) {
			return userMapper.toDto(user);
		}else {
			throw new InvalidLoginException("Email not found!");
		}
	}

}
