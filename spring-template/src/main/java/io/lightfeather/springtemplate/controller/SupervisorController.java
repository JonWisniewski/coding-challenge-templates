package io.lightfeather.springtemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.lightfeather.springtemplate.constants.URIs;
import io.lightfeather.springtemplate.model.User;
import io.lightfeather.springtemplate.service.SupervisorService;
import io.lightfeather.springtemplate.util.UserValidator;

@RestController
@RequestMapping("api")
public class SupervisorController {
	
	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = URIs.SUPERVISORS, method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSupervisors() {
	
		List<String> supervisorsList = supervisorService.getAllSupervisors();
		
		return new ResponseEntity<List<String>>(supervisorsList, HttpStatus.OK);
	}
	
	@RequestMapping(value = URIs.SUBMIT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<String>> postSubmit(@Validated @RequestBody User user, Errors errors) {
		
		userValidator.validate(user, errors);
		
	    if (errors.hasErrors()) {
	        throw new ResponseStatusErrorException(HttpStatus.BAD_REQUEST, errors.getAllErrors());
	    }
		
		return null;
	}
}
