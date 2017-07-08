package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Role;


@Repository (value="roleDao")
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory session;
	
	public int addRole(Role role) {
		session.getCurrentSession().save(role);
		int id = role.getId();
		
		return id;
	}

	public Role getRole(int roleId) {
		return session.getCurrentSession().get(Role.class, roleId);
	}

	public void updateRole(Role role) {
		session.getCurrentSession().update(role);
	}

	public boolean deleteRole(int roleId) {
		session.getCurrentSession().delete(roleId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		return (List<Role>) session.getCurrentSession().createQuery("from Role").list();
	}
	
}
