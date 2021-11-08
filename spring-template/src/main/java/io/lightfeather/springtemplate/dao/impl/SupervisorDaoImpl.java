package io.lightfeather.springtemplate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import io.lightfeather.springtemplate.config.ConfigProperties;
import io.lightfeather.springtemplate.dao.SupervisorDao;
import io.lightfeather.springtemplate.model.Supervisor;

@Repository
@ConfigurationProperties(prefix="io.lightfeather.supervisor")
public class SupervisorDaoImpl implements SupervisorDao {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Override
	public List<Supervisor> getAllSupervisors() {
		
		List<Supervisor> supervisorList = restTemplate
		.exchange(configProperties.getAllSupervisorsUrlGet(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Supervisor>>() {})
		.getBody();
		
		return supervisorList;
	}
}
