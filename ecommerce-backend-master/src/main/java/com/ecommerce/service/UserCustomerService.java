package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.UserCustomer;

@Service
public interface UserCustomerService {
	public int addCustomer(UserCustomer customer);
	public UserCustomer getCustomer(int userId);
	public void updateCustomer(UserCustomer customer);
	public boolean deleteCustomer(int userId);
	public List<UserCustomer> getAllCustomers();
	public UserCustomer findCustomer(String email, String address);
}
