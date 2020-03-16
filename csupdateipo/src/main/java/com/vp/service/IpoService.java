package com.vp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vp.model.Ipo;
import com.vp.repository.IpoRepository;

@Service
@Transactional
public class IpoService {
	@Autowired
	IpoRepository ipoRepository;
	
	public List<Ipo> getAllIpo(){
		return (List<Ipo>) ipoRepository.findAll();
	}
	
	public void save(Ipo ipo) {
		ipoRepository.save(ipo);
	}
	
}
