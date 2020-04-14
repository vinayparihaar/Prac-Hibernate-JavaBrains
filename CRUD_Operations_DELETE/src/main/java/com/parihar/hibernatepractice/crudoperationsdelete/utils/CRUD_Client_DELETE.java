package com.parihar.hibernatepractice.crudoperationsdelete.utils;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.crudoperationsdelete.beans.Employee;

public class CRUD_Client_DELETE {

	public static void main(String[] args) {
		
		
		
		
		//Now the Student Object state is Transient
		
		Configuration configuration= new Configuration(); 
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Employee employee= new Employee();
		employee.setEmployeeId(1);
		//employee.setFirstName("Vinay");
		session.delete(employee);
		
		
		
		transaction.commit();
		//Now the student Object will be moved to Permanent Database state 
		
		/*session.evict(student);
		// Now Student Object State is detached
		//Student object will be removed form Persistent State(Hibernate)
		// Now Student Object is eligible for Garbage Collection */
		session.close();
		System.out.println("Successfully Deleted!!");
		

	}

}

