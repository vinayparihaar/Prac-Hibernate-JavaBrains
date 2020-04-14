package com.parihar.hibernatepractice.autoddl.beans;

public class ContactInformation {

	private int contactId;
	private String email;
	private String phone;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ContactInformation() {

	}

}
