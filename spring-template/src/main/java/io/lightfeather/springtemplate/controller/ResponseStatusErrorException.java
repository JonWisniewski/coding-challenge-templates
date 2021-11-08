package io.lightfeather.springtemplate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class ResponseStatusErrorException extends ResponseStatusException {

	private final List<ObjectError> errors;
	
	public ResponseStatusErrorException(HttpStatus status, List<ObjectError> errors) {
		super(status);
		this.errors = errors;
	}
	
	public List<ObjectError> getErrors() {
		return errors;
	}
}
