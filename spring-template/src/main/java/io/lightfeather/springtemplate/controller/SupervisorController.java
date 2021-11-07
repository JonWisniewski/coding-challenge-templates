package io.lightfeather.springtemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.lightfeather.springtemplate.constants.URI;
import io.lightfeather.springtemplate.model.Supervisor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class SupervisorController {
	
	@Value("${io.lightfeather.get.supervisor.url}")
	private String getSupervisors;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home() {
		return "Hello World";
	}
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping(value = URI.SUPERVISORS, method = RequestMethod.GET)
	public ResponseEntity<List<Supervisor>> getSupervisors() {
	
		Mono<List<Supervisor>> response = webClientBuilder.build()
		.get()
		.uri("https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers")
		.retrieve()
		.bodyToMono(new ParameterizedTypeReference<List<Supervisor>>() {});
		
		List<Supervisor> supervisors = response.block();
		
		return new ResponseEntity<List<Supervisor>>(supervisors, HttpStatus.OK);
	}
}
