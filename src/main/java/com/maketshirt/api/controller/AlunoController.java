package com.maketshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maketshirt.api.model.Aluno;
import com.maketshirt.api.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	
private AlunoRepository alunorepository;
	
	@Autowired	
	public AlunoController(AlunoRepository alunorepository) {
		this.alunorepository = alunorepository;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String PrimeroEndPoint() {
		return "On-Line";
		
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> buscaAlunos(){
		return alunorepository.findAll();
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastraAluno(@RequestBody Aluno aluno) {
		alunorepository.save(aluno);
		return "Cadastrou"; 
	}
	
	
	@RequestMapping(value = "/apagar", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String apagaAluno(@RequestBody Aluno aluno) {
		alunorepository.delete(aluno);
		return "Apagou";
		
	}
	
	
	
}
