package com.vinayparihar.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.Address;
import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		Address officeAddress = new Address();
		officeAddress.setStreetName("Office Street Name");
		officeAddress.setCity("Office City Name");
		officeAddress.setState("Office State Name");
		officeAddress.setCountry("Office Country Name");
		officeAddress.setZipCode("Office Zip Code");
		
		Address homeAddress = new Address();
		homeAddress.setStreetName("Home Street Name");
		homeAddress.setCity("Home City Name");
		homeAddress.setState("Home State Name");
		homeAddress.setCountry("Home Country Name");
		homeAddress.setZipCode("Home Zip Code");


		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(1);
		userDetails.setUserName("Aadhya Parihar");
		userDetails.setJoiningDate(new Date());
		userDetails.setDescription("Hello World");
		
		userDetails.setOfficeAddress(officeAddress);
		userDetails.setHomeAddress(homeAddress);
		
		

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
		userDetails = (UserDetails) session.get(UserDetails.class, 0);
		System.out.println(userDetails.getUserName() + "---" + userDetails.getJoiningDate());

	}

}
