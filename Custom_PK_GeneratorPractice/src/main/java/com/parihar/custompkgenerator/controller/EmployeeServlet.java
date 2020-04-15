package com.parihar.custompkgenerator.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.parihar.custompkgenerator.beans.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	@Override
	public void init() throws ServletException {

		Configuration configuration = new Configuration();
		sessionFactory = configuration.configure().buildSessionFactory();

		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeeName = request.getParameter("employeeName");
		String employeeEmail = request.getParameter("employeeEmail");
		double employeeBalance = Double.parseDouble(request.getParameter("employeeBalance"));

		Employee employee = new Employee(null, employeeName, employeeEmail, employeeBalance);

		Session session = sessionFactory.openSession();
		int resp = (Integer) session.save(employee);
		Transaction transaction = session.beginTransaction();
		transaction.commit();

		response.getWriter().println("resp");

	}

	@Override
	public void destroy() {
		sessionFactory.close();
		super.destroy();
	}

}
