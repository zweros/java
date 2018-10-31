package com.briup.bean;

import java.io.OutputStream;
import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = -368818489154570669L;
	private Long id; //唯一标识符,主键
	private String name; //书本名称
	private double price; //单价
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Book(Long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Book() {
		
	}
	public String toString(){
		return id+"."+name+","+price;
	}
}
