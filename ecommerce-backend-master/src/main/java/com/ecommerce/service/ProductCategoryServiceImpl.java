package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductCategoryDao;
import com.ecommerce.model.ProductCategory;

@Transactional
@Service (value="productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	public int addProductCategory(ProductCategory productCategory) {
		return productCategoryDao.addProductCategory(productCategory);
		//return product.getId();
	}

	public ProductCategory getProductCategory(int productCategoryId) {
		return productCategoryDao.getProductCategory(productCategoryId);
	}

	public void updateProductCategory(ProductCategory productCategory) {
		productCategoryDao.updateProductCategory(productCategory);
	}

	public boolean deleteProductCategory(ProductCategory productCategory) {
		return productCategoryDao.deleteProductCategory(productCategory);
		//return true;
	}

	public List<ProductCategory> getAllProductCategories() {
		return productCategoryDao.getAllProductCategories();
	}

}
