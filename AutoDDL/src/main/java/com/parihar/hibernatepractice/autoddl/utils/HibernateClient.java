package com.parihar.hibernatepractice.autoddl.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {

	public static void main(String[] args) {
		
		Configuration configuration= new Configuration();
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();

	}

}
