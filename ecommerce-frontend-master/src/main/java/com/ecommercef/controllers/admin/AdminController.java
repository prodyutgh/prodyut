package com.ecommercef.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserCustomerService;
import com.ecommerce.service.UserSupplierService;
import com.ecommercef.controllers.BaseController;


@Controller
public class AdminController extends BaseController{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserCustomerService userCustomerService;
	
	@Autowired
	private UserSupplierService userSupplierService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping (value="/admin/dashboard")
	public String getIndex(ModelMap model){
		model.addAttribute("loggedInUser", getPrincipal());
		model.addAttribute("productsCount", productService.getAllProducts().size());
		model.addAttribute("suppliersCount", userSupplierService.getAllSuppliers().size());
		model.addAttribute("customersCount", userCustomerService.getAllCustomers().size());
		model.addAttribute("ordersCount", orderService.getAllOrders().size());
		return "admin/admin-dashboard";
	}

}
