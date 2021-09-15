package com.maketshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maketshirt.api.model.User;
import com.maketshirt.api.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userBO;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ApiOperation(value = "Listar", authorizations = { @Authorization(value="apiKey") })
	public ResponseEntity<List<User>> listar(){
		return new ResponseEntity<>(userBO.findAll(), HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<User> cadastraAluno(@RequestBody User user) throws Exception {
		try {
			return new ResponseEntity<>(userBO.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

}
