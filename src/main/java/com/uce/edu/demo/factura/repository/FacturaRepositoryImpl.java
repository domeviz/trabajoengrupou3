package com.uce.edu.demo.factura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.factura.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.tipo =:tipoDetalle", Factura.class);
		myQuery.setParameter("tipoDetalle", tipoDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.tipo =:tipoDetalle", Factura.class);
		myQuery.setParameter("tipoDetalle", tipoDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.tipo =:tipoDetalle", Factura.class);
		myQuery.setParameter("tipoDetalle", tipoDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(String tipoDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f, Detalle d WHERE f = d.factura AND d.tipo =:tipoDetalle", Factura.class);
		myQuery.setParameter("tipoDetalle", tipoDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(String tipoDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.tipo =:tipoDetalle", Factura.class);
		myQuery.setParameter("tipoDetalle", tipoDetalle);
		return myQuery.getResultList();
	}

}
