package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;

@Repository
public interface ProductDao {
	public int addProduct(Product product);
	public Product getProduct(int productId);
	public void updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> getAllProducts();
}
