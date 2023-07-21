package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	
//	public List<User> findByName(String name);
	
	
	public User findByName(String name);

	
	
}
