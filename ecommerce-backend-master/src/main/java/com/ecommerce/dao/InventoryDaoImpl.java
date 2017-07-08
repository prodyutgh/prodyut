package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.*;


@Repository (value="inventoryDao")
@Transactional
public class InventoryDaoImpl implements InventoryDao{

	@Autowired
	private SessionFactory session;
	
	public int addProductInventory(Inventory inventory) {
		session.getCurrentSession().save(inventory);
		int id = inventory.getId();
		
		return id;
	}

	public Inventory getProductInventory(int inventoryId) {
		return session.getCurrentSession().get(Inventory.class, inventoryId);
	}

	public Inventory getProductInventoryBySupplier(UserSupplier supplier, Product product) {
		Criteria criteria = session.getCurrentSession().createCriteria(Inventory.class);
		//criteria.setFetchMode("user_suppliers", FetchMode.JOIN);
		//criteria.setFetchMode("product_categories", FetchMode.JOIN);
		criteria.add(Restrictions.eq("supplier", supplier));
		criteria.add(Restrictions.eq("product", product));
		//criteria.add(Restrictions.eq("product_id", productId));
		//criteria.add(Restrictions.eq("quantity", 10));
		Inventory inventory = (Inventory) criteria.uniqueResult();
		return inventory;
	}

	public Inventory getProductInventoryBySupplierHQL(int userId, int productId) {
		String selectSQL = "from Inventory where supplier_id= :userId and product_id=:productId";
		return (Inventory) session.getCurrentSession().createQuery(selectSQL)
			.setInteger("userId", userId)
			.setInteger("productId", productId)
			.uniqueResult();
	}

	public void updateProductInventory(Inventory inventory) {
		session.getCurrentSession().update(inventory);
	}

	public boolean deleteProductInventoryBySupplier(int userId, int productId) {
		String deleteSQL = "delete Inventory where supplier_id= :userId and product_id=:productId";
		session.getCurrentSession().createQuery(deleteSQL)
			.setInteger("userId", userId)
			.setInteger("productId", productId)
			.executeUpdate();
		//session.getCurrentSession().delete(userId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Inventory> getAllInventoryBySupplier(int userId) {
		return (List<Inventory>) session.getCurrentSession()
				.createQuery("from Inventory Where supplier_id = :userId")
				.setInteger("userId", userId)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Inventory> getAllInventory() {
		return (List<Inventory>) session.getCurrentSession()
				.createQuery("from Inventory")
				.list();
	}
	
}
