package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Role;
@Component
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
