package br.edu.pds.piloto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TesteController {
	String mensagem = "Olá mundo Spring (dinamico)";
	
	@GetMapping("/olaMundo")
	public ModelAndView olaMundoDinamico() {
		
		ModelAndView mv = new ModelAndView("index.html");
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}
}
