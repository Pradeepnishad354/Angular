package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.repository.UserRepository;
import com.test.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public ResponseEntity<User> save(@RequestBody User user) {

//		if(userRepository.findByName(user.getName())) {
//			
//			return 
//		}
		

		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	// find all user
	@GetMapping("/find")
	public ResponseEntity<?> getAll() {

		List<User> allUser = userService.getAllUser();

		if (allUser.size() > 0) {
			return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(allUser, HttpStatus.NOT_FOUND);
		}

	}
	
	// find user by id
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		
		User user = userService.getUserById(id);
		
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	
	// delete user
	@DeleteMapping("/delete/{id}")
	public void deleteUsers(@PathVariable Integer id) {
		
          userService.deleteUser(id);
	
	}
	

	//update User
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user){
		
		user.setId(id);
		
		User updateUser = userService.updateUser(user);
		
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
		
		
	}
	
	
//	@GetMapping("/users")
//	public List<User> findByName(@RequestParam String name){
//		
//		return userRepository.findByName(name);
//	}
//	
//	@GetMapping("/find/{name}")
//	public User findByName(@PathVariable("name") String name) {
//		
//		
//		User user  =userRepository.findByName(name);
//		return user;
//	}
}
