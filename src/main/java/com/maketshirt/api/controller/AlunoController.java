package com.maketshirt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maketshirt.api.model.Aluno;
import com.maketshirt.api.repository.AlunoRepository;

@Controller
public class AlunoController {
	
	
	private AlunoRepository alunorepository;
	
	@Autowired	
	public AlunoController(AlunoRepository alunorepository) {
		this.alunorepository = alunorepository;
	}

	@GetMapping("/")
	public String PrimeroEndPoint() {
		return "index";
		
	}
	
	@GetMapping("/busca")
	@ResponseBody
	public List<Aluno> buscaAlunos(){
		return alunorepository.findAll();
	}
	
	@PostMapping("/cadastra")
	@ResponseBody
	public Aluno cadastraAluno(@RequestBody Aluno aluno) {
		return alunorepository.save(aluno);
	}
	
	@PostMapping("/apaga")
	@ResponseBody
	public String apagaAluno(@RequestBody Aluno aluno) {
		alunorepository.delete(aluno);
		return "Aluno Apagado";
		
	}
	

}
