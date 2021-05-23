package com.salesianostriana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Pista;

/**
 * Interfaz PistaRepository
 *
 * Esta interfaz implementa el metodo de busqueda por tipo de Pista
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

public interface PistaRepository extends JpaRepository<Pista, Long> {

	List<Pista> findByTipo(String tipo);
}
