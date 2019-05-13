package com.revature.beans;

public class ChangePending {
private int reimbStatusId;
private int authorId;
private int reimbId;
public int getReimbStatusId() {
	return reimbStatusId;
}
public void setReimbStatusId(int reimbStatusId) {
	this.reimbStatusId = reimbStatusId;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public int getReimbId() {
	return reimbId;
}
public void setReimbId(int reimbId) {
	this.reimbId = reimbId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + authorId;
	result = prime * result + reimbId;
	result = prime * result + reimbStatusId;
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
	ChangePending other = (ChangePending) obj;
	if (authorId != other.authorId)
		return false;
	if (reimbId != other.reimbId)
		return false;
	if (reimbStatusId != other.reimbStatusId)
		return false;
	return true;
}
@Override
public String toString() {
	return "ChangePending [reimbStatusId=" + reimbStatusId + ", authorId=" + authorId + ", reimbId=" + reimbId + "]";
}
public ChangePending(int reimbStatusId, int authorId, int reimbId) {
	super();
	this.reimbStatusId = reimbStatusId;
	this.authorId = authorId;
	this.reimbId = reimbId;
}
public ChangePending() {
	super();
	// TODO Auto-generated constructor stub
}


}
