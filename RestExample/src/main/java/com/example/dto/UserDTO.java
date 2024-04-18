package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Size(min=10 , message="enter valid mobile no")
	private String phone;
	@NotEmpty
	@Email(message="enter valid mobile email")
	private String email;
	@NotEmpty()
	@Size(min=8,message="enter valid mobile email")
	private String password;
	@NotEmpty
	private String about;

}
