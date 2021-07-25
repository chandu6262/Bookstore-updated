package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
	
	@JsonProperty(value = "address_id")
	private int address_id;
	@JsonProperty(value = "Hno")
	private int Hno;
	@JsonProperty(value = "street")
	private String street;

	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "state")
	private String state;
	@JsonProperty(value = "pincode")
	private int pincode;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getHno() {
		return Hno;
	}
	public void setHno(int hno) {
		Hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
