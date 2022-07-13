package br.edu.pds.piloto.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import br.edu.pds.piloto.domains.Tabela;
import br.edu.pds.piloto.repositories.EquipeRepositorio;
import br.edu.pds.piloto.repositories.TabelaRepositorio;




@Controller
public class TabelaController {

	@Autowired
	private EquipeRepositorio equipeRepo;
	
	@Autowired
	private TabelaRepositorio tabelaRepo;
	
	
	@GetMapping("/listarTabela")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("tabelas");
		mv.addObject("tabelas", tabelaRepo.findAll());
		
		return mv;
	}
	
	
	@GetMapping("/cadastrarTabela")
	public ModelAndView cadastrar(Tabela tabela) {
		ModelAndView mv = new ModelAndView("tabela");
		mv.addObject("tabela", tabela);
		mv.addObject("equipes", equipeRepo.findAll());
	
		return mv;
	}	
	
	
	@PostMapping("/salvarTabela")
	public ModelAndView salvar (@Valid Tabela tabela, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(tabela);
		}
	
		tabelaRepo.saveAndFlush(tabela);
		
		return new ModelAndView("redirect:/listarTabela");
	}
	
	@GetMapping("/editarTabela/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Tabela> tabela = tabelaRepo.findById(id);
		
		return cadastrar(tabela.get());
	}
	
	@GetMapping("/excluirTabela/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Optional<Tabela> tabela = tabelaRepo.findById(id);
		tabelaRepo.delete(tabela.get());
		
		return new ModelAndView("redirect:/listarTabela");
	}
	
	
}