package com.salesianostriana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Reserva;

/**
 * Interfaz ReservaRepository
 *
 * Esta interfaz implementa el metodo de busqueda por el nombre asociado a la
 * Reserva
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	List<Reserva> findByNombreClienteContainsIgnoreCaseOrderByNombreClienteAsc(String nombreCliente);
}