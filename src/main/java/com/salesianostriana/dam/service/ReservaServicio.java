package com.salesianostriana.dam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.repository.ReservaRepository;
import com.salesianostriana.dam.service.base.BaseService;

/**
 * Clase ReservaServicio
 *
 * Esta clase define los servicios de la clase Reserva
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

@Service
public class ReservaServicio extends BaseService<Reserva, Long, ReservaRepository> {

	/**
	 * Envoltorio de la clase ReservaServicio
	 *
	 * @param ReservaRepository La interfaz de la Reserva
	 */

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
	}

	/**
	 * Metodo que busca las reservas segun el nombre asociado a la reserva
	 * 
	 * @param nombre El nombre define la cadena String nombre del cliente
	 * @return Una lista de Reservas que coincida con el nombre del cliente buscado
	 */

	public List<Reserva> reservasNombre(String nombre) {

		return this.repositorio.findByNombreClienteContainsIgnoreCaseOrderByNombreClienteAsc(nombre);

	}

}