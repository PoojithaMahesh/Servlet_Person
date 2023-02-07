package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

public class LoginControllor extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   PrintWriter printWriter=resp.getWriter();
	   
	   String email=req.getParameter("email");
	   String password=req.getParameter("password");
	   
	Person person=new Person();
	
	
	PersonDao dao=new PersonDao();
	String password1=dao.loginPerson(email);
	if(password1.equals(password)) {
//		 RequestDispatcher dispatcher=req.getRequestDispatcher("form4.html");
//	   	 dispatcher.forward(req, resp);
	   		resp.sendRedirect("https://www.google.com/");
	}
	else {
		 RequestDispatcher dispatcher=req.getRequestDispatcher("form4.html");
	   	 dispatcher.forward(req, resp);
		
	}
	
	
}
}
