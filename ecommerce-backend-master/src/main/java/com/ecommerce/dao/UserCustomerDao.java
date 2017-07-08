package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.UserCustomer;

@Repository
public interface UserCustomerDao {
	public int addCustomer(UserCustomer customer);
	public UserCustomer getCustomer(int userId);
	public void updateCustomer(UserCustomer customer);
	public boolean deleteCustomer(int userId);
	public List<UserCustomer> getAllCustomers();
	public UserCustomer findCustomer(String email, String address);
}
