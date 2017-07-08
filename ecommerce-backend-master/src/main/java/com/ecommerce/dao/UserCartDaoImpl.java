package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.UserCart;


@Repository (value="userCartDao")
@Transactional
public class UserCartDaoImpl implements UserCartDao{

	@Autowired
	private SessionFactory session;
	
	public UserCartDaoImpl(SessionFactory session) {
		super();
		this.session = session;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#addCartItem(com.ecommerce.model.UserCart)
	 */
	public int addCartItem(UserCart userCart) {
		session.getCurrentSession().save(userCart);
		int id = userCart.getId();
		
		return id;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#getCartItem(int)
	 */
	public UserCart getCartItem(int cartItemId) {
		return session.getCurrentSession().get(UserCart.class, cartItemId);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#findCartItemByProductId(int)
	 */
	public UserCart findCartItemByProductId(int productId) {
		return (UserCart) session.getCurrentSession()
				.createQuery("from UserCart Where product_id = :productId")
				.setInteger("productId", productId)
				.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#getAllCartItems(int)
	 */
	@SuppressWarnings("unchecked")
	public List<UserCart> getAllCartItems(int userId) {
		List<UserCart> cartItems = session.getCurrentSession()
				.createQuery("from UserCart Where customer_id = :userId")
				.setInteger("userId", userId)
				.list();
		return cartItems;
	}
	
	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#updateCartItem(com.ecommerce.model.UserCart)
	 */
	public void updateCartItem(UserCart userCart) {
		session.getCurrentSession().update(userCart);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.dao.UserCartDao#deleteCartItem(com.ecommerce.model.UserCart)
	 */
	public boolean deleteCartItem(UserCart userCart) {
		session.getCurrentSession().delete(userCart);
		return false;
	}
	
}
