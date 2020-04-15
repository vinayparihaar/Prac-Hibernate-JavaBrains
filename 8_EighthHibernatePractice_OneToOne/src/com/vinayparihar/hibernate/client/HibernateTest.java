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
		
		Vehicle vehicle= new Vehicle();
		vehicle.setVehicleName("BMW");
		
		userDetails.setVehicle(vehicle);
		

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Saving User to DB
		session.save(userDetails);
		session.save(vehicle);

		session.getTransaction().commit();
		session.close();

		
		}

	}


