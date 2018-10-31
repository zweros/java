package com.briup.bean;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = -1415977267636644567L;
	private Long id;
	private String name;
	private String password;
	private String zip;
	private String address;
	private String telephone;
	private String email;
	public Customer() {
	}
	public Customer(Long id, String name, String password, String zip,
			String address, String telephone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String name, String password, String zip,
			String address, String telephone, String email) {
		super();
		
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
