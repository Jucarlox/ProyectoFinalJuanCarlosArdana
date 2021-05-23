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

/**
 * Clase Reserva
 *
 * Esta clase define a las reservas que poseen las Pistas
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

@Data
@NoArgsConstructor
@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombreCliente;
	private String apellidosCliente;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaReserva;

	@ManyToOne

	private Pista pista;

	/**
	 * Constructor de la clase Reserva
	 *
	 * @param nombreCliente    El nombre del cliente define el nombre con el que se
	 *                         inscribe la reserva
	 * @param apellidosCliente Los apellidos del cliente definen los apellidos con
	 *                         los que se inscribe la reserva
	 * @param fechaReserva     La fecha de la reserva define la fecha y hora que se
	 *                         ha reservado la Pista
	 * @param pista            La pista relacionada con la reserva
	 */

	public Reserva(String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.fechaReserva = fechaReserva;
	}

	public Reserva(long id, String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.fechaReserva = fechaReserva;
		this.id = id;
	}

	public Reserva(String nombreCliente, String apellidosCliente, LocalDateTime fechaReserva, Pista pista) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.fechaReserva = fechaReserva;
		this.pista = pista;
	}

}
