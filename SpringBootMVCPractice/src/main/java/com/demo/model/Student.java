package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="student46")
public class Student 
{
	@Id
	private int sid;
	private String sname;
	private String email;
	private String price;
	
	
	public Student() 
	{
		super();
	}


	public Student(int sid, String sname, String email) 
	{
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
