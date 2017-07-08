package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;

@Transactional
@Service (value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public int addUser(User user) {
		return userDao.addUser(user);
		//return user.getId();
	}

	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
		//return true;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
