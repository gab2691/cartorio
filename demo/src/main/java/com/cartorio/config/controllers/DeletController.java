package com.cartorio.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cartorio.config.service.CartorioService;

@Controller
public class DeletController {
	
	
	@Autowired
	private CartorioService cartService;
	
	@CrossOrigin(origins={"*"})
	@RequestMapping(value = {"/deletCartorio"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<HttpStatus> deletCartorios(@RequestParam int id){
		try{
			System.out.println(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
