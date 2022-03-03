package com.ilinesolution.sistema.controlador.impl;

import java.util.List;

import com.ilinesolution.sistema.controlador.VendedorControlador;
import com.ilinesolution.sistema.modelo.dao.VendedorDao;
import com.ilinesolution.sistema.modelo.dao.impl.VendedorDaoImpl;
import com.ilinesolution.sistema.modelo.entidades.Vendedor;

public class VendedorControladorImpl implements VendedorControlador {

	private VendedorDao vendedorDao;

	@Override
	public void insertarVendedor(Vendedor vendedor) {
		vendedorDao = new VendedorDaoImpl();
		vendedorDao.insertarVendedor(vendedor);
		
	}

	@Override
	public List<Vendedor> listaVendedor() {
		vendedorDao = new VendedorDaoImpl();
		return vendedorDao.listaVendedor();
	}


	@Override
	public void modificarVendedor(Vendedor vendedor) {
		vendedorDao = new VendedorDaoImpl();
		vendedorDao.modificarVendedor(vendedor);
		
	}

	@Override
	public void eliminarVendedor(Vendedor vendedor) {
		vendedorDao = new VendedorDaoImpl();
		vendedorDao.eliminarVendedor(vendedor);
		
	}

}