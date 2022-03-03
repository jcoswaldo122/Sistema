package com.ilinesolution.sistema.modelo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ilinesolution.sistema.modelo.dao.CategoriaDao;
import com.ilinesolution.sistema.modelo.entidades.Categoria;

public class CategoriaDaoImpl extends GenericaDaoImpl<Categoria> implements CategoriaDao {

	@Override
	public void insertarCategoria(Categoria categoria) {
		try {
			this.beginTransaction();
			this.create(categoria);
			this.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
		
	}

	@Override
	public void modificarCategoria(Categoria categoria) {
		try {
			this.beginTransaction();
			this.update(categoria);
			this.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		try {
			this.beginTransaction();
			this.delete(categoria);
			this.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

	@Override
	public List<Categoria> listaCategoria() {
		TypedQuery<Categoria> categoria = this.entityManager.createQuery("Select c From Categoria c", Categoria.class);
		return categoria.getResultList();
		/*
		CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Categoria> c = cb.createQuery(Categoria.class);
        Root<Categoria> categoria = c.from(Categoria.class);
        c.select(categoria);
        return this.entityManager.createQuery(c).getResultList();
		*/
	}

}
