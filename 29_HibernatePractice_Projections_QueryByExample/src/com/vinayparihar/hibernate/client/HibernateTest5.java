package com.vinayparihar.hibernate.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.vinayparihar.hibernate.beans.dto.UserDetails;

public class HibernateTest5 {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails exampleUser=new UserDetails();
		exampleUser.setUserName("VSP7");
		
		Example example=Example.create(exampleUser).excludeProperty("userName");
		
		
		
		Criteria criteria=session.createCriteria(UserDetails.class).add(example);
		
		
				

		
		List<UserDetails> userDetails = (List<UserDetails>) criteria.list();
		for (UserDetails userDetails2 : userDetails) {
			System.out.println(userDetails2.getUserName());

		}

		session.getTransaction().commit();
		session.close();

		System.out.println("Total Number of Users : " + userDetails.size());

		}

		
	}


