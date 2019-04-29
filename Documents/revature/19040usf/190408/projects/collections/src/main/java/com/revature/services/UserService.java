package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

import com.revature.beans.Accounts;
import com.revature.beans.MultipleAccounts;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.daos.MultipleAccountsDao;
import com.revature.daos.SELECT;
import com.revature.daos.UserDao;
import com.revature.daos.WHERE;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;

public class UserService {
	
	MultipleAccountsDao multipleAccountDao = new MultipleAccountsDao();
	AccountDao accountDao = new AccountDao();
	public static int currentAccountId = 0;
	static UserDao userDao = new UserDao();
	public static int currentUserId = 0;
	public static double balance = 0;
	public static double balences =0;
	/**
	 * Handles creation workflow for User
	 * bean
	 */
	public void createUser() {
		System.out.println("ENTER USER FIRST NAME: ");
		String firstName = ScannerUtil.getLine();
		
		System.out.println("ENTER USER LAST NAME: ");
		String lastName = ScannerUtil.getLine();
		
		System.out.println("ENTER USER EMAIL ADDRESS: " );
		String email = ScannerUtil.getLine();
		System.out.println("--------------------------------------");
		// Validate all this data
		
		User user = new User(0, firstName, lastName, email);
		
		userDao.safeSaveUser(user);
		System.out.println(user);
		System.out.println("");
	}
	
	
	
	

	@SuppressWarnings("unlikely-arg-type")
	public void getUserById() {
		Set<Integer> ids = new HashSet<>();
		Set<String> lastName = new HashSet<>();
		Boolean idExists = false;
		Set<String> idcheck = new HashSet<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select id, last_name from customers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt(1));
				lastName.add(rs.getString(2));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		while(!idExists) {
			System.out.println("");
		System.out.println("ENTER USER ID:");
		int id = ScannerUtil.getNumericChoice(10000);
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select last_name from customers WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				idcheck.add(rs.getString(1));
			}	
			System.out.println("ENTER USER LAST NAME:");
		String lastNames = ScannerUtil.getLine();

		if(idcheck.contains(lastNames) ) {
			System.out.println("");
			System.out.println("Login Successful!");
			currentUserId += id;
			idExists = true;
		}
		else {
			System.out.println("THAT IS NOT A CORRECT LOGIN IN OUR DATABASE");
			System.out.println("		PLEASE TRY AGAIN");
			System.out.println("---------------------------------------------");
		}
		
		
		}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	
	
	public void createMultipleAccounts() {
		
		
		System.out.println("ENTER AN ACCOUNT NAME: ");
		String account = ScannerUtil.getLine();
		
		MultipleAccounts multipleAccount = new MultipleAccounts(account, 0);
		
		multipleAccountDao.safeMultipleAccounts(multipleAccount);
		System.out.println(multipleAccount);
		
		//CREATES AN ACCOUNT
		}
	
	public void getAccountById() {
		
		//GETS ACCOUNT BASED ON ID AND NAME
		//IF CURRENT USER ID LOGIN DOES NOT COEXISTS WITH THE ACCOUNTID AND ACCOUNTNAME
		//DONT LOGIN TO THOSE ACCOUNTS
		//having trouble logging in with one user
		//but user can access others account based on accountid and name
		Set<Integer> accountids = new HashSet<>();
		
		Boolean idExists = false;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * from Accounts where customers_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, UserService.currentUserId);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next() ) {
				accountids.add(rs.getInt(1));
				}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
 

		
				
		while(!idExists) {
			
			System.out.println(accountids);
			System.out.println("");
			  System.out.println("ENTER USER ACCOUNT ID:"); 
			  int accountid =  ScannerUtil.getInteger(); 
			  ScannerUtil.getLine();
			  
			  
			  if(accountids.contains(accountid) ) {
				  System.out.println("");
			  System.out.println("Account Login Successful!"); 
			  currentAccountId += accountid; 
			  idExists = true; } else {
			  System.out.println("THAT ACCOUNT ID IS NOT IN OUR DATA BASE."); }
			 
		}
	}
	
@SuppressWarnings("unlikely-arg-type")
public void getJointAccountById() {
		
		Set<Integer> jointaccountids = new HashSet<>();
		Set<Integer> jointAccountCheck = new HashSet<>();
		Set<Integer> jointaccountUser = new HashSet<>();
		Boolean idExists = false;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			 
			  String sql = "SELECT account_id, customers_id from Accounts";
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next() ) {
				jointaccountids.add(rs.getInt(1));
				jointaccountUser.add(rs.getInt(2));
				}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
 

		
				
		while(!idExists) {
			System.out.println("ENTER JOINT CUSTOMER ACCOUNT ID:"); 
			// System.out.println(currentUserId);
			 int user =  ScannerUtil.getInteger(); 
		  
			  try(Connection conn = ConnectionUtil.getConnection()) {
				  
				  String sql = "SELECT account_id from Accounts where customers_id = ?";
				
				
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, user);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next() ) {
					jointAccountCheck.add(rs.getInt(1));
					}
				System.out.println("Please enter a specific account_id");
				int accountId = ScannerUtil.getInteger();
				
			  if(jointAccountCheck.contains(accountId) ) {
				  System.out.println("");
			  System.out.println("Joint Account Successful!"); 
			  
			  String sqls = 
			  		"Insert into accounts( joint_customer_id) values(?)";
				PreparedStatement psl = conn.prepareStatement(sqls);
				
				psl.setInt(1,currentUserId);

				psl.executeQuery();
			  idExists = true; } else {
			  System.out.println("THAT ACCOUNT ID IS NOT IN OUR DATA BASE."); }
			  } catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void createAccounts() {
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			System.out.println("ENTER DEPOSIT VALUE: ");
			double deposit = ScannerUtil.getDouble();
		
		
			System.out.println("ENTER WITHDRAW VALUE: ");
			double withdraw = ScannerUtil.getDouble();
			
			
			String sql = "UPDATE transaction set balance = ? from transaction where transaction_account = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, currentAccountId);
			ps.setDouble(1, (balance = (balance+deposit-withdraw)));
			Accounts accounts = new Accounts(0, deposit, withdraw, balance);
			
			accountDao.safeSaveAccounts(accounts);
			System.out.println(accounts);
		
		
		}catch(InputMismatchException e) {
			System.out.println("");
			System.out.println("Not valid numbers, please try again");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void transferMoney() {
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
	
			System.out.println("ENTER TRANSFER VALUE: ");
			double deposit = ScannerUtil.getDouble();
			System.out.println("ENTER ACCOUNT ID: ");
			int accountId = ScannerUtil.getInteger();
			String sql = "UPDATE transaction set balance = ? from transaction where transaction_account = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, currentAccountId);
			ps.setDouble(1, (balance = (balance-deposit)));
			Accounts accounts = new Accounts(0, deposit, balance);
			System.out.println("The new account balance after transfer is : " + accounts);
			
			  ps.setInt(2, accountId); ps.setDouble(1, (balences= (balences+deposit)));
			  Accounts accountSecond = new Accounts(0, deposit, balences);
			  System.out.println(accountSecond);
			 
		
		}catch(InputMismatchException e) {
			System.out.println("");
			System.out.println("Not valid numbers, please try again");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		}
	
}
