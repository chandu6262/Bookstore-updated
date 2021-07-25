package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.RentedBooksDetailsDto;
import com.example.demo.Entity.RentedBooksDetails;

@Component
public class ConverterRentedBookDetails {

	@Autowired
	public ModelMapper modelMapper;
	
	public RentedBooksDetailsDto convertToDto(RentedBooksDetails detailsObject) {
		return modelMapper.map(detailsObject, RentedBooksDetailsDto.class);
	}
	
	public RentedBooksDetails convertToEntity(RentedBooksDetailsDto detailsDtoObj) {
		return modelMapper.map(detailsDtoObj, RentedBooksDetails.class);
	}

}
