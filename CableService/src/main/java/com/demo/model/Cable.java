package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="customer33")
public class Cable {
	
	@Id
	private int custid;
	
	private String basepack;
	
	
	@Column(columnDefinition = "varchar(25) default 'None'")
	private String optionpack;


	public Cable() {
		super();
	}


	public Cable(int custid, String basepack, String optionpack) {
		super();
		this.custid = custid;
		this.basepack = basepack;
		this.optionpack = optionpack;
	}


	public int getCustid() {
		return custid;
	}


	public void setCustid(int custid) {
		this.custid = custid;
	}


	public String getBasepack() {
		return basepack;
	}


	public void setBasepack(String basepack) {
		this.basepack = basepack;
	}


	public String getOptionpack() {
		return optionpack;
	}


	public void setOptionpack(String optionpack) {
		this.optionpack = optionpack;
	}


	@Override
	public String toString() {
		return "Cable [custid=" + custid + ", basepack=" + basepack + ", optionpack=" + optionpack + "]";
	}
	
	

	
	

}
