package com.vinayparihar.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();
		// userDetails.setUserId(1);
		userDetails.setUserName("Vinay Parihar");
		userDetails.setJoiningDate(new Date());
		userDetails.setAddress("FLORIDA");
		userDetails.setDescription("Hello World");

		UserDetails userDetails1 = new UserDetails();
		// userDetails.setUserId(1);
		userDetails1.setUserName("Aadhya Parihar");
		userDetails1.setJoiningDate(new Date());
		userDetails1.setAddress("Paris");
		userDetails1.setDescription("Hello Paris");

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Saving User to DB
		session.save(userDetails);
		session.save(userDetails1);

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
