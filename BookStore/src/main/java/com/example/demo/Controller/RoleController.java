package com.example.demo.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.Role;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping
public class RoleController {


	@Autowired
	private RoleService roleService;
  

	@PostMapping("/role/post")
	public RoleDto addRoles(@Valid @RequestBody Role role)
	{	
		return roleService.addAllRole(role);
	}

	
}
