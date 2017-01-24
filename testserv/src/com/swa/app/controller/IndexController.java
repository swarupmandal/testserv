package com.swa.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swa.app.bean.Employee;
import com.swa.app.dao.EmpDao;

public class IndexController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1573625639282703656L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setCountry(country);
		
		int insertStatus = EmpDao.save(employee);
		System.out.println("insert status >>> >> > " + insertStatus);
		
		if(insertStatus >0){
			out.print("Save Successfully");
		}
		
	}
	
	
}
