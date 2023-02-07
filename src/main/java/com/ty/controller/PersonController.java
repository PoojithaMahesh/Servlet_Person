package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

public class PersonController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	    String firstname=req.getParameter("firstname");
	    String lastname=req.getParameter("lastname");
	    String email=req.getParameter("email");
	    String password=req.getParameter("password");
	    long phone=Long.parseLong(req.getParameter("phone"));
	    Person person=new Person();
	    person.setEmail(email);
	    person.setFirstName(firstname);
	    person.setLastName(lastname);
	    person.setPassword(password);
	    person.setPhone(phone);
	    PersonDao dao=new PersonDao();
//	    dao.savePerson(person);
	   
	    dao.updatePerson(email, person);
	    PrintWriter printWriter=res.getWriter();
	    printWriter.print("updated succesfully");
		
	}

}
