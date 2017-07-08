package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.ProductCategory;

@Repository
public interface ProductCategoryDao {
	public int addProductCategory(ProductCategory productCategory);
	public ProductCategory getProductCategory(int productCategoryId);
	public void updateProductCategory(ProductCategory productCategory);
	public boolean deleteProductCategory(ProductCategory productCategory);
	public List<ProductCategory> getAllProductCategories();
}
