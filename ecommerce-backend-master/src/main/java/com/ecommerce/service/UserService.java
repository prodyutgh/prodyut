package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.User;

@Service
public interface UserService {
	public int addUser(User user);
	public User getUser(int userId);
	public User getUserByEmail(String email);
	public void updateUser(User user);
	public boolean deleteUser(int userId);
	public List<User> getAllUsers();
}
