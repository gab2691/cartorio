package com.cartorio.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cartorio.config.models.Cartorio;
import com.cartorio.config.service.CartorioService;

@RestController
public class HomeController {
	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping("/")
	public ModelAndView home() {
		try {
			Iterable<Cartorio> cartorios = cartService.findAll();
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("cartorios", cartorios);
			return modelAndView;	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}