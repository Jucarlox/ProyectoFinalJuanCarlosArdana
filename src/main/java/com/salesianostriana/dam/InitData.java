package com.salesianostriana.dam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.model.Pista;
import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.service.PistaServicio;
import com.salesianostriana.dam.service.ReservaServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final PistaServicio pistaServicio;
	private final ReservaServicio reservaServicio;
	
	
	@PostConstruct
	public void init() {
		
		
		
		
		
		
		
		

				
		Pista t1= new Pista (1, 12.99, "Tenis".toLowerCase(), LocalDate.parse("1999-04-27"), "https://static.hoteltreats.com/site/styles/hero/s3/2020-03/pista%20tennis%203%20%20la%20manga.jpg?itok=6QPKlW6X");
		Pista t2= new Pista (2, 20.99, "Tenis".toLowerCase(), LocalDate.parse("2000-01-04"), "https://static.hoteltreats.com/site/styles/hero/s3/2020-03/pista%20tennis%203%20%20la%20manga.jpg?itok=6QPKlW6X");
		Pista t3= new Pista (3, 15.99, "Tenis".toLowerCase(), LocalDate.parse("2015-11-30"), "https://static.hoteltreats.com/site/styles/hero/s3/2020-03/pista%20tennis%203%20%20la%20manga.jpg?itok=6QPKlW6X");
		Pista t4= new Pista (4, 30.99, "Tenis".toLowerCase(), LocalDate.parse("2011-07-23"), "https://cdn.pixabay.com/photo/2020/06/29/20/37/asphalt-tennis-court-5354328_960_720.jpg");
		Pista t5= new Pista (5, 17.99, "Tenis".toLowerCase(), LocalDate.parse("1959-12-11"), "https://cdn.pixabay.com/photo/2017/11/28/12/04/wimbledon-2983451_960_720.jpg");
		
		
		
		Pista t6= new Pista (1, 12.99, "Padel".toLowerCase(), LocalDate.parse("1999-04-27"), "https://static.hoteltreats.com/site/styles/hero/s3/2020-03/pista%20tennis%203%20%20la%20manga.jpg?itok=6QPKlW6X");
		Pista t7= new Pista (2, 20.99, "Baloncesto".toLowerCase(), LocalDate.parse("2000-01-04"), "https://floors-supreme.es/wp-content/uploads/2016/07/Dimensiones-pistas-deportivas-Medidas-campo-Supreme-Floors.jpg");
		Pista t8= new Pista (3, 15.99, "Padel".toLowerCase(), LocalDate.parse("2015-11-30"), "https://www.clubdecampolamotilla.es/wp-content/uploads/2018/03/pista-de-padel-dos-hermanas.jpg");
		Pista t9= new Pista (4, 30.99, "Baloncesto".toLowerCase(), LocalDate.parse("2011-07-23"), "https://s1.lanzadigital.com/wp-content/uploads/2020/06/Pistas-de-baloncesto-1-949x712.jpg");
		Pista t10= new Pista (5, 17.99, "Padel".toLowerCase(), LocalDate.parse("1959-12-11"), "https://www.deportesloyola.es/imagenes/biblioteca/padel-2-1804-0305.jpg");
		
		
		
		
		
		
		
		
		pistaServicio.save(t1);
		pistaServicio.save(t2);
		pistaServicio.save(t3);
		pistaServicio.save(t4);
		pistaServicio.save(t5);
		pistaServicio.save(t6);
		pistaServicio.save(t7);
		pistaServicio.save(t8);
		pistaServicio.save(t9);
		pistaServicio.save(t10);
		
		reservaServicio.save(new Reserva("Juan Carlos","Ardana Murillo", LocalDateTime.of(1999, 04,27, 12, 27, 10),t1));
		reservaServicio.save(new Reserva("Jesus","Barco", LocalDateTime.of(1999, 04,27, 12, 27, 10),t2));
		reservaServicio.save(new Reserva("Daniel","De Luna", LocalDateTime.of(1999, 04,27, 12, 27, 10),t7));
		reservaServicio.save(new Reserva("Pablo","Repiso", LocalDateTime.of(1999, 04,27, 12, 27, 10),t10));
	}
}	
