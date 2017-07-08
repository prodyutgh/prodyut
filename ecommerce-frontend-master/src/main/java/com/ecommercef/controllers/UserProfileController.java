package com.ecommercef.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.User;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.service.UserCustomerService;
import com.ecommerce.service.UserService;
import com.ecommercef.controllers.BaseController;


@Controller
public class UserProfileController extends BaseController{
	
	@Autowired
	private UserCustomerService userCustomerService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/profile/edit", method = RequestMethod.GET)
	public String getEditUserProfile(ModelMap model) {
		model.addAttribute("loggedInUser", getPrincipal());
		UserCustomer userCustomer = userCustomerService.getCustomer(this.loggedInUser.getId());
		model.addAttribute("userCustomer", userCustomer);
		return "user-profile-edit";
	}

	@RequestMapping(value = "/user/profile/edit", method = RequestMethod.POST)
	public String submitEditUserProfile(@Valid @ModelAttribute("userCustomer") UserCustomer userCustomerForm) {
		getPrincipal();
		User user = userService.getUser(this.loggedInUser.getId());
		userCustomerForm.getUser().setId(user.getId());
		userCustomerForm.getUser().setRole(user.getRole());
		userCustomerForm.getUser().setPassword(user.getPassword());
		userService.updateUser(userCustomerForm.getUser());
		UserCustomer userCustomer = userCustomerService.getCustomer(this.loggedInUser.getId());
		userCustomerForm.setId(userCustomer.getId());
		userCustomerForm.setUser(userCustomer.getUser());
		userCustomerService.updateCustomer(userCustomerForm);
		System.out.println("User Profile updated successfully!!!");
		return "redirect:/user/profile/edit";
	}

}
