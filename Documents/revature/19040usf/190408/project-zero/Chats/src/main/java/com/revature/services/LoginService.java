package com.revature.services;

import java.security.NoSuchAlgorithmException;

import com.revature.beans.Login;
import com.revature.beans.Users;
import com.revature.daos.LoginDao;
import com.revature.util.HttpException;

public class LoginService {
LoginDao loginDao = new LoginDao();
public static int currentId = 0;
public static int roleId;

	public int loggingIn(Login login) {
		
		if(login.getPassword()== null || login.getUsername() == null) {
			System.out.println("Please enter valid values");
			throw new HttpException(422);
		}
		
		Users user = loginDao.getPasswordByUsername(login.getUsername());
		
		if(!user.getErspassword().equals(login.getPassword())) {
			System.out.println("Passwords does not match Username");
			throw new HttpException(400);
		}
		currentId =user.getErsuserid();
		roleId = user.getUserroleid();
		System.out.println(currentId);
		return user.getErsuserid();
	}
	
	public int getRole(Login login) throws NoSuchAlgorithmException{
		Users user = loginDao.getPasswordByUsername(login.getUsername());
		return user.getUserroleid();
		
	}
	
	public String getFirstName(Login login) throws NoSuchAlgorithmException{
		Users user = loginDao.getPasswordByUsername(login.getUsername());
		return user.getFirstname();
	}
	

	public String getLastName(Login login) throws NoSuchAlgorithmException{
		Users user = loginDao.getPasswordByUsername(login.getUsername());
		return user.getLastname();
	}
	
	public LoginService(LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
	}

	public LoginService() {
		super();
		this.loginDao = new LoginDao();
	}
}
