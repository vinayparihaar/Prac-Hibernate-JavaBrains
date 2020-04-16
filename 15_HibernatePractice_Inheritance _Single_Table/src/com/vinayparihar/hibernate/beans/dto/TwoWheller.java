package com.vinayparihar.hibernate.beans.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheller extends Vehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	public TwoWheller() {
		// TODO Auto-generated constructor stub
	}

}
