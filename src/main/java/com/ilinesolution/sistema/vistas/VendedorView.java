package com.ilinesolution.sistema.vistas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ilinesolution.sistema.controlador.VendedorControlador;
import com.ilinesolution.sistema.controlador.impl.VendedorControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Vendedor;

@ManagedBean
@ViewScoped
public class VendedorView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vendedor vendedor;
	
	private VendedorControlador vendedorControlador;
	private List<Vendedor> listarVendedor;

	@PostConstruct
	public void init() {
		listarVendedor = new ArrayList<Vendedor>();
		vendedor = new Vendedor();

		listarVendedor();
		
	}

	public void preparar() {
		vendedor = new Vendedor();
	}
	
	public void insertarVendedor() {
		try {
			vendedorControlador = new VendedorControladorImpl();
			
			vendedorControlador.insertarVendedor(vendedor);
			
			listarVendedor();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}
	public void listarVendedor() {
		vendedorControlador = new VendedorControladorImpl();
		listarVendedor = vendedorControlador.listaVendedor();
	}
	
	
	public void modificarVendedor() {
		try {
			vendedorControlador = new VendedorControladorImpl();
			
			vendedorControlador.modificarVendedor(vendedor);
			
			listarVendedor();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}
	
	
	public void eliminarVendedor() {
		try {
			vendedorControlador = new VendedorControladorImpl();
			
			vendedorControlador.eliminarVendedor(vendedor);
			
			listarVendedor();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public VendedorControlador getVendedorControlador() {
		return vendedorControlador;
	}

	public void setVendedorControlador(VendedorControlador vendedorControlador) {
		this.vendedorControlador = vendedorControlador;
	}

	public List<Vendedor> getListarVendedor() {
		return listarVendedor;
	}

	public void setListarVendedor(List<Vendedor> listarVendedor) {
		this.listarVendedor = listarVendedor;
	}



}