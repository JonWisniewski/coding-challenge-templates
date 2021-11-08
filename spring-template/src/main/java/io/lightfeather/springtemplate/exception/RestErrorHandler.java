package io.lightfeather.springtemplate.exception;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.lightfeather.springtemplate.controller.ResponseStatusErrorException;

@RestControllerAdvice
public class RestErrorHandler {

	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
	
	@ExceptionHandler(ResponseStatusErrorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException(ResponseStatusErrorException ex) {
		List<String> defaultMessageList = new ArrayList<>();
		ListIterator<ObjectError>iterator = ex.getErrors().listIterator();
		
		while(iterator.hasNext()) {
			defaultMessageList.add(iterator.next().getDefaultMessage());
		}
		
	    ErrorMessage message = new ErrorMessage(
	            HttpStatus.BAD_REQUEST.value(),
	            simpleDateFormat.format(new Date()),
	            defaultMessageList);
	    
		return message;	
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleException(Exception ex) {
	    ErrorMessage message = new ErrorMessage(
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),
	            simpleDateFormat.format(new Date()),
	            ex.getMessage());
		return message;	
	}
}
