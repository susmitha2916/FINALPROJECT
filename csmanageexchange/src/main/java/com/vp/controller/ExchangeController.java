package com.vp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vp.model.Exchange;
import com.vp.service.ExchangeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ExchangeController {
	@Autowired
	ExchangeService exchangeService;
	
	@GetMapping("/stocks")
	public List<Exchange> getExchanges(){
		return exchangeService.getAllExchange();
	}
	
	@PostMapping("/stock")
	public void insertExchange(@RequestBody Exchange exchange) {
		exchangeService.saveExchange(exchange);
	}
}
