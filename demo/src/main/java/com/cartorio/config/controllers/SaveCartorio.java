package com.cartorio.config.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartorio.config.models.Cartorio;
import com.cartorio.config.service.CartorioService;

@RestController
public class SaveCartorio {

	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/saveCartorio"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<Cartorio> saveCartorio(@RequestBody Cartorio cartorio) {
		try {
			cartorio.setDataCriacao(Calendar.getInstance());
			Cartorio save = cartService.save(cartorio);
			return new ResponseEntity<Cartorio>(save, HttpStatus.OK);
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
