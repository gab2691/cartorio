package com.cartorio.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cartorio.config.models.Cartorio;
import com.cartorio.config.service.CartorioService;

@RestController
public class ListCartorios {
	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/listCartorio"}, method = {RequestMethod.GET})
	@ResponseBody
	public ModelAndView lisCartorio(){
		try{
			Iterable<Cartorio> cartorios = cartService.findAll();
			return new ModelAndView();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
