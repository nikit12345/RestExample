package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.exception.ResourseNotFound;
import com.example.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceIpml implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public User saveUserDTO(UserDTO userDTO) {
		User u = new User();

		u.setAbout(userDTO.getAbout());
		u.setEmail(userDTO.getEmail());
		u.setName(userDTO.getName());
		u.setPassword(userDTO.getPassword());
		u.setPhone(userDTO.getPhone());
		return repo.save(u);

	}

	@Override
	public List<User> getUsers() {
		List<User> u = repo.findAll();
		return u;
	}

	@Override
	public User updateUSerById(UserDTO dto, Long id) throws ResourseNotFound {
		Optional<User> u = repo.findById(id);
		if(u==null || u.isEmpty()) {
			throw new ResourseNotFound("User with id "+id+" is not presentkk");
		}
		User t = new User();
		t.setAbout(dto.getAbout());
		t.setEmail(dto.getEmail());
		t.setName(dto.getName());
		t.setPassword(dto.getPassword());
		t.setPhone(dto.getPhone());
		return repo.save(t);
	}
	
	public Optional<User> getUserById( Long id) {
		return repo.findById(id);
		
	}

	@Override
	public User updateUserById(UserDTO dto, Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourseNotFound("user id with "+id+" is not present"));
		u.setAbout(dto.getAbout());
		u.setEmail(dto.getEmail());
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		u.setPhone(dto.getPhone());
		return repo.save(u);
	}

	@Override
	public void deleteUserById(Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourseNotFound("user id with "+id+" is not present"));
		repo.delete(u);
		
	}

}
