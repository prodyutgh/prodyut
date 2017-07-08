package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.UserSupplier;

@Service
public interface UserSupplierService {
	public int addSupplier(UserSupplier supplier);
	public UserSupplier getSupplier(int userId);
	public void updateSupplier(UserSupplier supplier);
	public boolean deleteSupplier(int userId);
	public List<UserSupplier> getAllSuppliers();
}
