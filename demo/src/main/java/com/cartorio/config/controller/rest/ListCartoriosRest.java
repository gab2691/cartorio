package com.cartorio.config.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartorio.config.models.Cartorio;
import com.cartorio.config.service.CartorioService;

@RestController
public class ListCartoriosRest {

	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/listCartorioRest"}, method = {RequestMethod.GET})
	@ResponseBody
	public List<Cartorio> listCartorios(){
		try {
			Iterable<Cartorio> cartorios = cartService.findAll();
			return (List<Cartorio>) cartorios;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
