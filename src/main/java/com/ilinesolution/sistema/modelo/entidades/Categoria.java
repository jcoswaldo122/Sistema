package com.ilinesolution.sistema.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codCategoria;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkCategoria")
    private List<Producto> fkProducto = new ArrayList<>();

	public Categoria() {
		super();
		// TODO Esbozo de constructor generado automáticamente
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public List<Producto> getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(List<Producto> fkProducto) {
		this.fkProducto = fkProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
