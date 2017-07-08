package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.Role;

@Repository
public interface RoleDao {
	public int addRole(Role role);
	public Role getRole(int roleId);
	public void updateRole(Role role);
	public boolean deleteRole(int roleId);
	public List<Role> getAllRoles();
}
