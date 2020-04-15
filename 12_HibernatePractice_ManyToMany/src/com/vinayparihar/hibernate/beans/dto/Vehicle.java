package com.vinayparihar.hibernate.beans.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int vehilceId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToMany
	
	private Collection<UserDetails> userDetails= new ArrayList<UserDetails>();
	
	

	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Collection<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	public int getVehilceId() {
		return vehilceId;
	}

	public void setVehilceId(int vehilceId) {
		this.vehilceId = vehilceId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

	

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

}
