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
import com.vinayparihar.hibernate.beans.dto.UserDetails;
import com.vinayparihar.hibernate.beans.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(1);
		userDetails.setUserName("Aadhya Parihar");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("BMW");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("PORSCHE");

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("BUGATI");

		userDetails.getVehicle().add(vehicle1);
		userDetails.getVehicle().add(vehicle2);
		userDetails.getVehicle().add(vehicle3);

		

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(userDetails);

		// Saving User to DB
		//session.save(userDetails);
		/*
		 * session.save(vehicle1); session.save(vehicle2); session.save(vehicle3);
		 */
		session.getTransaction().commit();
		session.close();

	}

}
