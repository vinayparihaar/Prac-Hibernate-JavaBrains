package com.vinayparihar.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.Address;
import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(1);
		userDetails.setUserName("Aadhya Parihar");
		userDetails.setJoiningDate(new Date());
		userDetails.setDescription("Hello World");

		Address address = new Address();
		address.setStreetName("Street Name");
		address.setCity("City Name");
		address.setState("State Name");
		address.setCountry("Country Name");
		address.setZipCode("Zip Code");

		userDetails.setAddress(address);

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Saving User to DB
		session.save(userDetails);

		session.getTransaction().commit();
		session.close();

		userDetails = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		// Fetching User details from DB
		userDetails = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println(userDetails.getUserName() + "---" + userDetails.getJoiningDate());

	}

}
