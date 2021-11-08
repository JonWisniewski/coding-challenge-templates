package io.lightfeather.springtemplate.constants;

public class Validations {

	// User.java field names
	
	public static final String USER_FIRST_NAME = "firstName";
	public static final String USER_LAST_NAME = "lastName";
	public static final String USER_SUPERVISOR = "supervisor";
	public static final String USER_PHONE_NUMBER = "phoneNumber";
	public static final String USER_EMAIL = "email";
	
	// User.java error code
	
	public static final String USER_FIRST_NAME_ERROR_CODE = "firstName.empty";
	public static final String USER_LAST_NAME_ERROR_CODE = "lastName.empty";
	public static final String USER_SUPERVISOR_ERROR_CODE = "supervisor.empty";
	
	// User.java defaultMessage
	
	public static final String USER_FIRST_NAME_DEFAULT_MESSAGE = "First Name field is missing value";
	public static final String USER_LAST_NAME_DEFAULT_MESSAGE = "Last Name field is missing value";
	public static final String USER_SUPERVISOR_DEFAULT_MESSAGE = "Supervisor field is missing value";
	public static final String USER_PHONE_NUMBER_DEFAULT_MESSAGE = "Invalid phone number format";
	public static final String USER_EMAIL_DEFAULT_MESSAGE = "Invalid email format";
}
