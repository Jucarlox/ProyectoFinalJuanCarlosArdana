package com.salesianostriana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.salesianostriana.dam.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	List<Reserva> findByNombreClienteContainsIgnoreCaseOrderByNombreClienteAsc(String nombreCliente);
}