package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Order;

@Service
public interface OrderService {
	public int createOrderFromUserCart(int userId);
	public int addOrder(Order order);
	public Order getOrder(int orderId);
	public void updateOrder(Order order);
	public boolean deleteOrder(int orderId);
	public List<Order> getAllOrders();
	public List<Order> getAllOrdersByUser(int userId);
}
