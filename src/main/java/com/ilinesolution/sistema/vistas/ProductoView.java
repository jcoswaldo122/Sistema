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
import com.ilinesolution.sistema.controlador.impl.ProductoControladorImpl;
import com.ilinesolution.sistema.modelo.entidades.Categoria;
import com.ilinesolution.sistema.modelo.entidades.Producto;

@ManagedBean
@ViewScoped
public class ProductoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private ProductoControlador productoControlador;
	private List<Producto> listarProducto;
	
	private int codCategoria;//fk de la categoria 
	//private String codCategoria; //variable fk de la categoria 
	private Categoria categoria;//object of  de relacion 
	private CategoriaControlador categoriaControlador;
	private List<Categoria> listarCategoria;
	
	
	@PostConstruct
	public void init() {
		productoControlador = new ProductoControladorImpl();
		categoriaControlador = new CategoriaControladorImpl();
		listarProducto(); //List, fill table
		listarCategoria();//LLena el comboBox
	}
	//Set up 
	public void preparar() {
		producto = new Producto();

	}
	
	//Insert product
	public void insertarProducto() {
		try {
			productoControlador = new ProductoControladorImpl();
			categoria = new Categoria();
			
			
			categoria.setCodCategoria(codCategoria);
			producto.setFkCategoria(categoria);
			
			productoControlador.insertarProducto(producto);
			
			listarProducto();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}
	// List product 
	public void listarProducto() {
		listarProducto = productoControlador.listaProducto();
	}
	//List categories
	public void listarCategoria() {
		listarCategoria = categoriaControlador.listaCategoria();
	}
	//Modify product
	public void modificarProducto() {
		try {
			productoControlador = new ProductoControladorImpl();
			
			categoria = new Categoria();
			categoria.setCodCategoria(codCategoria);
			producto.setFkCategoria(categoria);
			productoControlador.actualizarProducto(producto);
			
			listarProducto();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}
	
	// Delete product
	public void eliminarProducto() {
		try {
			productoControlador = new ProductoControladorImpl();
			
			productoControlador.eliminarProducto(producto);
			
			listarProducto();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Listado o Registrado Exitosamente"));
		
		} catch (Exception e) {
			System.out.println("ERROR"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Info","Error al Registrar o listar "));
		}
	}
	
	//Getter and setter

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductoControlador getProductoControlador() {
		return productoControlador;
	}

	public void setProductoControlador(ProductoControlador productoControlador) {
		this.productoControlador = productoControlador;
	}

	public List<Producto> getListarProducto() {
		return listarProducto;
	}



	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaControlador getCategoriaControlador() {
		return categoriaControlador;
	}

	public void setCategoriaControlador(CategoriaControlador categoriaControlador) {
		this.categoriaControlador = categoriaControlador;
	}

	public List<Categoria> getListarCategoria() {
		return listarCategoria;
	}

	public void setListarCategoria(List<Categoria> listarCategoria) {
		this.listarCategoria = listarCategoria;
	}

	public void setListarProducto(List<Producto> listarProducto) {
		this.listarProducto = listarProducto;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	
}