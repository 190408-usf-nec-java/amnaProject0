package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Accounts;
import com.revature.beans.User;
import com.revature.services.MultipleAccountServices;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;

public class AccountDao {


	public void safeSaveAccounts(Accounts accounts) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO transactions (transactions_account, deposit, withdraw, balance) VALUES "
					+ "(?, ?, ?, ?) RETURNING transaction_id";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(2, accounts.getDeposit());
			ps.setDouble(3, accounts.getWithdraw());
			ps.setDouble(4, accounts.getBalance());
			ps.setDouble(1, UserService.currentAccountId);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("transaction_id");
				accounts.setTransactionNumber(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	  public Accounts getAccountsById(int id) { Accounts accounts = null;
	  
	  try (Connection conn = ConnectionUtil.getConnection()) { String sql =
	  "SELECT deposit, withdraw, balance FROM transactions WHERE transactions_id = ?"
	  ; PreparedStatement ps = conn.prepareStatement(sql);
	  
	  ps.setInt(1, id);
	  
	  ResultSet rs = ps.executeQuery(); if (rs.next()) { double deposit =
	  rs.getDouble("deposit"); double withdraw = rs.getDouble("withdraw"); double
	  balance = rs.getDouble("balance"); accounts = new Accounts(id, deposit,
	  withdraw, balance); } } catch (SQLException e) { e.printStackTrace(); }
	  
	  return accounts; }
	 

}
