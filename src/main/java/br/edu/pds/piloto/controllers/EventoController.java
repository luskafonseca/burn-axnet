package br.edu.pds.piloto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

	@GetMapping("/evento")
	public ModelAndView evento() {
		ModelAndView mv = new ModelAndView("evento");
		
		return mv;
	}
}