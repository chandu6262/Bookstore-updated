package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentedBooksDetailsDto {
	@JsonProperty(value = "user_id") 
	private int rentedDetails_id;

	@JsonProperty(value = "user_id") 
	private int issuedquantity;

	@JsonProperty(value = "user_id") 
	private int returnedquantity;

	@JsonProperty(value = "user_id") 
	private float amount;

	public int getRentedDetails_id() {
		return rentedDetails_id;
	}

	public void setRentedDetails_id(int rentedDetails_id) {
		this.rentedDetails_id = rentedDetails_id;
	}

	public int getIssuedquantity() {
		return issuedquantity;
	}

	public void setIssuedquantity(int issuedquantity) {
		this.issuedquantity = issuedquantity;
	}

	public int getReturnedquantity() {
		return returnedquantity;
	}

	public void setReturnedquantity(int returnedquantity) {
		this.returnedquantity = returnedquantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
