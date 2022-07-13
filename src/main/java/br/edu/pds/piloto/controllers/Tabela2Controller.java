package br.edu.pds.piloto.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import br.edu.pds.piloto.repositories.Tabela2Repositorio;
import br.edu.pds.piloto.repositories.TabelaRepositorio;


@Controller
public class Tabela2Controller {

	@Autowired
	private Tabela2Repositorio tabela2Repo;
	
	@Autowired
	private TabelaRepositorio tabelaRepo;
	
	
	
	
	@GetMapping("/listarTabela2")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("tabelas2");
		mv.addObject("tabelas2", tabela2Repo.findAll());
		mv.addObject("tabelas", tabelaRepo.findAll());
		
		return mv;
	}

	
}