package com.ilinesolution.sistema.vistas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ilinesolution.sistema.controlador.CategoriaControlador;
import com.ilinesolution.sistema.controlador.ProductoControlador;
import com.ilinesolution.sistema.controlador.impl.CategoriaControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Categoria;
import com.ilinesolution.sistema.modelo.entidades.Producto;

@ManagedBean
@ViewScoped
public class CategoriaView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoriaControlador categoriaControlador;
	private Categoria categoria;
	private List<Categoria> listarCategoria;
	
	private ProductoControlador productoControlador;
	private Producto producto;
	private List<Producto> listarProducto;
	
	
	@PostConstruct
	public void init() {
		categoriaControlador = new CategoriaControladorImpl();
		listarCategoria();
		
	}
	
	public void preparar() {
		categoria = new Categoria();
	}
	
	public void insertarCategoria() {
		try {
			categoriaControlador = new CategoriaControladorImpl();
			
			categoriaControlador.insertarCategoria(categoria);
			
			listarCategoria();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Categoria  Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar Categoria "));
		}
	}
	
public void listarCategoria() {
	categoriaControlador = new CategoriaControladorImpl();
	listarCategoria = categoriaControlador.listaCategoria();
	}
	
	public void modificarCategoria() {
		try {
			categoriaControlador = new CategoriaControladorImpl();
			
			categoriaControlador.modificarCategoria(categoria);
			
			listarCategoria();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Categoria  Modificado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Modificar Categoria "));
		}
	}
	
public void eliminarCategoria() {
	try {
		categoriaControlador = new CategoriaControladorImpl();
		
		categoriaControlador.eliminarCategoria(categoria);
		
		listarCategoria();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Categoria  Eliminado Exitosamente"));
	
	} catch (Exception e) {
		System.out.println("ERROR"+ e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Eliminar Categoria "));
	}
	}

public CategoriaControlador getCategoriaControlador() {
	return categoriaControlador;
}

public void setCategoriaControlador(CategoriaControlador categoriaControlador) {
	this.categoriaControlador = categoriaControlador;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

public List<Categoria> getListarCategoria() {
	return listarCategoria;
}

public void setListarCategoria(List<Categoria> listarCategoria) {
	this.listarCategoria = listarCategoria;
}

public ProductoControlador getProductoControlador() {
	return productoControlador;
}

public void setProductoControlador(ProductoControlador productoControlador) {
	this.productoControlador = productoControlador;
}

public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}

public List<Producto> getListarProducto() {
	return listarProducto;
}

public void setListarProducto(List<Producto> listarProducto) {
	this.listarProducto = listarProducto;
}


}
