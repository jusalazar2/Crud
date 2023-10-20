package com.example.demo.controler;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IloginService;
import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.Login;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService servicePersona;
	
	@Autowired
	private IloginService servicelogin;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas=servicePersona.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
		List<Login>usuarios=servicelogin.listar();
		model.addAttribute("usuarios", usuarios);
		return "index2";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@GetMapping("/newlogin")
	public String agregarlogin(Model model) {
		model.addAttribute("login", new Login());
		return "registrar";
	}
	
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		model.addAttribute("personas", new Persona());
		servicePersona.save(p);
		return "redirect:/listar";
	}
	
	@PostMapping("/savelogin")
	public String saveLogin(@Validated Login r, Model model) {
		model.addAttribute("login", new Login());
		servicelogin.save(r);
		return "redirect:/listarUsuarios";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Persona>persona=servicePersona.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	
	
	@GetMapping("/editarLogin/{id}")
	public String editarLogin(@PathVariable int id, Model model){
		Optional<Login>empleado=servicelogin.listarId(id);
		model.addAttribute("login", empleado);
		return "registrar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id){
		servicePersona.delete(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/eliminarLogin/{id}")
	public String deletelogin(Model model, @PathVariable int id){
		servicelogin.delete(id);
		return "redirect:/listarUsuarios";
	}
	

}
