package com.test.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.test.entity.Company;

public interface CompanyService {
	
	
	
	
	public List<Company> findAllCompany(int pageSize,int pageNumber,String sortBy);

	
	 List<Company> searchCompany(String query);
	 
	 
	 List<Company> searchByCompanyNameOrUserName(String userName, String companyName);
	
}
