package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.UserCart;

public interface UserCartService {

	public int addCartItem(UserCart userCart);

	public UserCart getCartItem(int cartItemId);

	public void updateCartItem(UserCart userCart);

	public boolean deleteCartItem(UserCart userCart);

	public List<UserCart> getAllCartItems(int userId);
	
	public UserCart findCartItemByProductId(int productId);

}