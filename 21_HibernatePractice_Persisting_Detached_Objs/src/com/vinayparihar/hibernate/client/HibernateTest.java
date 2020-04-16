package com.vinayparihar.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails userDetails=(UserDetails)session.get(UserDetails.class, 1);
		

		session.getTransaction().commit();
		session.close();
		
		//Persisting Detached Object
		//Code Starts here
		userDetails.setUserName("Hello from Hibernate");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(userDetails);
		
		session.getTransaction().commit();
		session.close();
		//Code Ends here
		
		

	}

}
