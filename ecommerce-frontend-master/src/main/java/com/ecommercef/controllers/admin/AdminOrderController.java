package com.ecommercef.controllers.admin;

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
public class AdminOrderController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping (value="/admin/orders/list", method = RequestMethod.GET)
	public String getOrdersList(ModelMap model){
		List<Order> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/orders/list";
	}
	
	@RequestMapping (value="/admin/orders/view/{orderId}", method = RequestMethod.GET)
	public String viewOrder(@PathVariable int orderId, ModelMap model){
		Order order = orderService.getOrder(orderId);
		model.addAttribute("order", order);
		List<OrderDetails> orderDetails = orderDetailsService.getAllOrderItems(orderId);
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/orders/view";
	}

}
