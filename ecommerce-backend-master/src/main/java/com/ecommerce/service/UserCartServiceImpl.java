package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.dao.UserCartDao;
import com.ecommerce.model.UserCart;

@Transactional
@Service (value="userCartService")
public class UserCartServiceImpl implements UserCartService {
	
	@Autowired
	private UserCartDao userCartDao;
	
	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#addCartItem(com.ecommerce.model.UserCart)
	 */
	public int addCartItem(UserCart userCart) {
		return userCartDao.addCartItem(userCart);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#getCartItem(int)
	 */
	public UserCart getCartItem(int cartItemId) {
		return userCartDao.getCartItem(cartItemId);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#updateCartItem(com.ecommerce.model.UserCart)
	 */
	public void updateCartItem(UserCart userCart) {
		userCartDao.updateCartItem(userCart);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#deleteCartItem(com.ecommerce.model.UserCart)
	 */
	public boolean deleteCartItem(UserCart userCart) {
		return userCartDao.deleteCartItem(userCart);
		//return true;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#getAllCartItems(int)
	 */
	public List<UserCart> getAllCartItems(int userId) {
		return userCartDao.getAllCartItems(userId);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.UserCartService#findCartItemByProductId(int)
	 */
	public UserCart findCartItemByProductId(int productId) {
		return userCartDao.findCartItemByProductId(productId);
	}

}
