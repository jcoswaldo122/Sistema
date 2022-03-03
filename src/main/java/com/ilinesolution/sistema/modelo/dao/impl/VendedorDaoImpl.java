package com.ilinesolution.sistema.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ilinesolution.sistema.modelo.dao.VendedorDao;
import com.ilinesolution.sistema.modelo.entidades.Vendedor;

public class VendedorDaoImpl extends GenericaDaoImpl<Vendedor> implements VendedorDao {

	@Override
	public void insertarVendedor(Vendedor vendedor) {
		try {
			this.beginTransaction();
			this.create(vendedor);
			this.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();

		}
	}

	@Override
	public List<Vendedor> listaVendedor() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vendedor> v = cb.createQuery(Vendedor.class);
		Root<Vendedor> vendedor = v.from(Vendedor.class);
		v.select(vendedor);
		return this.entityManager.createQuery(v).getResultList();

	}

	@Override
	public void modificarVendedor(Vendedor vendedor) {
		try {
			this.beginTransaction();
			this.update(vendedor);
			this.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();

		}
	}

	@Override
	public void eliminarVendedor(Vendedor vendedor) {
		try {
			this.beginTransaction();
			this.delete(vendedor);
			this.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();

		}
	}

}