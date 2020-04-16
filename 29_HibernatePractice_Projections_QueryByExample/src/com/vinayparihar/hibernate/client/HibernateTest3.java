package com.vinayparihar.hibernate.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest3 {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Fetching data using criteria, projections(it will fetch only specified
		// records instead of fetching all the records)
		//.addorder displays data in specified sorted order
		Criteria criteria = session.createCriteria(UserDetails.class)
				.setProjection(Projections.count("userId"));
									
		
		
		List<Long> userDetails = (List<Long>) criteria.list();
		for (Long userDetails2 : userDetails) {

			System.out.println(userDetails2);

		}

		session.getTransaction().commit();
		session.close();

		System.out.println("Total Number of Users : " + userDetails.size());

		}

		
	}


