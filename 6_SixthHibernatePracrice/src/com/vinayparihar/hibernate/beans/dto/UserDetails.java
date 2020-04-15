package com.vinayparihar.hibernate.beans.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "USER_DETAILS")
// @Table(name = "USER_DETAILS")
public class UserDetails {
	// @EmbeddedId
	// private LogInName userId;
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
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
	// To create seperate table for Address class
	@ElementCollection
	//To configure user defined name for address table and user defined name for User Id foreign column of Address table
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID_FK_ADRESS"))
	//Defining primary key to Address Table(Changed listofAddress returntype from Set to List as list has index feature)
	@GenericGenerator(name = "hilo-gen",strategy = "hilo")
	@CollectionId(columns = {@Column(name="ADDRESS_ID")},generator = "hilo-gen",type=@Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

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

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

}
