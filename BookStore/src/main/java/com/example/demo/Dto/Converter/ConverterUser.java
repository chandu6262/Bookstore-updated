package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;

@Component
public class ConverterUser {

	@Autowired
	public ModelMapper modelMapper;
	
	public UserDto convertToDto(User userObject) {
		return modelMapper.map(userObject, UserDto.class);
	}
	
	public User convertToEntity(UserDto userDtoObj) {
		return modelMapper.map(userDtoObj, User.class);
	}

}
