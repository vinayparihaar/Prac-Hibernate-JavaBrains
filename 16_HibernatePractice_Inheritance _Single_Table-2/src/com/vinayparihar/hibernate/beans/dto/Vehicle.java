package com.vinayparihar.hibernate.beans.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "VEHICLE")
//Annotation to define what strategy need to be implemented for inheritance
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//Defining user defined name for the discriminator Column name and defining discriminator type 
//Configuring how this discriminator is generated(Name & Type).
@DiscriminatorColumn(name = "VEHICLE_TYPE",
					discriminatorType = DiscriminatorType.STRING
					)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")

	private int vehilceId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

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
