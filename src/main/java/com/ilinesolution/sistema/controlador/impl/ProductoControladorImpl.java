package com.ilinesolution.sistema.controlador.impl;

import java.util.List;

import com.ilinesolution.sistema.controlador.ProductoControlador;
import com.ilinesolution.sistema.modelo.dao.ProductoDao;
import com.ilinesolution.sistema.modelo.dao.impl.ProductoDaoImpl;
import com.ilinesolution.sistema.modelo.entidades.Producto;

public class ProductoControladorImpl implements ProductoControlador{

	private ProductoDao productoDao;
	@Override
	public void insertarProducto(Producto producto) {
		productoDao = new ProductoDaoImpl();
		productoDao.insertarProducto(producto);
		
	}

	@Override
	public List<Producto> listaProducto() {
		productoDao = new ProductoDaoImpl();
		return productoDao.listaProducto();
	}

	@Override
	public void actualizarProducto(Producto producto) {
		productoDao = new ProductoDaoImpl();
		productoDao.actualizarProducto(producto);
	}

	@Override
	public void eliminarProducto(Producto producto) {
		productoDao = new ProductoDaoImpl();
		productoDao.eliminarProducto(producto);
	}

}
