package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Dto.AddressDto;
import com.example.demo.Entity.Address;

@Component
public class ConverterAddress {

	@Autowired
	public ModelMapper modelMapper;
	
	public AddressDto convertToDto(Address addressObj) {
		return modelMapper.map(addressObj, AddressDto.class);
	}
	
	public Address convertToEntity(AddressDto addressDtoObj) {
		return modelMapper.map(addressDtoObj, Address.class);
	}

}
