package com.ilinesolution.sistema.controlador;

import java.util.List;

import com.ilinesolution.sistema.modelo.entidades.Producto;

public interface ProductoControlador {

	public void insertarProducto(Producto producto);
	public List<Producto> listaProducto();
	public void actualizarProducto(Producto producto);
	public void eliminarProducto(Producto producto);
}
