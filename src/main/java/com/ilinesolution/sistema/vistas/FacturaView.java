package com.ilinesolution.sistema.vistas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Tuple;

import com.ilinesolution.sistema.controlador.ClienteControlador;
import com.ilinesolution.sistema.controlador.impl.ClienteControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Cliente;

@ManagedBean
@ViewScoped
public class FacturaView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClienteControlador clienteControlador;
    private Cliente cliente;
	private int codCliente;
	private List<Tuple> encontrado;
	
	@PostConstruct
	public void init() {
		agregarDatosCliente();
	}
	
	public void agregarDatosCliente() {
		clienteControlador = new ClienteControladorImpl();
		encontrado = clienteControlador.listarIdNombre();
	}

	public void listarClienteIdNombre() {
		clienteControlador = new ClienteControladorImpl();
		encontrado = clienteControlador.listarIdNombre();
	}
	
	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public List<Tuple> getEncontrado() {
		return encontrado;
	}

	public void setEncontrado(List<Tuple> encontrado) {
		this.encontrado = encontrado;
	}


	

}
