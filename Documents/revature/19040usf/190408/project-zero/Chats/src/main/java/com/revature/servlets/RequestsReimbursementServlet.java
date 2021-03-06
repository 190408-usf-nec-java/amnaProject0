package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.RequestsReimbursementDao;
import com.revature.services.LoginService;

public class RequestsReimbursementServlet extends DefaultServlet {
	RequestsReimbursementDao reimbRequest = new RequestsReimbursementDao();
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ObjectMapper om = new ObjectMapper();
	
		System.out.println(LoginService.currentId);
		reimbRequest.ErsReimbusement(LoginService.currentId);
		ArrayList packOfArray = reimbRequest.ErsReimbusement(LoginService.currentId);
		System.out.println(packOfArray);
		om.writeValue(response.getOutputStream(), packOfArray);
	}
}
