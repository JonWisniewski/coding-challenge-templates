package io.lightfeather.springtemplate.service;

import java.util.List;

/**
 * SupervisorService is used as a interface for SupervisorServiceImpl
 * 
 * @author Jonathan Wisniewski
 * @since 11-08-2021
 */

public interface SupervisorService {

	/**
	 * Calls the URI that retrieves all the supervisors from an external endpoint
	 * 
	 * @return List<String> of all supervisors
	 */

	public List<String> getAllSupervisors();
}
