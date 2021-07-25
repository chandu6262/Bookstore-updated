package com.example.demo.Dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDto {
	@JsonProperty(value = "user_id") 
	private int order_id;

	@JsonProperty(value = "user_id") 
	private int quantity;

	@JsonProperty(value = "user_id") 
	private float total_price;

	@JsonProperty(value = "user_id") 
	private Date date_of_order;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Date getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(Date date_of_order) {
		this.date_of_order = date_of_order;
	}

}
