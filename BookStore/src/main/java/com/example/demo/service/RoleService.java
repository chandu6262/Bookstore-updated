package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.RoleDto;
import com.example.demo.Dto.Converter.ConvertorRole;
import com.example.demo.Entity.Role;
import com.example.demo.Respository.RoleRepository;

@Component
public class RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	ConvertorRole converterService;

	public RoleDto addAllRole(Role role)
	{
		Role r = roleRepo.save(role);    //add user
		return converterService.convertToDto(r);
	}
}
