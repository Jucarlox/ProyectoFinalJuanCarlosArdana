
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
public class ReservaController {

	private final ReservaServicio reservaservice;
	private final PistaServicio pistaservice;
	
	
	@GetMapping("/listaReservas")
	public String index(Model model, 
			@RequestParam("q") Optional<String> consulta) {

		List<Reserva> reservas;

		if (consulta.isEmpty()) {
			reservas = reservaservice.findAll();
		} else {
			reservas = reservaservice.reservasNombre(consulta.get());
		}

		model.addAttribute("reservas", reservas);
		
		
		

		return "listaReservas";
	}
	
	@GetMapping("/add/{id}")
	public String muestraFormulario(@PathVariable("id") Long Pistaid, Model model) {
		
		
		model.addAttribute("pistas", pistaservice.findById(Pistaid));
		model.addAttribute("reserva", new Reserva());
		return "formulario";
	}
	
	@GetMapping("/detalles/{id}")
	public String detalles(@PathVariable("id") Long Pistaid, Model model) {
		
		
		model.addAttribute("pista", pistaservice.findById(Pistaid));
		model.addAttribute("reservasPista",pistaservice.findById(Pistaid).getReservas());
		
		
		return "detalles";
	}
	
	@PostMapping({"/add/addReserva","/editar/addReserva"})
	public String procesaFormulario(@ModelAttribute("reserva") Reserva reserva, Model model) {
		
		
		reservaservice.save(reserva);
		  
		return "redirect:/listaReservas";
	}
	
	
	@GetMapping("/editar/{id}")
    public String editarCita(@PathVariable("id") Long Reservaid, Model model) {
        Reserva reserva = reservaservice.findById(Reservaid);
        
        if (reserva != null) {
        	Pista t = reserva.getPista();
        	reserva.setId(Reservaid);
        	
            model.addAttribute("reserva", reserva);
            model.addAttribute("pistas",t );
            return "formulario";
        } else {
            return "redirect:/listaReservas";
        }
    }

    @GetMapping("/borrar/{id}")
    public String borrarCita(@PathVariable("id") Long id, Model model) {

        Reserva reserva = reservaservice.findById(id);

        if (reserva != null) {
        	reservaservice.delete(reserva);
        }else {
            return "redirect:/listaReservas/?error=true";
        }

        return "redirect:/listaReservas";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
