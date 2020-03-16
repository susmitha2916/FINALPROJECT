package com.vp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.model.Company;
import com.vp.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	
	public List<Company> getAllCompany(){
		return (List<Company>) companyRepository.findAll();
	}
	
	public void saveCompany(Company company) {
		companyRepository.save(company);
	}

	public void deleteCompany(Long id) {
		
		companyRepository.deleteById(id);
	}

	public boolean updateCompany(Company company) {
	 return companyRepository.save(company)!=null;
	}
}
