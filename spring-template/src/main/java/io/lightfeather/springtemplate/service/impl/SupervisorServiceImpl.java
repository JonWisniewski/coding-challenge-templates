package io.lightfeather.springtemplate.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lightfeather.springtemplate.dao.SupervisorDao;
import io.lightfeather.springtemplate.model.Supervisor;
import io.lightfeather.springtemplate.service.SupervisorService;

@Service
public class SupervisorServiceImpl implements SupervisorService {

	@Autowired
	private SupervisorDao supervisorDao;
	
	@Override
	public List<String> getAllSupervisors() {
		
		List<Supervisor> supervisorsList = supervisorDao.getAllSupervisors();
		
		List<Supervisor> supervisorsListSorted = supervisorsList.stream()
				.sorted(Comparator.comparing(Supervisor::getJurisdiction)
				.thenComparing(Supervisor::getLastName)
				.thenComparing(Supervisor::getFirstName))
				.filter(Supervisor -> !Supervisor.getJurisdiction().matches(".*\\d.*"))
				.collect(Collectors.toList());

		List<String> supervisorsListString = supervisorsListSorted.stream()
				.map(Supervisor:: toString)
				.collect(Collectors.toList());
		
		return supervisorsListString;
	}

}
