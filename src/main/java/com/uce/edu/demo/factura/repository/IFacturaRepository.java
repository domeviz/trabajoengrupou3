package com.uce.edu.demo.factura.repository;

import java.util.List;

import com.uce.edu.demo.factura.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(String tipoDetalle);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterLeftJoin(String tipoDetalle);
	public List<Factura> buscarFacturaOuterLeftJoin();
	public List<Factura> buscarFacturaOuterRightJoin(String tipoDetalle);
	public List<Factura> buscarFacturaJoinWhere(String tipoDetalle);
	public List<Factura> buscarFacturaJoinFetch(String tipoDetalle);
}
