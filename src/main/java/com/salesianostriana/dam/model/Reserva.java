package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Reserva {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombreCliente;
	private String apellidosCliente;
	
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaReserva;
	
	@ManyToOne
	
	private Pista pista;
	
	public Reserva (String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva) {
		this.nombreCliente=nombreCliente;
		this.apellidosCliente=apellidosCliente;
		this.fechaReserva=fechaReserva;
	}
	
	public Reserva (long id,String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva) {
		this.nombreCliente=nombreCliente;
		this.apellidosCliente=apellidosCliente;
		this.fechaReserva=fechaReserva;
		this.id=id;
	}
	
	public Reserva (String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva, Pista pista) {
		this.nombreCliente=nombreCliente;
		this.apellidosCliente=apellidosCliente;
		this.fechaReserva=fechaReserva;
		this.pista=pista;
	}
	
	
	
	
}
