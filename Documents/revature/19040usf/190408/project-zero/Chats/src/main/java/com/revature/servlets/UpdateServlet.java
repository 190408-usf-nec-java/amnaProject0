package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ChangePending;
import com.revature.daos.RequestsReimbursementDao;
import com.revature.daos.UpdateDao;
import com.revature.services.LoginService;

public class UpdateServlet extends DefaultServlet {
	RequestsReimbursementDao requestDao = new RequestsReimbursementDao();
	UpdateDao update = new UpdateDao();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		ArrayList pendingReimbursement = requestDao.ErsReimbusement(LoginService.currentId);
		System.out.println(pendingReimbursement);
		
		om.writeValue(response.getOutputStream(), pendingReimbursement);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ObjectMapper om = new ObjectMapper();
	
		ChangePending change = om.readValue(request.getInputStream(), ChangePending.class);
		
		update.managerUpdateRequest(change);
		
}
}
