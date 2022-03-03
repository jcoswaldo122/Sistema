package com.ilinesolution.sistema.controlador.impl;

import java.util.List;

import com.ilinesolution.sistema.controlador.CategoriaControlador;
import com.ilinesolution.sistema.modelo.dao.CategoriaDao;
import com.ilinesolution.sistema.modelo.dao.impl.CategoriaDaoImpl;
import com.ilinesolution.sistema.modelo.entidades.Categoria;

public class CategoriaControladorImpl implements CategoriaControlador{

	private CategoriaDao categoriaDao;
	@Override
	public void insertarCategoria(Categoria categoria) {
		categoriaDao = new CategoriaDaoImpl();
		categoriaDao.insertarCategoria(categoria);
		
	}

	@Override
	public void modificarCategoria(Categoria categoria) {
		categoriaDao = new CategoriaDaoImpl();
		categoriaDao.modificarCategoria(categoria);
		
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		categoriaDao = new CategoriaDaoImpl();
		categoriaDao.eliminarCategoria(categoria);
		
	}

	@Override
	public List<Categoria> listaCategoria() {
		categoriaDao = new CategoriaDaoImpl();
		return categoriaDao.listaCategoria();
	}

}
