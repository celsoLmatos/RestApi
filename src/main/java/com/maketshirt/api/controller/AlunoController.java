package com.maketshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maketshirt.api.model.Aluno;
import com.maketshirt.api.repository.AlunoRepository;

@RestController
public class AlunoController {
	
	
private AlunoRepository alunorepository;
	
	@Autowired	
	public AlunoController(AlunoRepository alunorepository) {
		this.alunorepository = alunorepository;
	}

	@GetMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public String PrimeroEndPoint() {
		return "On-Line";
		
	}
	
	@GetMapping("/busca")
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> buscaAlunos(){
		return alunorepository.findAll();
	}
	
	@PostMapping("/cadastra")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastraAluno(@RequestBody Aluno aluno) {
		alunorepository.save(aluno);
		return "Cadastrou"; 
	}
	
	@PostMapping("/apaga")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String apagaAluno(@RequestBody Aluno aluno) {
		alunorepository.delete(aluno);
		return "Apagou";
		
	}
	
	
	
}
