package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.exception.ResourseNotFound;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<User> savePerson(@Valid @RequestBody UserDTO userDTO) {
		User u = service.saveUserDTO(userDTO);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<User> getUsers() {
		List<User> u = service.getUsers();
		return u;
	}
    
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		
		Optional<User> u = service.getUserById(id);
		if(u==null || u.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with id "+id+" is not present");
		}
		return ResponseEntity.ok().build();
	}
	
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody UserDTO dto) {
        User updatedUser = service.updateUserById(dto, id);
        return ResponseEntity.ok(updatedUser);
    }
	
	@DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
		Optional<User> u = service.getUserById(id);
		if(u==null || u.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with id "+id+" is not present");
		}
		service.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body("user deleted sucessfully");
		
	}
 
	
	
	

}
