package com.parihar.hibernatepractice.crudoperationsupdate.utils;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperationsupdate.beans.Employee;

public class CRUD_Client_UPDATE {

	public static void main(String[] args) {
		
		Employee employee= new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("Digamber");
		employee.setEmail("vinay@gmail.com");
		//Now the Student Object state is Transient
		
		Configuration configuration= new Configuration(); 
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.update(employee);//Moving object state to Persistent (handing over to Hibernate)
		//Now the Student Object state is Persistent
		
		
		transaction.commit();
		//Now the student Object will be moved to Permanent Database state 
		
		/*session.evict(student);
		// Now Student Object State is detached
		//Student object will be removed form Persistent State(Hibernate)
		// Now Student Object is eligible for Garbage Collection */
		session.close();
		System.out.println("Successfully Updated!!");
		

	}

}

