package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.UserSupplier;

@Repository
public interface UserSupplierDao {
	public int addSupplier(UserSupplier supplier);
	public UserSupplier getSupplier(int userId);
	public void updateSupplier(UserSupplier supplier);
	public boolean deleteSupplier(int userId);
	public List<UserSupplier> getAllSuppliers();
}
