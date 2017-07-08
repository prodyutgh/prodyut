package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserDao {
	public int addUser(User user);
	public User getUser(int userId);
	public User getUserByEmail(String email);
	public void updateUser(User user);
	public boolean deleteUser(int userId);
	public List<User> getAllUsers();
}
