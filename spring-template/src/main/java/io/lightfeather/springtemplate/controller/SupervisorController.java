package io.lightfeather.springtemplate.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.lightfeather.springtemplate.constants.URI;
import io.lightfeather.springtemplate.model.Supervisor;

@RestController
@RequestMapping("api")
@ConfigurationProperties(prefix="io.lightfeather.supervisor")
public class SupervisorController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String getEndpoint;

	@RequestMapping(value = URI.SUPERVISORS, method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSupervisors() {
	
		List<Supervisor> supervisorsList = restTemplate
				.exchange(getEndpoint, HttpMethod.GET, null, new ParameterizedTypeReference<List<Supervisor>>() {})
				.getBody();
		
		List<Supervisor> supervisorsListSorted = supervisorsList.stream()
				.sorted(Comparator.comparing(Supervisor::getJurisdiction)
				.thenComparing(Supervisor::getLastName)
				.thenComparing(Supervisor::getFirstName))
				.filter(Supervisor -> !Supervisor.getJurisdiction().matches(".*\\d.*"))
				.collect(Collectors.toList());

		List<String> supervisorsListString = supervisorsListSorted.stream()
				.map(Supervisor:: toString)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<String>>(supervisorsListString, HttpStatus.OK);
	}
}
