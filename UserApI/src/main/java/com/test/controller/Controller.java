package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Company;
import com.test.entity.Response;
import com.test.repository.CompanyRepository;
import com.test.service.CompanyService;

@RestController
public class Controller {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCompany(@RequestBody Company company) {
		
		if(companyRepository.existsByUsername(company.getUsername())) {
			
		//	Response response =	new Response();
			
//			response.setMessage("User is already registered ");
//			
//			return ResponseEntity.badRequest().body(new Response(response.getMessage()));
//			
			return ResponseEntity.badRequest().body(new Response("user already registered"));
		}
		
		
		companyRepository.save(company);
			
		return new ResponseEntity<>(new Response("user registered succesfully"),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/login")
	public void login(@RequestBody Company company) {
		
	String name = company.getUsername();
		
		Optional<Company> findByUsername = companyRepository.findByUsername(name);
		
	System.out.println("*****************************"+ name);
		
		if((!findByUsername.isEmpty()) && (company.getPassword().equals(findByUsername.get().getPassword()))) {
			
			System.out.println("successfully login");
		}else {
			
		System.out.println("username or password wrong");
		}
		
	}
	
	// sorting and pagination 
	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAllCompany(@RequestParam (defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "id") String sortBy){
		List<Company> allCompany = companyService.findAllCompany(pageSize, pageNumber,sortBy);
		return new ResponseEntity<List<Company>>(allCompany,HttpStatus.OK);
		
		
	}

	// searching 
	
	@GetMapping("/search")
	public ResponseEntity<List<Company>> searchCompany(
			
			@RequestParam(name="username",required=false) String username ,
			
			@RequestParam(name="companyName",required=false) String companyName
			
			) throws Exception{
		
		if( (username == null || username==" " || username.length()==0 ) && (companyName == null || companyName==" " || companyName.length()==0 )  )
		{
			throw new Exception(" Kindly provide either userName or comanyName ");
		}
		
		//System.out.println(userName +"""""""""""""""""""""""""""" "+   3);
		
		return ResponseEntity.ok(companyService.searchByCompanyNameOrUserName(companyName,username));
	}
	
}
