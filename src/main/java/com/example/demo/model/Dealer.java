package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Dealer {
	private String name;
	private String address;
	private Integer postalCode;
	
	
	public Dealer(String name, String address, Integer postalCode) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
	}
	
	
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
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
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
}
