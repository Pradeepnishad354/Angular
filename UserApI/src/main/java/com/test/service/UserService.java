package com.test.service;

import java.util.List;

import com.test.entity.User;

public interface UserService {
	
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(Integer id);
	
	public void deleteUser(Integer id);	
	
	public User updateUser(User user);
	
	
}

