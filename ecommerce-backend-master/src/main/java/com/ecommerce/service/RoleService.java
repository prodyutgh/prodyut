package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Role;

@Service
public interface RoleService {
	public int addRole(Role role);
	public Role getRole(int roleId);
	public void updateRole(Role role);
	public boolean deleteRole(int roleId);
	public List<Role> getAllRoles();
}
