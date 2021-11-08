package io.lightfeather.springtemplate.exception;

/**
 * ResponseStatusErrorException is used as a custom exception
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class ResponseStatusErrorException extends ResponseStatusException {

	private final List<ObjectError> errors;
	
	/**
	 * Constructor with a parameters of status and List<ObjectError>
	 * 
	 * @param status HTTP status
	 * @param errors all the associated errors
	 */
	
	public ResponseStatusErrorException(HttpStatus status, List<ObjectError> errors) {
		super(status);
		this.errors = errors;
	}
	
	public List<ObjectError> getErrors() {
		return errors;
	}
}
