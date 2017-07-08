package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.model.Role;

@Transactional
@Service (value="roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public int addRole(Role role) {
		return roleDao.addRole(role);
		//return user.getId();
	}

	public Role getRole(int roleId) {
		return roleDao.getRole(roleId);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	public boolean deleteRole(int roleId) {
		return roleDao.deleteRole(roleId);
		//return true;
	}

	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
