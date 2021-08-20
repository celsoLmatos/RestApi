package com.maketshirt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroEndPoint {
	
	@GetMapping("/")
	public String PrimeroEndPoint() {
		return "Meu primeiro EndPoint";
	}

}
