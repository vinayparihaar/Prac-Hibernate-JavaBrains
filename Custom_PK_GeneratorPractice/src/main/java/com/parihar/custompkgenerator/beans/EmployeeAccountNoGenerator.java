package com.parihar.custompkgenerator.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class EmployeeAccountNoGenerator extends IdentityGenerator {
	
	@Override
	public Serializable generate(SessionImplementor s, Object obj) {
		String name="VSP";
		try
		{
		Connection connection =s.connection();
		
		Statement statement= connection.createStatement();
		ResultSet resultSet= statement.executeQuery("select EmployeeAccountNoGenerator.nextval from dual");
		if(resultSet.next())
		{
			name=name+resultSet.getInt(1);
		}
		
		}catch(Exception e){}
		return name;
	
	}
}
