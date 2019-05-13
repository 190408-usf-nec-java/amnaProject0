package com.revature.services;
import com.revature.beans.Users;
import com.revature.daos.UserDao;

public class UserService {
private UserDao userDao = new UserDao();
	public boolean signup(Users user) {
		
		return userDao.Signup(user);
		
		
	}
}
