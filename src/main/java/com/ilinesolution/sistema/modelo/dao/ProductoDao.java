package com.ilinesolution.sistema.modelo.dao;

import java.util.List;

import com.ilinesolution.sistema.modelo.entidades.Producto;

public interface ProductoDao {

	public void insertarProducto(Producto producto);
	public List<Producto> listaProducto();
	public void actualizarProducto(Producto producto);
	public void eliminarProducto(Producto producto);
}
