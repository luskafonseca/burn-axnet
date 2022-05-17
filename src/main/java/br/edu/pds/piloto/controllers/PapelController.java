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

import br.edu.pds.piloto.domains.Papel;
import br.edu.pds.piloto.repositories.PapelRepositorio;



@Controller
public class PapelController {

	@Autowired
	private PapelRepositorio roleRepo;
	
	@GetMapping("/listarPapel")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("roles");
		mv.addObject("roles", roleRepo.findAll());
		
		return mv;
	}
	
	
	@GetMapping("/cadastrarPapel")
	public ModelAndView cadastrar(Papel role) {
		ModelAndView mv = new ModelAndView("role");
		mv.addObject("role", role);
		
		return mv;
	}	
	
	
	@PostMapping("/salvarPapel")
	public ModelAndView salvar (@Valid Papel role, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(role);
		}
	
		roleRepo.saveAndFlush(role);
		
		return new ModelAndView("redirect:/listarPapel");
	}
	
	@GetMapping("/editarPapel/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Papel> role = roleRepo.findById(id);
		
		return cadastrar(role.get());
	}
	
	@GetMapping("/excluirPapel/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Optional<Papel> role = roleRepo.findById(id);
		roleRepo.delete(role.get());
		
		return new ModelAndView("redirect:/listarPapel");
	}
	
	
}