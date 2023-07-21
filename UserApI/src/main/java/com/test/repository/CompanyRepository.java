package com.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

Optional<Company>	findByUsername(String username);
 boolean existsByUsername(String username);

 @Query("select c from Company c where "+"c.companyName LIKE CONCAT('%', :query, '%')"+"Or c.username LIKE CONCAT('%', :query, '%')")
	public List<Company> searchCompany(String query);
 
 
 @Query("select c from Company c where "+"c.companyName LIKE CONCAT('%', :companyName, '%')"+"Or c.username LIKE CONCAT('%', :username, '%')")
	public List<Company> search( String companyName , String username );
 
 
}