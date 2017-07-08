package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.User;
import com.ecommerce.model.UserSupplier;
import com.ecommerce.service.UserService;


@Repository (value="userSupplierDao")
@Transactional
public class UserSupplierDaoImpl implements UserSupplierDao{

	@Autowired
	private SessionFactory session;
	
	public int addSupplier(UserSupplier supplier) {
		session.getCurrentSession().save(supplier);
		int id = supplier.getId();
		
		return id;
	}

	public UserSupplier getSupplier(int userId) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserSupplier.class);
		criteria.add(Restrictions.eq("user.id", userId));
		UserSupplier userSupplier = (UserSupplier) criteria.uniqueResult();
		return userSupplier;
		//return session.getCurrentSession().get(UserSupplier.class, userId);
	}

	public void updateSupplier(UserSupplier supplier) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		System.out.println("context.refresh done");
		UserService userService = (UserService) context.getBean("userService");
		userService.updateUser(supplier.getUser());
		context.close();
		session.getCurrentSession().update(supplier);
	}

	public boolean deleteSupplier(int userId) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserSupplier.class);
		criteria.add(Restrictions.eq("user.id", userId));
		UserSupplier userSupplier = (UserSupplier) criteria.uniqueResult();
		session.getCurrentSession().delete(userSupplier);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<UserSupplier> getAllSuppliers() {
		return (List<UserSupplier>) session.getCurrentSession().createQuery("from UserSupplier").list();
	}
	
}
