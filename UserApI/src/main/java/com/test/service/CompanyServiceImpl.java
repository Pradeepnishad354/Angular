package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.entity.Company;
import com.test.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

@Autowired	
	private CompanyRepository companyRepository;
	


	@Override
	public List<Company> findAllCompany(int pageSize,int pageNumber,String sortBy)  {
		
		
		Pageable p=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		
	
		  Page<Company> pageResult = companyRepository.findAll(p);
		  
		  if(pageResult.hasContent()) {
			  
			  return pageResult.getContent();
		  }else {
			  
			  	return new ArrayList<Company>();
		  }
		  
		 
		 
		
	}



	@Override
	public List<Company> searchCompany(String query) {
		
		List<Company> searchCompany = companyRepository.searchCompany(query);
		
		return searchCompany;
	}



	@Override
	public List<Company> searchByCompanyNameOrUserName(String userName, String companyName) {
	
  List<Company> searchCompany = companyRepository.search(userName,companyName);
		
		return searchCompany;
		
	}

	
	
}
