package com.parihar.hibernatepractice.crudoperations.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperations.beans.Employee;

public class CRUD_Client_Save {

	public static void main(String[] args) {
		
		Employee employee= new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("Vinay");
		employee.setEmail("vinay@gmail.com");
		//Now the Student Object state is Transient
		
		Configuration configuration= new Configuration();
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		int result=(Integer)session.save(employee);//Moving object state to Persistent (handing over to Hibernate)
		//Now the Student Object state is Persistent
		
		
		transaction.commit();
		//Now the student Object will be moved to Permanent Database state 
		
		/*session.evict(student);
		// Now Student Object State is detached
		//Student object will be removed form Persistent State(Hibernate)
		// Now Student Object is eligible for Garbage Collection */
		session.close();
		sessionFactory.close();
		System.out.println("Employee "+ result+" record inserted Successfully!!!");
		

	}

}

