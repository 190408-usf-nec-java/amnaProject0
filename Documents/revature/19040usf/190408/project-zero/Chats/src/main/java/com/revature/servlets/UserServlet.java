package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Users;
import com.revature.services.UserService;

public class UserServlet extends DefaultServlet {
	
	UserService userService = new UserService();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ObjectMapper om = new ObjectMapper();
		Users user = om.readValue(request.getInputStream(), Users.class);

		// Pass credentials to service
		boolean result = userService.signup(user);

		if (result) {
			response.setStatus(200);
		} else {
			response.setStatus(409);
		}
		
	}
}
