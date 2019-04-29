package com.revature.beans;

public class Accounts {

	private int transactionNumber;
	private double deposit;
	private double withdraw;
	private double balance = 0;
	public int getTransactionNumber() {
		return transactionNumber;
	}
	
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	public Accounts(int transactionNumber, double deposit, double balance) {
		super();
		this.transactionNumber = transactionNumber;
		this.deposit = deposit;
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(deposit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transactionNumber;
		temp = Double.doubleToLongBits(withdraw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (Double.doubleToLongBits(deposit) != Double.doubleToLongBits(other.deposit))
			return false;
		if (transactionNumber != other.transactionNumber)
			return false;
		if (Double.doubleToLongBits(withdraw) != Double.doubleToLongBits(other.withdraw))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Accounts [deposit=" + deposit + ", withdraw=" + withdraw
				+ ", balance=" + balance + "]";
	}
	public Accounts(int transactionNumber, double deposit, double withdraw, double balance) {
		super();
		this.transactionNumber = transactionNumber;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.balance = balance;
	}
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	 
}
