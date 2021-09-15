package com.maketshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maketshirt.api.exception.BusinessException;
import com.maketshirt.api.model.Aluno;
import com.maketshirt.api.repository.AlunoRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	
private AlunoRepository alunorepository;
	
	@Autowired	
	public AlunoController(AlunoRepository alunorepository) {
		this.alunorepository = alunorepository;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ApiOperation(value = "Listar", authorizations = { @Authorization(value="apiKey") })
	public ResponseEntity<String> PrimeroEndPoint() throws BusinessException{
		try {
			return new ResponseEntity<>("On-Line", HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	@ApiOperation(value = "buscar", authorizations = { @Authorization(value="apiKey") })
	public ResponseEntity<List<Aluno>> buscaAlunos() throws BusinessException{
		try {
			return new ResponseEntity<>(alunorepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ApiOperation(value = "Listar", authorizations = { @Authorization(value="apiKey") })
	public ResponseEntity<Aluno> cadastraAluno(@RequestBody Aluno aluno) throws Exception {
		try {
			return new ResponseEntity<>(alunorepository.save(aluno), HttpStatus.CREATED) ;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "apagar", authorizations = { @Authorization(value="apiKey") })
	public ResponseEntity<HttpStatus> apagaAluno(@PathVariable("id") Long id) throws BusinessException {
		try {
			alunorepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	
	
}
