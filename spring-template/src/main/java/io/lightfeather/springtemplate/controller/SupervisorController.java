package io.lightfeather.springtemplate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import io.lightfeather.springtemplate.exception.ResponseStatusErrorException;
import io.lightfeather.springtemplate.model.User;
import io.lightfeather.springtemplate.service.SupervisorService;
import io.lightfeather.springtemplate.util.UserValidator;

/**
 * SupervisorController
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

@RestController
@RequestMapping(URIs.API)
public class SupervisorController {
	
	private static Logger logger = LoggerFactory.getLogger(SupervisorController.class);
	
	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	private UserValidator userValidator;
	
	/**
	 * Endpoint that calls api/supervisors as a GET function to gather all the supervisors
	 * and arrange them in order by jurisdiction -> last name -> first name. 
	 * After that, the supervisors are filtered out if the jurisdiction contains a number.
	 * 
	 * @return responseEntity<List<String>> returns 200 status if successful, and returns a responseBody of supervisors
	 */
	
	@RequestMapping(value = URIs.SUPERVISORS, method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSupervisors() {
	
		List<String> supervisorsList = supervisorService.getAllSupervisors();
		
		return new ResponseEntity<List<String>>(supervisorsList, HttpStatus.OK);
	}
	
	/**
	 * Endpoint that calls api/submit as a POST function to submit personal information 
	 * 
	 * @param user is to populate the user model
	 * @param errors used to hold all the fields that contain errors
	 * @return responseEntity<?> returns 201 status if creation is successful
	 */
	
	@RequestMapping(value = URIs.SUBMIT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> postSubmit(@Validated @RequestBody User user, Errors errors) {
		
		userValidator.validate(user, errors);
		
	    if (errors.hasErrors()) {
	        throw new ResponseStatusErrorException(HttpStatus.BAD_REQUEST, errors.getAllErrors());
	    }

	    logger.info(user.toString());
	    
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
