package com.cartorio.config.controllers;

import java.util.Optional;

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
public class EditCartorio {

	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/editCartorio"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<Cartorio> editCartorio(@RequestBody Cartorio cart){
		try {
			Cartorio cartorio = cartService.findById(cart.getId()).orElse(new Cartorio());
			cartorio.setNome(cart.getNome());
			cartService.save(cartorio);
			return new ResponseEntity<Cartorio>(cartorio, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
