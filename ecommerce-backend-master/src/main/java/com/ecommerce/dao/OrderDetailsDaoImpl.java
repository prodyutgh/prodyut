package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.OrderDetails;


@Repository (value="orderDetailsDao")
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao{

	@Autowired
	private SessionFactory session;
	
	public int addOrderItem(OrderDetails orderDetails) {
		session.getCurrentSession().save(orderDetails);
		int id = orderDetails.getId();
		
		return id;
	}

	public OrderDetails getOrderItem(int orderItemId) {
		return session.getCurrentSession().get(OrderDetails.class, orderItemId);
	}

	public void updateOrderItem(OrderDetails orderDetails) {
		session.getCurrentSession().update(orderDetails);
	}

	public boolean deleteOrderItem(int orderItemId) {
		session.getCurrentSession().delete(orderItemId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetails> getAllOrderItems(int orderId) {
		String selectSQL = "from OrderDetails where order_id= :orderId";
		return (List<OrderDetails>) session.getCurrentSession().createQuery(selectSQL)
			.setInteger("orderId", orderId).list();
	}
	
}
