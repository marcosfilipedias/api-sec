package com.personal.apisecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.personal.apisecurity.mapper.UserMapper;
import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;
import com.personal.apisecurity.repository.UserRepository;
import com.personal.apisecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserEntityDTO saveUser(UserEntityDTO user) {
		User savedUser = userRepository.saveAndFlush(userMapper.toEntity(user));	
		return userMapper.toDto(savedUser);
	}

	@Override
	public Boolean deleteUser(Integer id) {
		userRepository.deleteById(id);
		return getUserById(id) == null;
	}

	@Override
	public UserViewDTO getUserById(Integer id) {
		return userMapper.toViewDto(userRepository.findById(id).get());
	}

	@Override
	public List<UserViewDTO> getAllUsers() {
		return userRepository.findAll().stream().map(x -> new UserViewDTO(x.getUsrId(), x.getUsrName(), x.getUsrEmail(), x.getUsrStatus())).collect(Collectors.toList());
	}

}
