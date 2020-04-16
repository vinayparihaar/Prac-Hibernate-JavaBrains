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
		
		String minUserId="5";
		String userName="VSP9";

		Query query = session.createQuery("from USER_DETAILS where userId > :userId and userName = :userName");
		//Passing parameters to place holders
		query.setInteger("userId",Integer.parseInt(minUserId) );
		query.setString("userName", userName);
		
		
		List<UserDetails> userDetails = (List<UserDetails>) query.list();
		for (UserDetails userDetails2 : userDetails) {
			System.out.println(userDetails2.getUserName());

		}

		session.getTransaction().commit();
		session.close();

		System.out.println("Total Number of Users : " + userDetails.size());

	}

}
