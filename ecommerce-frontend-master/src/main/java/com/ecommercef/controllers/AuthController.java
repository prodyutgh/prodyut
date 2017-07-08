package com.ecommercef.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Role;
import com.ecommerce.model.User;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.service.RoleService;
import com.ecommerce.service.UserCustomerService;
import com.ecommerce.service.UserService;

@Controller
public class AuthController extends BaseController {
	
	@Autowired
	private User user;
	
	@Autowired
	private UserCustomer userCustomer;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserCustomerService userCustomerService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignUpForm(ModelMap model) {
		model.addAttribute("loggedInUser", getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("userCustomer", userCustomer);
		return "registration";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String submitSignUpForm(@Valid @ModelAttribute("user") User user) {
		Role role = roleService.getRole(2); // 1 role belongs to customer
		user.setRole(role);
		userService.addUser(user);
		userCustomer.setUser(user);
		userCustomerService.addCustomer(userCustomer);
		System.out.println("Customer added successfully!!!");
		return "redirect:/login?signup";
	}
	
	@RequestMapping(value = "/login")
	public String getLoginForm(ModelMap model) {
		model.addAttribute("loggedInUser", getPrincipal());
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/access_denied")
	public String getAccessDeniedForm(ModelMap map, ModelMap model) {
		model.addAttribute("loggedInUser", getPrincipal());
		return "access_denied";
	}
}
