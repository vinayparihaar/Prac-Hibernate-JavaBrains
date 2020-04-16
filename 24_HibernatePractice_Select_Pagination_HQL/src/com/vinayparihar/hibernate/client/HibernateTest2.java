package com.vinayparihar.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest2 {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Pulling only User Name instead of pulling complete data
		Query query = session.createQuery("select userName from USER_DETAILS");
		// Configuring Pageination in HQL
		// Telling Hibernate from what index it needs to pull data instead of pulling
		// complete data
		query.setFirstResult(3);
		// Telling Hibernate maximum how many record should be pulled.
		query.setMaxResults(4);
		// To pull just UserName it should be (List<String>) as user names are String
		List<String> userNames = (List<String>) query.list();
		for (String users : userNames) {
			System.out.println(users);

		}

		session.getTransaction().commit();
		session.close();

		System.out.println("Total Number of Users : " + userNames.size());

	}

}
