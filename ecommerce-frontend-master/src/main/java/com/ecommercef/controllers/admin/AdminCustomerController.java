package com.ecommercef.controllers.admin;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Inventory;
import com.ecommerce.model.Role;
import com.ecommerce.model.User;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.model.UserSupplier;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.RoleService;
import com.ecommerce.service.UserCustomerService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.UserSupplierService;
import com.ecommercef.controllers.BaseController;

@Controller
public class AdminCustomerController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCustomerService userCustomerService;

	@RequestMapping (value="/admin/customers/list", method = RequestMethod.GET)
	public String getSupplierList(ModelMap model){
		model.addAttribute("loggedInUser", getPrincipal());
		List<UserCustomer> customers = userCustomerService.getAllCustomers(); 
		model.addAttribute("customers", customers);
		return "admin/customers/list";
	}
	
	@RequestMapping(value = "/admin/customers/edit/{userId}", method = RequestMethod.GET)
	public String getEditUserSupplierForm(@PathVariable int userId, ModelMap model) {
		model.addAttribute("loggedInUser", getPrincipal());
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		return "admin/customers/edit";
	}

	@RequestMapping(value = "/admin/customers/edit/{userId}", method = RequestMethod.POST)
	public String submitEditUserSupplierForm(@PathVariable int userId, @Valid @ModelAttribute("user") User userForm) {
		User user = userService.getUser(userId);
		System.out.println("user fetched" + user.toString());
		userForm.setId(user.getId());
		userForm.setRole(user.getRole());
		userService.updateUser(userForm);
		System.out.println("User updated successfully!!!");
		return "redirect:/admin/customers/list";
	}
	
	@RequestMapping (value="/admin/customers/{userId}/confirm-delete", method = RequestMethod.GET)
	public String confirmCustomerDelete(@PathVariable int userId, ModelMap model){
		model.addAttribute("loggedInUser", getPrincipal());
		UserCustomer userCustomer = userCustomerService.getCustomer(userId);
		model.addAttribute("userCustomer", userCustomer);
		return "admin/customers/confirm-delete";
	}

	@RequestMapping (value="/admin/customers/{userId}/delete", method = RequestMethod.POST)
	public String customerDelete(@PathVariable int userId, @ModelAttribute("userCustomer") UserCustomer userCustomerForm){
		userCustomerService.deleteCustomer(userId);
		return "redirect:/admin/customers/list";
	}
}
