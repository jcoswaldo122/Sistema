package com.ilinesolution.sistema.modelo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ilinesolution.sistema.modelo.dao.ProductoDao;
import com.ilinesolution.sistema.modelo.entidades.Producto;

public class ProductoDaoImpl extends GenericaDaoImpl<Producto> implements ProductoDao {

	@Override
	public void insertarProducto(Producto prooducto) {
		try {
			this.beginTransaction();
			this.create(prooducto);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
		
	}

	@Override
	public List<Producto> listaProducto() {
		CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> p = cb.createQuery(Producto.class);
        Root<Producto> producto = p.from(Producto.class);
        p.select(producto);
        return this.entityManager.createQuery(p).getResultList();
	}

	@Override
	public void actualizarProducto(Producto producto) {
		try {
			this.beginTransaction();
			this.update(producto);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

	@Override
	public void eliminarProducto(Producto producto) {
		try {
			this.beginTransaction();
			this.delete(producto);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

}
