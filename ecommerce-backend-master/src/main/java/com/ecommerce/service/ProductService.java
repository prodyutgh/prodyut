package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;

@Service
public interface ProductService {
	public int addProduct(Product product);
	public Product getProduct(int productId);
	public void updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> getAllProducts();
}
