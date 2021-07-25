package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Orders;

@Component
public class ConverterOrder {

	@Autowired
	public ModelMapper modelMapper;

	public OrderDto convertToDto(Orders orderObject) {
		return modelMapper.map(orderObject, OrderDto.class);
	}

	public Orders convertToEntity(OrderDto orderDtoObj) {
		return modelMapper.map(orderDtoObj, Orders.class);
	}

}
