package io.lightfeather.springtemplate.constants;

/**
 * A class that is used for Validation Constants
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

public class Validations {

	// User field names
	
	public static final String USER_FIRST_NAME = "firstName";
	public static final String USER_LAST_NAME = "lastName";
	public static final String USER_SUPERVISOR = "supervisor";
	public static final String USER_PHONE_NUMBER = "phoneNumber";
	public static final String USER_EMAIL = "email";
	
	// User error code
	
	public static final String USER_FIRST_NAME_ERROR_CODE = "firstName.empty";
	public static final String USER_LAST_NAME_ERROR_CODE = "lastName.empty";
	public static final String USER_SUPERVISOR_ERROR_CODE = "supervisor.empty";
	
	// User defaultMessage
	
	public static final String USER_FIRST_NAME_DEFAULT_MESSAGE = "First Name field is missing value";
	public static final String USER_LAST_NAME_DEFAULT_MESSAGE = "Last Name field is missing value";
	public static final String USER_SUPERVISOR_DEFAULT_MESSAGE = "Supervisor field is missing value";
	public static final String USER_PHONE_NUMBER_DEFAULT_MESSAGE = "Invalid user phone number format";
	public static final String USER_EMAIL_DEFAULT_MESSAGE = "Invalid email format in request";
		
	// Supervisor field names
	
	public static final String SUPERVISOR_FIRST_NAME = "supervisor.firstName";
	public static final String SUPERVISOR_LAST_NAME = "supervisor.lastName";
	public static final String SUPERVISOR_JURISDICTION = "supervisor.jurisdiction";
	public static final String SUPERVISOR_PHONE_NUMBER = "supervisor.phoneNumber";
	
	// Supervisor error code
	
	public static final String SUPERVISOR_FIRST_NAME_ERROR_CODE = "supervisor.firstName.empty";
	public static final String SUPERVISOR_LAST_NAME_ERROR_CODE = "supervisor.lastName.empty";
	public static final String SUPERVISOR_JURISDICTION_ERROR_CODE = "supervisor.jurisdiction.empty";
	
	// Supervisor defaultMessages
	
	public static final String SUPERVISOR_FIRST_NAME_DEFAULT_MESSAGE = "Supervisors first name is missing value";
	public static final String SUPERVISOR_LAST_NAME_DEFAULT_MESSAGE = "Supervisors last name is missing value";
	public static final String SUPERVISOR_JURISDICTION_DEFAULT_MESSAGE = "Supervisors jurisdiction is missing value";
	public static final String SUPERVISOR_PHONE_NUMBER_DEFAULT_MESSAGE = "Invalid supervisor phone number format";
}
