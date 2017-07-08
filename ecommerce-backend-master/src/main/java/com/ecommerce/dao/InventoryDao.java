package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.*;

@Repository
public interface InventoryDao {
	public int addProductInventory(Inventory inventory);
	public Inventory getProductInventory(int inventoryId);
	public Inventory getProductInventoryBySupplier(UserSupplier supplier, Product product);
	public Inventory getProductInventoryBySupplierHQL(int userId, int productId);
	public void updateProductInventory(Inventory inventory);
	public boolean deleteProductInventoryBySupplier(int userId, int productId);
	public List<Inventory> getAllInventoryBySupplier(int userId);
	public List<Inventory> getAllInventory();
}
