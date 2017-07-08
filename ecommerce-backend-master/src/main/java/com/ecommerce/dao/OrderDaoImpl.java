package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderDetails;
import com.ecommerce.model.UserCart;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.service.OrderDetailsService;
import com.ecommerce.service.UserCartService;
import com.ecommerce.service.UserCustomerService;


@Repository (value="orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory session;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private UserCustomerService userCustomerService;
	
	@Autowired
	private UserCartService userCartService;
	
	@Autowired
	private Order order;
	
	@Autowired
	private OrderDetails orderDetails;
	
	@Autowired
	private UserCustomer customer;
	
	public int createOrderFromUserCart(int userId){
		customer = userCustomerService.getCustomer(userId);
		order.setOrder_no(null);
		order.setCustomer(customer);
		List<UserCart> cartItems = userCartService.getAllCartItems(userId);
		List<UserCart> cartItems2 = cartItems;
		double total_amount = 0;
		String description = "";
		for(UserCart cartItem : cartItems2){
			total_amount += cartItem.getProduct().getPrice() * cartItem.getQuantity();
			description += cartItem.getProduct().getName() + "<br/>";
		}
		order.setTotal_amount(total_amount);
		if(description.length() > 255){
			description = description.substring(0, 248) + " ...";
		}
		order.setDescription(description);
		order = this.getOrder(this.addOrder(order));
		session.getCurrentSession().flush();
		session.getCurrentSession().clear();
		
		for(UserCart cartItem : cartItems){
			orderDetails.setOrder(order);
			orderDetails.setProduct(cartItem.getProduct());
			orderDetails.setQuantity(cartItem.getQuantity());
			orderDetailsService.addOrderItem(orderDetails);
			userCartService.deleteCartItem(cartItem);
			session.getCurrentSession().flush();
			session.getCurrentSession().clear();
		}
		
		return order.getId();
	}
	
	/*public int createOrderFromUserCart_updateProb(int userId){
		customer = userCustomerService.getCustomer(userId);
		order.setOrder_no(null);
		order.setCustomer(customer);
		order = this.getOrder(this.addOrder(order));
		session.getCurrentSession().flush();
		session.getCurrentSession().clear();
		List<UserCart> cartItems = userCartService.getAllCartItems(userId);
		double total_amount = 0;
		String description = "";
		for(UserCart cartItem : cartItems){
			orderDetails.setOrder(order);
			orderDetails.setProduct(cartItem.getProduct());
			orderDetails.setQuantity(cartItem.getQuantity());
			orderDetailsService.addOrderItem(orderDetails);
			total_amount += cartItem.getProduct().getPrice() * cartItem.getQuantity();
			description += cartItem.getProduct().getName() + "<br/>";
			userCartService.deleteCartItem(cartItem);
			session.getCurrentSession().flush();
			session.getCurrentSession().clear();
		}
		order.setTotal_amount(total_amount);
		if(description.length() > 255){
			description = description.substring(0, 248) + " ...";
		}
		order.setDescription(description);
		session.getCurrentSession().flush();
		session.getCurrentSession().clear();
		this.updateOrder(order);
		
		return order.getId();
	}*/
	
	public int addOrder(Order order) {
		session.getCurrentSession().save(order);
		int id = order.getId();
		
		return id;
	}

	public Order getOrder(int orderId) {
		return session.getCurrentSession().get(Order.class, orderId);
	}

	public void updateOrder(Order order) {
		session.getCurrentSession().update(order);
	}

	public boolean deleteOrder(int orderId) {
		session.getCurrentSession().delete(orderId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		return (List<Order>) session.getCurrentSession().createQuery("from Order").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrdersByUser(int userId){
		String selectSQL = "from Order where customer_id= :userId";
		return (List<Order>) session.getCurrentSession().createQuery(selectSQL)
			.setInteger("userId", userId)
			.list();
	}
	
}
