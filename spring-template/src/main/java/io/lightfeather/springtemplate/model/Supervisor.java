package io.lightfeather.springtemplate.model;

public class Supervisor {
	
	public Supervisor(String firstName, String id, String identificationNumber, String jurisdiction, String lastName,
			String phone) {
		
		this.firstName = firstName;
		this.id = id;
		this.identificationNumber = identificationNumber;
		this.jurisdiction = jurisdiction;
		this.lastName = lastName;
		this.phone = phone;
	}
	private String firstName;
	private String id;
	private String identificationNumber;
	private String jurisdiction;
	private String lastName;
	private String phone;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
