package io.lightfeather.springtemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.lightfeather.springtemplate.constants.URI;
import io.lightfeather.springtemplate.service.SupervisorService;

@RestController
@RequestMapping("api")
public class SupervisorController {
	

	@Autowired
	private SupervisorService supervisorService;
	
	@RequestMapping(value = URI.SUPERVISORS, method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSupervisors() {
	
		List<String> supervisorsList = supervisorService.getAllSupervisors();
		
		return new ResponseEntity<List<String>>(supervisorsList, HttpStatus.OK);
	}
}
