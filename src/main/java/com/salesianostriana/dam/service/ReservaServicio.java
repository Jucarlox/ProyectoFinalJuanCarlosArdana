package com.salesianostriana.dam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.repository.ReservaRepository;
import com.salesianostriana.dam.service.base.BaseService;

@Service
public class ReservaServicio extends BaseService<Reserva, Long, ReservaRepository> {

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
	}
	
public List<Reserva> reservasNombre(String nombre){
		
		
		return this.repositorio.findByNombreClienteContainsIgnoreCaseOrderByNombreClienteAsc(nombre);
		
	}

}