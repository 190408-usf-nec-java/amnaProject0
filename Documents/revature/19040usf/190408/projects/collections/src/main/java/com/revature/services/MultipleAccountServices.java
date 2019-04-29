package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.MultipleAccounts;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.daos.MultipleAccountsDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;

public class MultipleAccountServices {
	/*
	 * MultipleAccountsDao multipleAccountDao = new MultipleAccountsDao(); public
	 * static int currentAccountId = 0;
	 * 
	 * public void createMultipleAccounts() {
	 * 
	 * 
	 * System.out.println("Please enter account name: "); String account =
	 * ScannerUtil.getLine();
	 * 
	 * MultipleAccounts multipleAccount = new MultipleAccounts(account, 0);
	 * 
	 * multipleAccountDao.safeMultipleAccounts(multipleAccount);
	 * System.out.println(multipleAccount);
	 * 
	 * 
	 * }
	 * 
	 * public void getAccountById() { Set<Integer> accountids = new HashSet<>();
	 * Set<String> accountName = new HashSet<>();
	 * 
	 * Boolean idExists = false;
	 * 
	 * try(Connection conn = ConnectionUtil.getConnection()) { String sql =
	 * "select account_id, account_name from Accounts"; PreparedStatement ps =
	 * conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();
	 * while(rs.next()) { accountids.add(rs.getInt(1));
	 * accountName.add(rs.getString(2)); }
	 * 
	 * }catch(SQLException e) { e.printStackTrace(); }
	 * 
	 * 
	 * while(!idExists) { System.out.println("Enter the account ID:"); int accountid
	 * = ScannerUtil.getInteger(); ScannerUtil.getLine();
	 * System.out.println("Enter the account name:"); String accountNames =
	 * ScannerUtil.getLine();
	 * 
	 * if(accountids.contains(accountid) && accountName.contains(accountNames) ) {
	 * System.out.println("Account Login Successful!"); currentAccountId +=
	 * accountid; idExists = true; } else {
	 * System.out.println("That account ID is not in our database."); } } }
	 */
}
