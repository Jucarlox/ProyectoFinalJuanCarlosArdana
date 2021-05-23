
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

/**
 * Clase ReservaController
 *
 * Esta clase se encarga de pintar listas de reservas en la pagina web
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

@Controller
@RequiredArgsConstructor
public class ReservaController {

	private final ReservaServicio reservaservice;
	private final PistaServicio pistaservice;

	/**
	 * Controlador que pinta listas de Reservas y permite la busqueda de ellas por
	 * nombre de Cliente
	 * 
	 * @param model    El model se encarga de enviar las listas de Reservas a la
	 *                 pagina web
	 * @param consulta La consulta filtrar la lista de Reservas segun el nombre del
	 *                 Cliente Buscado
	 * @return devuelte la plantilla listaReservas con los datos de las Reservas
	 *         cargados
	 */

	@GetMapping("/listaReservas")
	public String index(Model model, @RequestParam("q") Optional<String> consulta) {

		List<Reserva> reservas;

		if (consulta.isEmpty()) {
			reservas = reservaservice.findAll();
		} else {
			reservas = reservaservice.reservasNombre(consulta.get());
		}

		model.addAttribute("reservas", reservas);

		return "listaReservas";
	}

	/**
	 * Controlador que pinta la plantilla formulario y permite la Reserva de una
	 * Pista
	 * 
	 * @param model   El model se encarga de enviar la lista de Pistas filtrada por
	 *                id asociado a la Pista y crear un nuevo objeto Reserva
	 * @param Pistaid El id asociado a la Pista que quieres reservar
	 * @return devuelte la plantilla listaReservas con los datos de las Reservas
	 *         cargados
	 */

	@GetMapping("/add/{id}")
	public String muestraFormulario(@PathVariable("id") Long Pistaid, Model model) {

		model.addAttribute("pistas", pistaservice.findById(Pistaid));
		model.addAttribute("reserva", new Reserva());
		return "formulario";
	}

	/**
	 * Controlador que pinta la plantilla detalles con las reservas de una Pista
	 * 
	 * @param model   El model se encarga de enviar la lista de Reservas filtrada
	 *                por id asociado a la Pista
	 * @param Pistaid El id asociado a la Pista que quieres reservar
	 * @return devuelte la plantilla detalles con los datos de las Reservas de una
	 *         Pista cargados
	 */

	@GetMapping("/detalles/{id}")
	public String detalles(@PathVariable("id") Long Pistaid, Model model) {

		model.addAttribute("pista", pistaservice.findById(Pistaid));
		model.addAttribute("reservasPista", pistaservice.findById(Pistaid).getReservas());

		return "detalles";
	}

	/**
	 * Controlador que redirige a la lista de Reservas y guarda la reserva hecha
	 * 
	 * @param reserva Objeto Reserva
	 * @return redirige a la plantilla listaReservas con los datos de las Reservas
	 */

	@PostMapping({ "/add/addReserva", "/editar/addReserva" })
	public String procesaFormulario(@ModelAttribute("reserva") Reserva reserva) {

		reservaservice.save(reserva);

		return "redirect:/listaReservas";
	}

	/**
	 * Controlador que pinta la plantilla formulario con los datos cargados para
	 * editar la Reserva
	 * 
	 * @param model     El model se encarga de enviar la lista de Pistas filtrada
	 *                  por id asociado a la Pista y crear un nuevo objeto Reserva
	 * @param Reservaid El id asociado a la Reserva que quieres editar
	 * @return devuelte la plantilla listaReservas con los datos de las Reservas
	 *         cargados
	 */

	@GetMapping("/editar/{id}")
	public String editarCita(@PathVariable("id") Long Reservaid, Model model) {
		Reserva reserva = reservaservice.findById(Reservaid);

		if (reserva != null) {
			Pista t = reserva.getPista();
			reserva.setId(Reservaid);

			model.addAttribute("reserva", reserva);
			model.addAttribute("pistas", t);
			return "formulario";
		} else {
			return "redirect:/listaReservas";
		}
	}

	/**
	 * Controlador que pinta la plantilla listaReservas con los datos borrados de la
	 * Reserva
	 * 
	 * @param id El id asociado a la Reserva que quieres borrar
	 * @return devuelte la plantilla listaReservas con los datos borrados de la
	 *         Reserva
	 */

	@GetMapping("/borrar/{id}")
	public String borrarCita(@PathVariable("id") Long id) {

		Reserva reserva = reservaservice.findById(id);

		if (reserva != null) {
			reservaservice.delete(reserva);
		} else {
			return "redirect:/listaReservas/?error=true";
		}

		return "redirect:/listaReservas";
	}

}
