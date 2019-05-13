package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.RequestReimbursement;
import com.revature.services.LoginService;
import com.revature.util.ConnectionUtil;

public class ManagerReimbursementDao {
	public ArrayList totalUserRequest(int currentId) {
		
	ArrayList<RequestReimbursement> managerRequests = new ArrayList();
		try(Connection conn = ConnectionUtil.getConnection()){
	
			String sql = "Select * from ers_reimbursement where reimb_author!=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, LoginService.currentId);
			ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		int reimbid = rs.getInt("reimb_id");
		int amount = rs.getInt("reimb_amount");
		String description = rs.getString("reimb_description");
		int authorid = rs.getInt("reimb_author");
		int resolver = rs.getInt("reimb_resolver");
		int status = rs.getInt("reimb_status_id");
		int type = rs.getInt("reimb_type_id");
		
		managerRequests.add(new RequestReimbursement(reimbid, amount, description, authorid, resolver, status,type));
	}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return managerRequests;
}
}
