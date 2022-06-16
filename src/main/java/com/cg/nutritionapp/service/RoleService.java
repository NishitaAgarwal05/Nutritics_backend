package com.cg.nutritionapp.service;

import java.util.Collection;
import java.util.Optional;

import com.cg.nutritionapp.model.Role;

public interface RoleService{

	Role findByName(String name);
	public Collection<Role> findAll();
	public Optional<Role> findById(Long id);
	public Role saveOrUpdate(Role role);
	public String deleteById(Long id);
	
}
