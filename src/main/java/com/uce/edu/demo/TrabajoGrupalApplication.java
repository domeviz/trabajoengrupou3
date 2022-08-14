package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class TrabajoGrupalApplication  implements CommandLineRunner{

	private static final Logger LOG = Logger.getLogger(TrabajoGrupalApplication.class);

	@Autowired
	private IHotelService iHotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(TrabajoGrupalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("INNER JOIN");
		List<Hotel> listaHoteles=this.iHotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h: listaHoteles) {
			LOG.info("Hotel Familiar: "+h.getNombre()+" "+h.getDireccion());
		}

		LOG.info("INNER JOIN 2");
		List<Hotel> listaHoteles2=this.iHotelService.buscarHotelInnerJoin();
		for(Hotel h: listaHoteles2) {
			LOG.info("Hotel: "+h.getNombre()+" "+h.getDireccion());
		}

		LOG.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft=this.iHotelService.buscarHotelOuterLeftJoin("Individual");
		for(Hotel h: listaHotelesLeft) {
			LOG.info("Hotel Individual: "+h.getNombre()+" "+h.getDireccion());
		}

		LOG.info("LEFT JOIN 2");
		List<Hotel> listaHotelesLeft2=this.iHotelService.buscarHotelOuterLeftJoin();
		for(Hotel h: listaHotelesLeft2) {
			LOG.info("Hotel: "+h.getNombre()+" "+h.getDireccion());
		}

		LOG.info("RIGHT JOIN");
		List<Hotel> listaHotelesRight=this.iHotelService.buscarHotelOuterRightJoin("Familiar");
		for(Hotel h: listaHotelesRight) {
			LOG.info("Hotel Familiar: "+h.getNombre()+" "+h.getDireccion());
		}
	}

}
