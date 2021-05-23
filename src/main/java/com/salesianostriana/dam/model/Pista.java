package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase Pista
 *
 * Esta clase define a las pistas que posee el Polideportivo Alcosa
 *
 * @author Juan Carlos
 * @version 1
 * @see <a href = "https://triana.salesianos.edu/" /> triana.salesianos.edu –
 *      Triana Salesianos </a>
 */

//Anotaciones de Lombok y entidad
@Data
@NoArgsConstructor
@Entity
public class Pista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int numeroPista;
	private double precio;
	private String tipo;
	private String imagen;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConstruccion;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "pista", fetch = FetchType.EAGER)
	private List<Reserva> reservas = new ArrayList<>();

	/**
	 * Constructor de la clase Pista
	 *
	 * @param numeroPista       El numero de Pista define una enumeracion con la que
	 *                          llamar a esa Pista
	 * @param precio            El precio define el coste de la pista
	 * @param tipo              El tipo de Pista define si es una Pista de
	 *                          baloncesto, de padel, de tenis, etc ...
	 * @param imagen            La imagen de la Pista
	 * @param fechaConstruccion La fechaConstruccion define cuando se creo la Pista
	 */

	public Pista(int numeroPista, double precio, String tipo, LocalDate fechaConstruccion) {
		this.numeroPista = numeroPista;
		this.precio = precio;
		this.tipo = tipo;
		this.fechaConstruccion = fechaConstruccion;
	}

	public Pista(int numeroPista, double precio, String tipo, LocalDate fechaConstruccion, String imagen) {
		this.numeroPista = numeroPista;
		this.precio = precio;
		this.tipo = tipo;
		this.fechaConstruccion = fechaConstruccion;
		this.imagen = imagen;
	}

}
