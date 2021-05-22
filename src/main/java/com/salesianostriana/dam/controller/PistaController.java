package com.salesianostriana.dam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.model.Pista;
import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.service.PistaServicio;
import com.salesianostriana.dam.service.ReservaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PistaController {

	private final PistaServicio pistaservice;
	private final ReservaServicio reservaservice;
	
	
	@GetMapping("/")
	public String index(Model model, 
			@RequestParam("q") Optional<String> consulta) {
		
		List<Pista> pistas;

		if (consulta.isEmpty()) {
			model.addAttribute("pistasTenis", pistaservice.pistasTipo("Tenis".toLowerCase()));
			model.addAttribute("pistasBaloncesto", pistaservice.pistasTipo("baloncesto".toLowerCase()));
			model.addAttribute("pistasPadel", pistaservice.pistasTipo("padel".toLowerCase()));
		} else {
			pistas = pistaservice.pistasTipo(consulta.get());
			model.addAttribute("pistas", pistas);
		}
		
		
		
		
		return "index";
	}
	
	
	/*@GetMapping("/{tipo}")
	public String lista(@PathVariable("tipo") String TipoPista, Model model) {
		
		

		
			model.addAttribute("pistas", pistaservice.pistasTipo(TipoPista.toLowerCase()));
			
		
		
		
		
		return "listasPista";
	}*/
	
	@GetMapping("/new")
	public String muestraFormulario(Model model) {
		model.addAttribute("pista", new Pista());
		return "form";
	}
	
	@PostMapping("/nueva/pista")
	public String procesaFormulario(@ModelAttribute("pista") Pista pista) {
		
		
		pistaservice.save(pista);
		  
		return "redirect:/";
	}
}
