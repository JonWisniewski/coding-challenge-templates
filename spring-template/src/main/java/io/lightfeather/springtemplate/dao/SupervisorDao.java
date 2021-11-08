package io.lightfeather.springtemplate.dao;

import java.util.List;

import io.lightfeather.springtemplate.model.Supervisor;

/**
 * SupervisorDao is used as a interface for SupervisorDaoImpl
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

public interface SupervisorDao {

	/**
	 * Calls the URI that retrieves all the supervisors from an external endpoint
	 * @return List<Supervisor> of all supervisors
	 */
	
	public List<Supervisor> getAllSupervisors(); 
}
