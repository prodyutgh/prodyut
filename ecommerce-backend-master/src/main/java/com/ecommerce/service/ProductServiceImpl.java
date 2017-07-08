package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

@Transactional
@Service (value="productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public int addProduct(Product product) {
		return productDao.addProduct(product);
		//return product.getId();
	}

	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public boolean deleteProduct(Product product) {
		return productDao.deleteProduct(product);
		//return true;
	}

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

}
