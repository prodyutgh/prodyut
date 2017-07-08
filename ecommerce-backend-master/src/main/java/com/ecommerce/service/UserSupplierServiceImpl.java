package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserSupplierDao;
import com.ecommerce.model.UserSupplier;

@Transactional
@Service (value="userSupplierService")
public class UserSupplierServiceImpl implements UserSupplierService {
	
	@Autowired
	private UserSupplierDao userSupplierDao;
	
	public int addSupplier(UserSupplier supplier) {
		return userSupplierDao.addSupplier(supplier);
		//return user.getId();
	}

	public UserSupplier getSupplier(int userId) {
		return userSupplierDao.getSupplier(userId);
	}

	public void updateSupplier(UserSupplier supplier) {
		userSupplierDao.updateSupplier(supplier);
	}

	public boolean deleteSupplier(int userId) {
		return userSupplierDao.deleteSupplier(userId);
		//return true;
	}

	public List<UserSupplier> getAllSuppliers() {
		return userSupplierDao.getAllSuppliers();
	}
	
}
