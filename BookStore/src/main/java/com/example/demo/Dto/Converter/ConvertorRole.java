package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.Role;

@Component
public class ConvertorRole {

	@Autowired
	public ModelMapper modelMapper;
	
	public RoleDto convertToDto(Role roleObject) {
		return modelMapper.map(roleObject, RoleDto.class);
	}
	
	public Role convertToEntity(RoleDto roleDtoObj) {
		return modelMapper.map(roleDtoObj,Role.class);
	}

}
