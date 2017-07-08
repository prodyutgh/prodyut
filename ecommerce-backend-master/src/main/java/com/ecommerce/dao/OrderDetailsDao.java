package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.*;

@Repository
public interface OrderDetailsDao {
	public int addOrderItem(OrderDetails orderDetails);
	public OrderDetails getOrderItem(int orderItemId);
	public void updateOrderItem(OrderDetails orderDetails);
	public boolean deleteOrderItem(int orderItemId);
	public List<OrderDetails> getAllOrderItems(int orderId);
}
