package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository iHotelRepository;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

}
