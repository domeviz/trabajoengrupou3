package com.uce.edu.demo.factura.service;

import java.util.List;

import com.uce.edu.demo.factura.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(String tipoDetalle);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterLeftJoin(String tipoDetalle);
	public List<Factura> buscarFacturaOuterLeftJoin();
	public List<Factura> buscarFacturaOuterRightJoin(String tipoDetalle);
	public List<Factura> buscarFacturaJoinWhere(String tipoDetalle);
	public List<Factura> buscarFacturaJoinFetch(String tipoDetalle);
}
