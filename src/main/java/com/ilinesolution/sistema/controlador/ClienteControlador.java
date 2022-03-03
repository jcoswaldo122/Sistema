package com.ilinesolution.sistema.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.ilinesolution.sistema.modelo.entidades.Cliente;

public interface ClienteControlador {

	public void insertarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
    public List<Cliente> listaCliente();
    
    public Cliente buscarClienteCod(int codCliente);
    public List<Tuple> listarIdNombre();
    public Cliente buscarClienteId(int codCliente);
    public Cliente getClienteId(int codCliente);
    public Cliente buscarClienteEmail(String emailCliente);
}
