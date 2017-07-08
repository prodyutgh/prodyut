package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.*;

@Service
public interface InventoryService {
	public int addProductInventory(Inventory inventory);
	public Inventory getProductInventory(int inventoryId);
	public Inventory getProductInventoryBySupplier(UserSupplier supplier, Product product);
	public Inventory getProductInventoryBySupplierHQL(int userId, int productId);
	public void updateProductInventory(Inventory inventory);
	public boolean deleteProductInventoryBySupplier(int userId, int productId);
	public List<Inventory> getAllInventoryBySupplier(int userId);
	public List<Inventory> getAllInventory();
}
