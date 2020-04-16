package com.vinayparihar.hibernate.beans.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//Changing User defined Discriminator value(Name) for TwoWheeler Class.
//Instead of Class Name(TwoWheller) as a Discriminated,user defined name(BIKE) will be populated
@DiscriminatorValue("BIKE")
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
