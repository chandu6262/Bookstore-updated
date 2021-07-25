package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.RentDto;
import com.example.demo.Entity.Rent;

@Component
public class ConverterRent {

	@Autowired
	public ModelMapper modelMapper;
	
	public RentDto convertToDto(Rent rentObject) {
		return modelMapper.map(rentObject, RentDto.class);
	}
	
	public Rent convertToEntity(RentDto rentDtoObj) {
		return modelMapper.map(rentDtoObj, Rent.class);
	}

}
