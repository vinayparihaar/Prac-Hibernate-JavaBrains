package com.parihar.hibernatepractice.crudoperations.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperations.beans.Employee;

public class CRUD_Client_SaveorUpdate {

	public static void main(String[] args) {
		
		Employee employee= new Employee();
		employee.setFirstName("Laxmi");
		employee.setEmail("laxmi@gmail.com");
		
		Configuration configuration= new Configuration();
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		/* To make this work set it to "update" in 
		hibernate.cfg.xml<property name="hbm2ddl.auto">update</property> */
		session.saveOrUpdate(employee);
		
		transaction.commit();
		session.close();
		System.out.println("Record Inserted Successfully from CRUD_Client_SaveorUpdate Class");

	}

}
