package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Order;

@Transactional
@Service (value="orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	public int createOrderFromUserCart(int userId) {
		return orderDao.createOrderFromUserCart(userId);
	}

	public int addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	public boolean deleteOrder(int orderId) {
		return orderDao.deleteOrder(orderId);
		//return true;
	}

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	public List<Order> getAllOrdersByUser(int userId) {
		return orderDao.getAllOrdersByUser(userId);
	}

}
