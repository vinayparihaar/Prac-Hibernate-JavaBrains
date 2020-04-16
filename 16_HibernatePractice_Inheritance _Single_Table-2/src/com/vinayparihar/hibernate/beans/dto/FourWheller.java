package com.vinayparihar.hibernate.beans.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//Changing User defined Discriminator value(Name) for FourWheeler Class.
//Instead of Class Name(FourWheller) as a Discriminated,user defined name(CAR) will be populated
@DiscriminatorValue("CAR")
public class FourWheller extends Vehicle {

	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}

	public FourWheller() {
		// TODO Auto-generated constructor stub
	}

}
