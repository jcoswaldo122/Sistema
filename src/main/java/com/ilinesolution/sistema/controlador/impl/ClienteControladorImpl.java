package com.ilinesolution.sistema.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.ilinesolution.sistema.controlador.ClienteControlador;
import com.ilinesolution.sistema.modelo.dao.ClienteDao;
import com.ilinesolution.sistema.modelo.dao.impl.ClienteDaoImpl;
import com.ilinesolution.sistema.modelo.entidades.Cliente;

public class ClienteControladorImpl implements ClienteControlador{
	
	private ClienteDao clienteDao;  //interface

	@Override
	public void insertarCliente(Cliente cliente) {
		clienteDao = new ClienteDaoImpl();
		clienteDao.insertarCliente(cliente);
		
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		clienteDao = new ClienteDaoImpl();
		clienteDao.modificarCliente(cliente);
		
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		clienteDao = new ClienteDaoImpl();
		clienteDao.eliminarCliente(cliente);
		
	}

	@Override
	public List<Cliente> listaCliente() {
		clienteDao = new ClienteDaoImpl();
		return clienteDao.listaCliente();
	}

	@Override
	public Cliente buscarClienteCod(int codCliente) {
		clienteDao = new ClienteDaoImpl();
		return clienteDao.buscarClienteCod(codCliente);
	}

	@Override
	public List<Tuple> listarIdNombre() {
		clienteDao = new ClienteDaoImpl();
		return clienteDao.listarIdNombre();
	}


	@Override
	public Cliente buscarClienteId(int codCliente) {
		clienteDao = new ClienteDaoImpl();
		return clienteDao.buscarClienteId(codCliente);
	}

	@Override
	public Cliente getClienteId(int codCliente) {
		
	try {
		clienteDao = new ClienteDaoImpl();
		return  buscarClienteId(codCliente);
	} catch (Exception e) {
		return null;
	}
			

	}

	@Override
	public Cliente buscarClienteEmail(String emailCliente) {
		try {
			clienteDao = new ClienteDaoImpl();
			return clienteDao.buscarClienteEmail(emailCliente);
			
		} catch (Exception e) {
			return null;
		}
	}

}
