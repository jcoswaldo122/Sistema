package com.ilinesolution.sistema.modelo.dao;

import java.util.List;

import com.ilinesolution.sistema.modelo.entidades.Categoria;

public interface CategoriaDao {

	public void insertarCategoria(Categoria categoria);
	public void modificarCategoria(Categoria categoria);
	public void eliminarCategoria(Categoria categoria);
    public List<Categoria> listaCategoria();
}
