package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.UserCart;

public interface UserCartDao {

	int addCartItem(UserCart userCart);

	UserCart getCartItem(int cartItemId);

	List<UserCart> getAllCartItems(int userId);
	
	public UserCart findCartItemByProductId(int productId);

	void updateCartItem(UserCart userCart);

	boolean deleteCartItem(UserCart userCart);

}