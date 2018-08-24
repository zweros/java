package com.briup.bean;

public class ShipAddress {
	private Long id;
	private String shipuname;
	private String adres;
	private String phone;
	public ShipAddress() {
	}
	public ShipAddress(String shipuname, String adres, String phone) {
		this.shipuname = shipuname;
		this.adres = adres;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShipuname() {
		return shipuname;
	}
	public void setShipuname(String shipuname) {
		this.shipuname = shipuname;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
