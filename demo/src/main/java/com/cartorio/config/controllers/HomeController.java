package com.cartorio.config.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@CrossOrigin(origins={"*"})
	@RequestMapping("/")
	public ModelAndView home() {
		try {
			ModelAndView modelAndView = new ModelAndView("index");			
			return modelAndView;	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}