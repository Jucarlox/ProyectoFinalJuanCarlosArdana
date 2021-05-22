package com.salesianostriana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Pista;



public interface PistaRepository extends JpaRepository <Pista, Long> {

	List<Pista> findByTipo(String tipo);
}
