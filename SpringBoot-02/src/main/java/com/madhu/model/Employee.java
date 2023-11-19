package com.madhu.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private Integer eid;
	private String ename;
	private String eaddr;
	private Integer esal;
	public Employee() {
		System.out.println("Employee object created...");
	}
	
	
	public Employee(Integer eid, String ename, String eaddr, Integer esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddr = eaddr;
		this.esal = esal;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddr=" + eaddr + ", esal=" + esal + "]";
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public Integer getEsal() {
		return esal;
	}
	public void setEsal(Integer esal) {
		this.esal = esal;
	}
	
	

}
