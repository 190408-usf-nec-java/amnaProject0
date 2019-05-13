package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class UserDao {
	public boolean Signup(Users user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql ="INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES"
					+ "(?, ?, ?, ?, ?,?) RETURNING ers_user_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// Assigning parameters
			ps.setString(1, user.getErsusername());
			ps.setString(2, user.getErspassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getUseremail());
			ps.setInt(6, user.getUserroleid());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("ers_user_id");
				
				user.setErsuserid(id);;
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
	}
		return false;
	}
}
