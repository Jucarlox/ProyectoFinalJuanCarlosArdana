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

//Anotaciones de Lombok y entidad
@Data @NoArgsConstructor
@Entity
public class Pista {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int numeroPista;
	private double precio;
	private String tipo;
	private String imagen;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConstruccion;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="pista", fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();
	
	
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
		this.imagen=imagen;
	}
	
	
	
	
	
}
