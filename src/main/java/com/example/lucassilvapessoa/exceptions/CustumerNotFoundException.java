package com.example.lucassilvapessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustumerNotFoundException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public CustumerNotFoundException(Long id) {
		super(HttpStatus.BAD_GATEWAY, "costumer with id :" + id +" Not found!");
	}
}
