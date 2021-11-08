package io.lightfeather.springtemplate.model;

/**
 * User model
 * 
 * @author Jonathan Wisniewski
 * @since 11-08-2021
 */

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Supervisor supervisor;

	/**
	 * Constructor with parameters of firstName, lastName, email, phoneNumber, and supervisor
	 * 
	 * @param firstName the users first name
	 * @param lastName the users last name
	 * @param email the users email
	 * @param phoneNumber the users phone number
	 * @param supervisor the supervisor model
	 */
	
	public User(String firstName, String lastName, String email, String phoneNumber, Supervisor supervisor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.supervisor = supervisor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", supervisor=" + supervisor + "]";
	}

}
