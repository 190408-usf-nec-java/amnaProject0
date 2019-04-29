package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.MultipleAccounts;
import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;

public class MultipleAccountsDao {


	/////THIS DAO IS SEETING THE VALUES BASED ON THE BEANS 
	
	public void safeMultipleAccounts(MultipleAccounts multipleAccounts) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO Accounts (customers_id, account_name) VALUES " + 
		"(?, ?) RETURNING account_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
		
			ps.setInt(1, UserService.currentUserId);
			//this currentUserID is based off the login in User Service once someone logs in
			ps.setString(2, multipleAccounts.getAccountName());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("account_id");
				multipleAccounts.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
