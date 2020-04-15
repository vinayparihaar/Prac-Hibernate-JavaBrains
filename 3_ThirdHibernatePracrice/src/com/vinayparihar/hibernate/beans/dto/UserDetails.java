package com.vinayparihar.hibernate.beans.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	//@EmbeddedId
	//private LogInName userId;
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

	@Column(name = "DESCRIPTION")
	// @Lob
	private String description;
	//Annotation for user defined column names for address tableS
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "streetName", column = @Column(name = "OFFICE_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
			@AttributeOverride(name = "country", column = @Column(name = "OFFICE_COUNTRY")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "OFFICE_ZIPCODE"))

	})
	private Address officeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "streetName", column = @Column(name = "HOME_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
			@AttributeOverride(name = "country", column = @Column(name = "HOME_COUNTRY")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "HOME_ZIPCODE"))

	})
	private Address homeAddress;

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

}
