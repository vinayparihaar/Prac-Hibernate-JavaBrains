package com.parihar.hibernatepractice.crudoperations.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperations.beans.Employee;

public class CRUD_Client_Persist {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setFirstName("Thakur");
		employee.setEmail("Thakur@gmail.com");

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.evict(employee);
		session.persist(employee);

		// session.flush();

		transaction.commit();
		session.close();
		System.out.println("Employee record inserted Successfully!!!");

	}

}

/*
 * Employee employee = new Employee(); employee.setEmployeeId(2);
 * employee.setFirstName("Aadhya"); employee.setEmail("aadhya@gmail.com");
 * 
 * Configuration configuration = new Configuration(); SessionFactory
 * sessionFactory = configuration.configure().buildSessionFactory();
 * 
 * Session session = sessionFactory.openSession();
 * 
 * session.persist(employee);
 * 
 * Transaction transaction = session.beginTransaction(); transaction.commit();
 * System.out.println("Employee record inserted Successfully!!!");
 */
