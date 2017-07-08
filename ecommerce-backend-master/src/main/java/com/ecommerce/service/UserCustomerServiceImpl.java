package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserCustomerDao;
import com.ecommerce.model.UserCustomer;

@Transactional
@Service (value="userCustomerService")
public class UserCustomerServiceImpl implements UserCustomerService {
	
	@Autowired
	private UserCustomerDao userCustomerDao;
	
	public int addCustomer(UserCustomer customer) {
		return userCustomerDao.addCustomer(customer);
		//return user.getId();
	}

	public UserCustomer getCustomer(int userId) {
		return userCustomerDao.getCustomer(userId);
	}

	public void updateCustomer(UserCustomer customer) {
		userCustomerDao.updateCustomer(customer);
	}

	public boolean deleteCustomer(int userId) {
		return userCustomerDao.deleteCustomer(userId);
		//return true;
	}

	public List<UserCustomer> getAllCustomers() {
		return userCustomerDao.getAllCustomers();
	}
	
	public UserCustomer findCustomer(String email, String address) {
		return userCustomerDao.findCustomer(email, address);
	}

}
