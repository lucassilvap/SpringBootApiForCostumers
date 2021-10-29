package com.example.lucassilvapessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FirstNameMustBeUniqueException extends ResponseStatusException{

	private static final long serialVersionUID = 1L;

	public FirstNameMustBeUniqueException() {
		super(HttpStatus.BAD_REQUEST, "firstName must be unique !" );
	}

}
