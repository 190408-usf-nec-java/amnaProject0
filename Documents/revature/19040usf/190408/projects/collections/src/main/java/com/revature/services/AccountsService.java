package com.revature.services;

import java.util.InputMismatchException;
import java.util.List;

import com.revature.beans.Accounts;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.util.ScannerUtil;

public class AccountsService {
	
	AccountDao accountDao = new AccountDao();
	
	
	public void createAccounts() {
		
		double balance = -1;
		double deposit= -1;
		double withdraw = -1;
		
		try {
		
		while(balance<0 || deposit<0 || withdraw<0 ) {
		System.out.println("Please enter deposit value: ");
		deposit = ScannerUtil.getDouble();
		
		
		System.out.println("Please enter withdraw value: ");
		withdraw = ScannerUtil.getDouble();
		
		
		balance = (deposit-withdraw);
		
		}
		Accounts accounts = new Accounts(0, deposit, withdraw, balance);	
		
		accountDao.safeSaveAccounts(accounts);
		
		System.out.println(accounts);
		}catch(InputMismatchException e) {
			System.out.println("Not valid numbers, please try again");
		}
		
		}
		
	}
		

