package com.maketshirt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroEndPoint {
	
	@GetMapping("/ola")
	public String ola() {
		return "Olá, Bom dia !!";
	}

}
