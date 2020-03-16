package com.vp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vp.model.Ipo;
import com.vp.service.IpoService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class IpoController {

	@Autowired
	 IpoService ipoService;
	
	@GetMapping("/ipos")
	public List<Ipo> getIpos(){
		return ipoService.getAllIpo();
	}
	
	@PostMapping("/ipo")
	public void insertIpo(@RequestBody Ipo ipo) {
		ipoService.save(ipo);
	}
}
