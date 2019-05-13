package com.revature.beans;

public class Users {
	private int ersuserid;
	private String ersusername;
	private String erspassword;
	private String firstname;
	private String lastname;
	private String useremail;
	private int userroleid ;
	
	@Override
	public String toString() {
		return "users [ersuserid=" + ersuserid + ", ersusername=" + ersusername + ", erspassword=" + erspassword
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", useremail=" + useremail + ", userroleid="
				+ userroleid + "]";
	}
	public int getErsuserid() {
		return ersuserid;
	}
	public void setErsuserid(int ersuserid) {
		this.ersuserid = ersuserid;
	}
	public String getErsusername() {
		return ersusername;
	}
	public void setErsusername(String ersusername) {
		this.ersusername = ersusername;
	}
	public String getErspassword() {
		return erspassword;
	}
	public void setErspassword(String erspassword) {
		this.erspassword = erspassword;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public int getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((erspassword == null) ? 0 : erspassword.hashCode());
		result = prime * result + ersuserid;
		result = prime * result + ((ersusername == null) ? 0 : ersusername.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((useremail == null) ? 0 : useremail.hashCode());
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
		Users other = (Users) obj;
		if (erspassword == null) {
			if (other.erspassword != null)
				return false;
		} else if (!erspassword.equals(other.erspassword))
			return false;
		if (ersuserid != other.ersuserid)
			return false;
		if (ersusername == null) {
			if (other.ersusername != null)
				return false;
		} else if (!ersusername.equals(other.ersusername))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (useremail == null) {
			if (other.useremail != null)
				return false;
		} else if (!useremail.equals(other.useremail))
			return false;
		if (userroleid != other.userroleid)
			return false;
		return true;
	}
	public Users(int ersuserid, String ersusername, String erspassword, String firstname, String lastname,
			String useremail, int userroleid) {
		super();
		this.ersuserid = ersuserid;
		this.ersusername = ersusername;
		this.erspassword = erspassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.userroleid = userroleid;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
