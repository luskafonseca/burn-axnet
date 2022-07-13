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
import br.edu.pds.piloto.domains.Equipe2;
import br.edu.pds.piloto.repositories.EquipeRepositorio;


@Controller
public class EquipeController2 {

	@Autowired
	private EquipeRepositorio equipeRepo;
	
	
		@GetMapping("/cadastrarEquipe2")
	public ModelAndView cadastrar(Equipe2 equipe2) {
		ModelAndView mv = new ModelAndView("equipe2");
		mv.addObject("equipe2", equipe2);
		
		return mv;
	}	
	
}

	
	
