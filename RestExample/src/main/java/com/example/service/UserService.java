package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.exception.ResourseNotFound;

public interface UserService {

	User saveUserDTO( UserDTO user);
	public List<User> getUsers();
	User updateUSerById(UserDTO dto, Long id) throws ResourseNotFound;
	
	public Optional<User> getUserById(Long id);
	
	public User updateUserById(UserDTO dto, Long id);
	
	public void deleteUserById(Long id);
	}
