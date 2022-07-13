package br.edu.pds.piloto.controllers;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;




@Controller
public class AdminController {


	
	@GetMapping("/areaAdmin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView("admin.html");

		
		
		return mv;
	}

	
}