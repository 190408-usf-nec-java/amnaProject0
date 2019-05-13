package com.revature.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.beans.Users;
import com.revature.services.LoginService;
import com.revature.util.HttpException;

public class LoginServlet extends DefaultServlet {
	LoginService loginService = new LoginService();
	
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		Login login = om.readValue(request.getInputStream(), Login.class);
		
		Integer id = null; 
		Integer role = null;
		String first_name = "";
		String last_name = "";
		
		try {
			id = this.loginService.loggingIn(login);
			role = this.loginService.getRole(login);
			first_name = this.loginService.getFirstName(login);
			last_name = this.loginService.getLastName(login);
		} catch (HttpException e) {
			response.setStatus(e.getStatus());
			return;
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String cache = id + " " + login.getUsername() + " " + first_name + " " + last_name + " " + role;
		HttpSession session = request.getSession();
		
		session.setAttribute("ers_user_id", id);	
		om.writeValue(response.getOutputStream(), cache);
	}
}
