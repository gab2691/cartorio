package com.cartorio.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartorio.config.models.Cartorio;
import com.cartorio.config.service.CartorioService;

@RestController
public class deletCartorio {

	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/deletCartorio"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<String> deletCartorioById(@RequestParam Long id){
		try {
			cartService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {			
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
