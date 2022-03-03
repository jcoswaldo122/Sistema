package com.ilinesolution.sistema.vistas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ilinesolution.sistema.controlador.ClienteControlador;
import com.ilinesolution.sistema.controlador.impl.ClienteControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Cliente;

@ManagedBean
@ViewScoped
public class ClienteView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClienteControlador clienteControlador;
    private Cliente cliente;
    private List<Cliente> listarCliente;  
    private Cliente encontrado;
    private int codCliente;
    
    //private int idCliente; //fkCliente Para llaar desde html
    //private Cliente nuevo;
   // private List<Cliente> listarCliente();
    
    
   
    @PostConstruct
    public void init() {
        cliente = new Cliente();
    	//clienteControlador = new ClienteControladorImpl();
    	listarCliente();	
    
    }
    
    
    public void preparar() {
		cliente = new Cliente();
	}
	
	public void insertarCliente() {
		try {
			clienteControlador = new ClienteControladorImpl();
			
			clienteControlador.insertarCliente(cliente);
			
			listarCliente();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Cliente  Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar Cliente "));
		}
	}
	
	public void modificarCliente() {
		try {
			clienteControlador = new ClienteControladorImpl();
			
			clienteControlador.modificarCliente(cliente);
			
			listarCliente();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Cliente Modificado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Modificar Cliente "));
		}
	}
	
	
	public void eliminarCliente() {
		try {
			clienteControlador = new ClienteControladorImpl();
			
			clienteControlador.eliminarCliente(cliente);
			
			listarCliente();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Cliente Eliminado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error Modificado Climete "));
		}
	}
	
	
	public void listarCliente() {
		clienteControlador = new ClienteControladorImpl();
		listarCliente = clienteControlador.listaCliente();
	}
	
	/*public void buscarClienteId() {		
		
		try {
			clienteControlador = new ClienteControladorImpl();
			
			encontrado = clienteControlador.buscarClienteId(codCliente);
			
			listarCliente();
			
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			}
	
	}*/
	
	public void buscarClientebyId(){
		try {
			clienteControlador = new ClienteControladorImpl();
	        encontrado = clienteControlador.getClienteId(codCliente);
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		

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


	public List<Cliente> getListarCliente() {
		return listarCliente;
	}


	public void setListarCliente(List<Cliente> listarCliente) {
		this.listarCliente = listarCliente;
	}


	public Cliente getEncontrado() {
		return encontrado;
	}


	public void setEncontrado(Cliente encontrado) {
		this.encontrado = encontrado;
	}


	public int getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}


	
	
}
