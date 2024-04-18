package com.example.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Builder
public class ApiResponse {
	
	private String message;
	private boolean sucess;
	private HttpStatus status;
	public ApiResponse(String message, boolean sucess, HttpStatus status) {
		super();
		this.message = message;
		this.sucess = sucess;
		this.status = status;
	}
	
	

	

}
