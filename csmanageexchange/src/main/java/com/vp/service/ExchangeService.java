package com.vp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vp.model.Exchange;
import com.vp.repository.ExchangeRepository;

@Service
@Transactional
public class ExchangeService {
	@Autowired
	ExchangeRepository exchangeRepository;
	
	public List<Exchange> getAllExchange(){
		return (List<Exchange>) exchangeRepository.findAll();
	}
	
	public void saveExchange(Exchange exchange) {
		exchangeRepository.save(exchange);
	}
	
}
