package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.OrderDetails;

@Service
public interface OrderDetailsService {
	public int addOrderItem(OrderDetails orderDetails);
	public OrderDetails getOrderItem(int orderItemId);
	public void updateOrderItem(OrderDetails orderDetails);
	public boolean deleteOrderItem(int orderItemId);
	public List<OrderDetails> getAllOrderItems(int orderId);
}
