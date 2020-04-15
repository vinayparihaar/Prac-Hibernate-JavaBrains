package com.parihar.custompkgenerator.beans;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private double employeeBalance;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public double getEmployeeBalance() {
		return employeeBalance;
	}
	public void setEmployeeBalance(double employeeBalance) {
		this.employeeBalance = employeeBalance;
	}
	
	public Employee() {
		
	}
	public Employee(String employeeId, String employeeName, String employeeEmail, double employeeBalance) 
	{
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeBalance = employeeBalance;
	}
	
	

}
