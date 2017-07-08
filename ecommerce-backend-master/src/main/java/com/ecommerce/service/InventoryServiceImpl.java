package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.InventoryDao;
import com.ecommerce.model.*;

@Transactional
@Service (value="inventoryService")
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;
	
	public int addProductInventory(Inventory inventory) {
		return inventoryDao.addProductInventory(inventory);
		//return user.getId();
	}
	
	public Inventory getProductInventory(int inventoryId) {
		return inventoryDao.getProductInventory(inventoryId);
	}

	public Inventory getProductInventoryBySupplier(UserSupplier supplier, Product product) {
		return inventoryDao.getProductInventoryBySupplier(supplier, product);
	}

	public Inventory getProductInventoryBySupplierHQL(int userId, int productId) {
		return inventoryDao.getProductInventoryBySupplierHQL(userId, productId);
	}

	public void updateProductInventory(Inventory inventory) {
		inventoryDao.updateProductInventory(inventory);
	}

	public boolean deleteProductInventoryBySupplier(int userId, int productId) {
		return inventoryDao.deleteProductInventoryBySupplier(userId, productId);
		//return true;
	}

	public List<Inventory> getAllInventoryBySupplier(int userId) {
		return inventoryDao.getAllInventoryBySupplier(userId);
	}

	public List<Inventory> getAllInventory() {
		return inventoryDao.getAllInventory();
	}

}
