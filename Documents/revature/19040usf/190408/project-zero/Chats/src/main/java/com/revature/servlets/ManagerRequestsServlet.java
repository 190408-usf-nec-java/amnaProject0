package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ManagerReimbursementDao;
import com.revature.services.LoginService;

public class ManagerRequestsServlet extends DefaultServlet {
	ManagerReimbursementDao managerReim = new ManagerReimbursementDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		System.out.println(LoginService.currentId);
		ArrayList packOfArray = managerReim.totalUserRequest(LoginService.currentId);
		System.out.println(packOfArray);
		om.writeValue(response.getOutputStream(), packOfArray);
	}
}
