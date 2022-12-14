package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static final Logger LOG = LoggerFactory.getLogger(HotelRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles=myQuery.getResultList();
		for(Hotel h:hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//SELECT * FROM hotel ho, habitacion ha where ho.hote_id=ha.habi_id_hotel;
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
//	@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa Repository: "  + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

}
