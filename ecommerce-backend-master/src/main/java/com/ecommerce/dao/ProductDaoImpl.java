package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Product;


@Repository (value="productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory session;
	
	public ProductDaoImpl(SessionFactory session) {
		super();
		this.session = session;
	}

	public int addProduct(Product product) {
		session.getCurrentSession().save(product);
		int id = product.getId();
		
		return id;
	}

	public Product getProduct(int productId) {
		return session.getCurrentSession().get(Product.class, productId);
	}

	public void updateProduct(Product product) {
		session.getCurrentSession().update(product);
	}

	public boolean deleteProduct(Product product) {
		session.getCurrentSession().delete(product);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return (List<Product>) session.getCurrentSession().createQuery("from Product").list();
	}
	
}
