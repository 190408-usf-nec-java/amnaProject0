package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.RequestReimbursement;
import com.revature.util.ConnectionUtil;

public class RequestsReimbursementDao {

	public ArrayList ErsReimbusement(int currentId) {
		ArrayList<RequestReimbursement> packOfArray = new ArrayList();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "Select * from ers_reimbursement where reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, currentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbid = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				String description = rs.getString("reimb_description");
				int resolver = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				packOfArray.add(new RequestReimbursement(reimbid, amount,description, currentId, resolver,status,type));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return packOfArray;
		
	}
}
