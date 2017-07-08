package com.ecommercef.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderDetails;
import com.ecommerce.service.OrderDetailsService;
import com.ecommerce.service.OrderService;
import com.ecommercef.controllers.BaseController;


@Controller
public class UserOrderController extends BaseController{
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping (value="/user/orders/list", method = RequestMethod.GET)
	public String getUserOrdersList(ModelMap model){
		model.addAttribute("loggedInUser", getPrincipal());
		List<Order> orders = orderService.getAllOrdersByUser(this.loggedInUser.getId());
		model.addAttribute("orders", orders);
		return "user-orders";
	}
	
	@RequestMapping (value="/user/order/{orderId}", method = RequestMethod.GET)
	public String getUserOrderDetails(ModelMap model, @PathVariable int orderId){
		model.addAttribute("loggedInUser", getPrincipal());
		Order order = orderService.getOrder(orderId);
		model.addAttribute("order", order);
		List<OrderDetails> orderItems = orderDetailsService.getAllOrderItems(orderId);
		model.addAttribute("orderItems", orderItems);
		return "user-order-details";
	}

}
