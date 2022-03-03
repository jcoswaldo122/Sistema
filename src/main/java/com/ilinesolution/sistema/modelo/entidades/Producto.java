package com.ilinesolution.sistema.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codProducto;
	private String nombre;
	private double precioVenta;
	private int stockMinimo;
	private int stockActual;
	private String codBarras;
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkProducto")
    private List<DetalleFactura> fkDetalleFactura = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkCategoria")
	private Categoria fkCategoria;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public List<DetalleFactura> getFkDetalleFactura() {
		return fkDetalleFactura;
	}
	public void setFkDetalleFactura(List<DetalleFactura> fkDetalleFactura) {
		this.fkDetalleFactura = fkDetalleFactura;
	}
	public Categoria getFkCategoria() {
		return fkCategoria;
	}
	public void setFkCategoria(Categoria fkCategoria) {
		this.fkCategoria = fkCategoria;
	}
	

}
