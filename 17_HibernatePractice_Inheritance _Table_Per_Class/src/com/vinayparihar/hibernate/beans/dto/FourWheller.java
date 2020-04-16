package com.vinayparihar.hibernate.beans.dto;

import javax.persistence.Entity;

@Entity
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
