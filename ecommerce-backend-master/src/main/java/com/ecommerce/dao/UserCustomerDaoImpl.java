package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.UserCustomer;
import com.ecommerce.model.UserSupplier;


@Repository (value="userCustomerDao")
@Transactional
public class UserCustomerDaoImpl implements UserCustomerDao{

	@Autowired
	private SessionFactory session;
	
	public int addCustomer(UserCustomer customer) {
		session.getCurrentSession().save(customer);
		int id = customer.getId();
		
		return id;
	}

	public UserCustomer getCustomer(int userId) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserCustomer.class);
		criteria.add(Restrictions.eq("user.id", userId));
		UserCustomer userCustomer = (UserCustomer) criteria.uniqueResult();
		return userCustomer;
		//return session.getCurrentSession().get(UserCustomer.class, userId);
	}

	public void updateCustomer(UserCustomer customer) {
		session.getCurrentSession().update(customer);
	}

	public boolean deleteCustomer(int userId) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserCustomer.class);
		criteria.add(Restrictions.eq("user.id", userId));
		UserCustomer userCustomer = (UserCustomer) criteria.uniqueResult();
		session.getCurrentSession().delete(userCustomer);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<UserCustomer> getAllCustomers() {
		return (List<UserCustomer>) session.getCurrentSession().createQuery("from UserCustomer").list();
	}

	public UserCustomer findCustomer(String email, String address) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserCustomer.class);
		//criteria.add(Restrictions.eq("email", email));
		criteria.add(
				Restrictions.or(
						Restrictions.ilike("billing_address", address, MatchMode.ANYWHERE), 
						Restrictions.ilike("shipping_address", address, MatchMode.ANYWHERE)
				)
		);
		UserCustomer customer = (UserCustomer) criteria.uniqueResult();
		return customer;
	}
	
}
