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
public class ListCartorioController {

	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/listCartorio"}, method = {RequestMethod.GET})
	public ModelAndView listCartorio() {
		try {
			Iterable<Cartorio> cartorios = cartService.findAll();
			ModelAndView modelAndView = new ModelAndView("listCartorios");
			modelAndView.addObject("cartorios", cartorios);
			return modelAndView;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
