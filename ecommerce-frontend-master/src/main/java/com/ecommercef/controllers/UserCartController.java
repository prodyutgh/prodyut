package com.ecommercef.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Product;
import com.ecommerce.model.UserCart;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserCartService;
import com.ecommerce.service.UserCustomerService;
import com.ecommercef.controllers.BaseController;


@Controller
public class UserCartController extends BaseController{
	@Autowired
	private UserCart userCart;
	
	@Autowired
	private UserCartService userCartService;
	
	@Autowired
	private UserCustomerService userCustomerService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping (value="/user/cart/list", method = RequestMethod.GET)
	public String getUserCartList(ModelMap model){
		model.addAttribute("loggedInUser", getPrincipal());
		List<UserCart> userCartItems = userCartService.getAllCartItems(this.loggedInUser.getId());
		model.addAttribute("loggedInCartUser", this.loggedInUser);
		model.addAttribute("userCartItems", userCartItems);
		return "user-cart";
	}
	
	@RequestMapping (value="/user/cart/add/{productId}", method = RequestMethod.GET)
	public String addCartItemSubmit(@PathVariable int productId){
		getPrincipal();
		UserCart existingUserCartItem = userCartService.findCartItemByProductId(productId);
		if(existingUserCartItem == null){
			UserCustomer userCustomer = userCustomerService.getCustomer(this.loggedInUser.getId());
			userCart.setCustomer(userCustomer);
			Product product = productService.getProduct(productId);
			userCart.setProduct(product);
			userCart.setQuantity(1);
			userCartService.addCartItem(userCart);
		} else {
			existingUserCartItem.setQuantity(existingUserCartItem.getQuantity() + 1);
			userCartService.updateCartItem(existingUserCartItem);
		}
		
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping (value="/user/cart/update/{cartItemId}", method = RequestMethod.POST)
	public String editCartItemSubmit(@ModelAttribute("productCategory") UserCart userCartForm, @PathVariable int cartItemId){
		UserCart userCart = userCartService.getCartItem(cartItemId);
		userCart.setQuantity(userCartForm.getQuantity());
		userCartService.updateCartItem(userCart);
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping (value="/user/cart/delete/{cartItemId}", method = RequestMethod.GET)
	public String confirmProductCategoryDelete(@PathVariable int cartItemId, ModelMap model){
		UserCart userCart = userCartService.getCartItem(cartItemId);
		userCartService.deleteCartItem(userCart);
		return "redirect:/user/cart/list";
	}

}
