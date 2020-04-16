package com.vinayparihar.hibernate.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.Address;
import com.vinayparihar.hibernate.beans.dto.FourWheller;
import com.vinayparihar.hibernate.beans.dto.TwoWheller;
import com.vinayparihar.hibernate.beans.dto.UserDetails;
import com.vinayparihar.hibernate.beans.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");

		FourWheller fourWheller = new FourWheller();
		fourWheller.setVehicleName("JEEP");
		fourWheller.setStreeingWheel("Jeep Streeing Wheel");

		TwoWheller twoWheller = new TwoWheller();
		twoWheller.setVehicleName("DUKATI");
		twoWheller.setSteeringHandle("DUCATI STEERING HANDEL");

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vehicle);
		session.save(fourWheller);
		session.save(twoWheller);

		
		  session.getTransaction().commit();
		  session.close();
		 
	}

}
