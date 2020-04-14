package com.parihar.hibernatepractice.crudoperationsupdate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperationsupdate.beans.Employee;

public class CRUD_Client_MERGE {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("Digamber");
		employee.setEmail("vinay@gmail.com");
		// Now the Student Object state is Transient

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.get(Employee.class, 1);

		/*
		 * We will get error if we use (session.update(employee); with
		 * session.get(Employee.class, 1); Exception in thread "main"
		 * org.hibernate.NonUniqueObjectException: a different object with the same
		 * identifier value was already associated with the session:
		 * [com.parihar.hibernatepractice.crudoperationsupdate.beans.Employee#1]
		 * 
		 * So change it to session.merge(employee);
		 */
		// session.update(employee);

		session.merge(employee);

		transaction.commit();

		session.close();
		System.out.println("Successfully Updated!!");

	}

}
