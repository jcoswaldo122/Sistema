package com.ilinesolution.sistema.controlador;

import java.util.List;

import com.ilinesolution.sistema.modelo.entidades.Categoria;

public interface CategoriaControlador {

	public void insertarCategoria(Categoria categoria);
	public void modificarCategoria(Categoria categoria);
	public void eliminarCategoria(Categoria categoria);
    public List<Categoria> listaCategoria();
}
