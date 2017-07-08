package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.ProductCategory;


@Repository (value="productCategoryDao")
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao{

	@Autowired
	private SessionFactory session;
	
	public int addProductCategory(ProductCategory productCategory) {
		session.getCurrentSession().save(productCategory);
		int id = productCategory.getId();
		
		return id;
	}

	public ProductCategory getProductCategory(int productCategoryId) {
		return session.getCurrentSession().get(ProductCategory.class, productCategoryId);
	}

	public void updateProductCategory(ProductCategory productCategory) {
		session.getCurrentSession().update(productCategory);
	}

	public boolean deleteProductCategory(ProductCategory productCategory) {
		session.getCurrentSession().delete(productCategory);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<ProductCategory> getAllProductCategories() {
		return (List<ProductCategory>) session.getCurrentSession().createQuery("from ProductCategory").list();
	}
	
}
