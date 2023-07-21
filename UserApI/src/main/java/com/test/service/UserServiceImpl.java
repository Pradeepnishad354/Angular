package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
	
	return 	userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		List<User> all = userRepository.findAll();
		
		return all;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
	}

	@Override
	public void deleteUser(Integer id) {
		
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User user) {
		
		User existingUser = userRepository.findById(user.getId()).get()	;
		
		existingUser.setName(user.getName());
		existingUser.setAge(user.getAge());
		existingUser.setEmail(user.getEmail());
		existingUser.setCity(user.getCity());
		
		User updateUser = userRepository.save(user);
		return updateUser;
	}

	
	
	
}
