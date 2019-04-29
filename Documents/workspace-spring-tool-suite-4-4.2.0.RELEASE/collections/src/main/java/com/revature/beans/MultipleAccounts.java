package com.revature.beans;

public class MultipleAccounts {
	
private String accountName;
private int id;

public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
	result = prime * result + id;
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
	MultipleAccounts other = (MultipleAccounts) obj;
	if (accountName == null) {
		if (other.accountName != null)
			return false;
	} else if (!accountName.equals(other.accountName))
		return false;
	if (id != other.id)
		return false;
	return true;
}
@Override
public String toString() {
	return "MultipleAccounts [accountName=" + accountName + ", id=" + id + "]";
}
public MultipleAccounts(String accountName, int id) {
	super();
	this.accountName = accountName;
	this.id = id;
}
public MultipleAccounts() {
	super();
	// TODO Auto-generated constructor stub
}

}