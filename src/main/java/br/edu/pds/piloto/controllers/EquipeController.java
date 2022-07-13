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

import br.edu.pds.piloto.domains.Equipe;
import br.edu.pds.piloto.repositories.EquipeRepositorio;


@Controller
public class EquipeController {

	@Autowired
	private EquipeRepositorio equipeRepo;
	
	@GetMapping("/listarEquipe")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("equipes");
		mv.addObject("equipes", equipeRepo.findAll());
		
		return mv;
	}
	
	
	@GetMapping("/cadastrarEquipe")
	public ModelAndView cadastrar(Equipe equipe) {
		ModelAndView mv = new ModelAndView("equipe");
		mv.addObject("equipe", equipe);
		
		return mv;
	}	
	
	
	@PostMapping("/salvarEquipe")
	public ModelAndView salvar (@Valid Equipe equipe, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(equipe);
		}
	
		equipeRepo.saveAndFlush(equipe);
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/editarEquipe/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Equipe> equipe = equipeRepo.findById(id);
		
		return cadastrar(equipe.get());
	}
	
	@GetMapping("/excluirEquipe/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Optional<Equipe> equipe = equipeRepo.findById(id);
		equipeRepo.delete(equipe.get());
		
		return new ModelAndView("redirect:/listarEquipe");
	}
	
	
}