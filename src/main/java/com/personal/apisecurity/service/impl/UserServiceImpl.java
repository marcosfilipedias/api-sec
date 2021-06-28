package com.personal.apisecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.apisecurity.mapper.UserMapper;
import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;
import com.personal.apisecurity.repository.UserRepository;
import com.personal.apisecurity.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	@Override
	public UserViewDTO saveUser(UserEntityDTO user) {
		
		User savedUser = userMapper.toEntity(user);
		savedUser.setUsrPassword(bCryptPasswordEncoder.encode(user.getUsrPassword()));
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
		return userRepository.findAll().stream().map(x -> new UserViewDTO(x.getUsrId(), x.getUsrName(), x.getUsrEmail(), x.getUsrStatus(), null)).collect(Collectors.toList());
	}

	@Override
	public String getProfileByLogin(String login) {
		return userRepository.getProfileByLogin(login);
	}

	@Override
	public Long getUserIdByLogin(String login) {
		return userRepository.getUserIdByLogin(login);
	}
}
