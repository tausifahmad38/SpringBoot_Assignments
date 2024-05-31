package com.springboot.example;

public class Branch {
	
	private String name;
	private String address;
	
	public Branch() {
		
	}
	
	public Branch(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
