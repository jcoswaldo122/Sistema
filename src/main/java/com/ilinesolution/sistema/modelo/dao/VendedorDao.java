package com.ilinesolution.sistema.modelo.dao;



import java.util.List;

import com.ilinesolution.sistema.modelo.entidades.Vendedor;

public interface VendedorDao {
	public void insertarVendedor(Vendedor vendedor);
	public void modificarVendedor(Vendedor vendedor);
	public void eliminarVendedor(Vendedor vendedor);
	public List<Vendedor> listaVendedor();
}
