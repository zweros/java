package com.briup.bean;

import java.io.Serializable;

//订单项，用来记录订单明细
public class OrderLine implements Serializable{
	private static final long serialVersionUID = -7460852488675734125L;
	private Long id; //唯一标识符
	private int num; //购买数量
	private Book book; //订单项上的书籍信息
	public OrderLine() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "line:"+id+",num:"+num;
	}
}
