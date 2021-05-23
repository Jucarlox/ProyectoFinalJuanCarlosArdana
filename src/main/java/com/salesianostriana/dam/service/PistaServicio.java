package com.salesianostriana.dam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Pista;
import com.salesianostriana.dam.repository.PistaRepository;
import com.salesianostriana.dam.repository.ReservaRepository;
import com.salesianostriana.dam.service.base.BaseService;

/**
 * Clase PistaServicio
 *
 * Esta clase define los servicios de la clase Pista
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

@Service
public class PistaServicio extends BaseService<Pista, Long, PistaRepository> {

	/**
	 * Envoltorio de la clase PistaServicio
	 *
	 * @param PistaRepository La interfaz de la Pista
	 */

	public PistaServicio(PistaRepository repo) {
		super(repo);
	}

	/**
	 * Metodo que busca las pistas segun el tipo
	 * 
	 * @param tipo El tipo define la cadena String tipo de Pista
	 * @return Una lista de Pistas que coincida con el tipo de Pista buscado
	 */

	public List<Pista> pistasTipo(String tipo) {

		return this.repositorio.findByTipo(tipo);

	}
}
