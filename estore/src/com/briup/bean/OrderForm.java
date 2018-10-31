package com.briup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//订单
public class OrderForm implements Serializable{
	private static final long serialVersionUID = -8863320089820635760L;
	private Long id;
	private double cost; //订单总额
	private Date orderdate; //下单日期
	private ShipAddress sadres;
	private Customer cus;
	private Collection<OrderLine> lines = new ArrayList<OrderLine>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public ShipAddress getSadres() {
		return sadres;
	}
	public void setSadres(ShipAddress sadres) {
		this.sadres = sadres;
	}
	public Customer getCus() {
		return cus;
	}
	public void setCus(Customer cus) {
		this.cus = cus;
	}
	public Collection<OrderLine> getLines() {
		return lines;
	}
	public void setLines(Collection<OrderLine> lines) {
		this.lines = lines;
	}
}
