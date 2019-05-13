package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.RequestReimbursement;
import com.revature.services.LoginService;
import com.revature.util.ConnectionUtil;
import com.revature.util.HttpException;

public class SubmitsReimbursementDao {
public void Types(RequestReimbursement ersReimbursement) {
	try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "Insert into ers_reimbursement(reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id )"
				+ "Values (?,?,?,?,?,?) Returning reimb_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, ersReimbursement.getReimbAmount());
		ps.setString(2, ersReimbursement.getReimbDescription());
		ps.setInt(3, LoginService.currentId);
		ps.setInt(4, ersReimbursement.getReimbResolver());
		ps.setInt(5,ersReimbursement.getReimbStatusId());
		ps.setInt(6, ersReimbursement.getReimbTypeId());
		
		System.out.println(LoginService.currentId);
		System.out.println("Reached this point SubmitDao");
	
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("reimb_id");
			ersReimbursement.setReimbId(id);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new HttpException(500);
	}
	
}

}
