package com.vinayparihar.hibernate.beans.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "USER_DETAILS")
// @Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name = "USER_ID")
	// @GeneratedValue
	// @GeneratedValue (strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	// @Transient
	private String userName;

	@Column(name = "JOINING_DATE")
	// @Temporal(TemporalType.DATE)
	private Date joiningDate;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DESCRIPTION")
	// @Lob
	private String description;

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

}
