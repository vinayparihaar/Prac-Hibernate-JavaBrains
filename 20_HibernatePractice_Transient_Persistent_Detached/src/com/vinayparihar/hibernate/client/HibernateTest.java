package com.vinayparihar.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();
		/*
		 * Now the State of an Object is Transient Before Handing over this object to
		 * hibernate its in Transient State Transient objects are not racked by
		 * Hibernate
		 */
		userDetails.setUserName("Hello World");

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * Now the State of an Object is Persistent, after handing over this object to
		 * hibernate its in Persistent State, Persistent objects are tracked by
		 * Hibernate for any ongoing changes until session is closed.
		 */
		session.save(userDetails);

		userDetails.setUserName("Hello World Again");

		session.getTransaction().commit();
		session.close();

		/*
		 * Now the State of an Object is Detached, after closing the session the state
		 * of this bject to in Detached State, Detached objects are not tracked by
		 * Hibernate. It also means This Object was previously tracked by Hibernate.
		 * 
		 */
		userDetails.setUserName("Hello World Once Again");

	}

}
