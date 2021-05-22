package com.salesianostriana.dam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Pista;
import com.salesianostriana.dam.repository.PistaRepository;
import com.salesianostriana.dam.repository.ReservaRepository;
import com.salesianostriana.dam.service.base.BaseService;

@Service
public class PistaServicio  extends BaseService<Pista, Long, PistaRepository>{

	public PistaServicio(PistaRepository repo) {
		super(repo);
	}
	
	public List<Pista> pistasTipo(String tipo){
		
		
		return this.repositorio.findByTipo(tipo);
		
	}
}
