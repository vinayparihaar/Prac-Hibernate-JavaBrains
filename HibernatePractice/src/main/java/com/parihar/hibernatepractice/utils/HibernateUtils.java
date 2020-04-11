package com.parihar.hibernatepractice.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parihar.hibernatepractice.beans.Student;

public class HibernateUtils {

	public static void main(String[] args) {
		
		Student student= new Student();
		student.setStudentId(1);
		student.setFirstName("Vinay");
		student.setLastName("Parihar");
		student.setEmail("Vinay@gmail.com");
		student.setContactNumber("9999999999");
		//Now the Student Object state is Transient
		
		Configuration configuration= new Configuration();
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.save(student);//Moving object state to Persistent (handing over to Hibernate)
		//Now the Student Object state is Persistent
		
		session.beginTransaction().commit();;
		//Now the student Object will be moved to Permanent Database state 
		
		session.evict(student);
		//Student object will be removed form Persistent State(Hibernate)
		// Now Student Object is eligible for Garbage Collection
		
		/* session.getTransaction().commit(); */
		
		session.close();
		

	}

}
