package com.vp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.model.Company;
import com.vp.service.CompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/companies")
	public List<Company> getCompanies(){
		return companyService.getAllCompany();
	}
	
	@PostMapping("/company")
	public void insertCompany(@RequestBody Company company) {
		companyService.saveCompany(company);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.PUT)
	public HttpStatus updateCompany(@RequestBody Company company) {
		return companyService.updateCompany(company)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	
}
}
