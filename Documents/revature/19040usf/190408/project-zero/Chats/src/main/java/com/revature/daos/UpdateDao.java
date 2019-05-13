package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.ChangePending;
import com.revature.util.ConnectionUtil;
import com.revature.util.HttpException;

public class UpdateDao {
	public void managerUpdateRequest(ChangePending change) {
	try(Connection conn = ConnectionUtil.getConnection()){
	String sql = "UPDATE ers_reimbursement SET reimb_status_id = ? WHERE reimb_author = ? and reimb_id = ? and reimb_status_id = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, change.getReimbStatusId());
	ps.setInt(2, change.getAuthorId());
	ps.setInt(3, change.getReimbId());
	ps.setInt(4, 3);
	ps.executeUpdate();
	
}catch(SQLException e) {
	e.printStackTrace();
	throw new HttpException(500);
}
}
}
