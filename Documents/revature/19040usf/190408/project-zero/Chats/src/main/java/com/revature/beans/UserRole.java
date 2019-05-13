package com.revature.beans;

public class UserRole {
	private int userroleid ;
	private String userrole;
	
	public int getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userrole == null) ? 0 : userrole.hashCode());
		result = prime * result + userroleid;
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
		UserRole other = (UserRole) obj;
		if (userrole == null) {
			if (other.userrole != null)
				return false;
		} else if (!userrole.equals(other.userrole))
			return false;
		if (userroleid != other.userroleid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "userrole [userroleid=" + userroleid + ", userrole=" + userrole + "]";
	}
	public UserRole(int userroleid, String userrole) {
		super();
		this.userroleid = userroleid;
		this.userrole = userrole;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
