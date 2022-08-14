package com.uce.edu.demo.factura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IFacturaRepository;
import com.uce.edu.demo.factura.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterRightJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinWhere(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(tipoDetalle);
	}
	
}
