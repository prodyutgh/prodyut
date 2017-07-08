package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderDetailsDao;
import com.ecommerce.model.OrderDetails;

@Transactional
@Service (value="orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	public int addOrderItem(OrderDetails orderDetails) {
		return orderDetailsDao.addOrderItem(orderDetails);
		//return product.getId();
	}

	public OrderDetails getOrderItem(int orderItemId) {
		return orderDetailsDao.getOrderItem(orderItemId);
	}

	public void updateOrderItem(OrderDetails orderDetails) {
		orderDetailsDao.updateOrderItem(orderDetails);
	}

	public boolean deleteOrderItem(int orderItemId) {
		return orderDetailsDao.deleteOrderItem(orderItemId);
		//return true;
	}

	public List<OrderDetails> getAllOrderItems(int orderId) {
		return orderDetailsDao.getAllOrderItems(orderId);
	}

}
