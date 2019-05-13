package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Login;
import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;
import com.revature.util.HttpException;

public class LoginDao {
	public static int currentUserRole = 0;
	public Users getPasswordByUsername(String username) {
	 try(Connection conn = ConnectionUtil.getConnection()){
		 String sql = "Select * from ers_users where ers_username = ?";
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, username);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {
			 int id = rs.getInt("ers_user_id");
			 String password =  rs.getString("ers_password");
			 String firstName = rs.getString("user_first_name");
			 String lastName = rs.getString("user_last_name");
			 String email = rs.getString("user_email");
			 int roleID = rs.getInt("user_role_id");
			 currentUserRole += roleID;
			 return new Users(id, username, password, firstName, lastName, email, roleID);
			 
		 }else {
				throw new HttpException(400);
		 }
	 } catch (SQLException e) {
		e.printStackTrace();
		throw new HttpException(500);
	}
 }
}
