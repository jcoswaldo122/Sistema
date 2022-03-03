package com.ilinesolution.sistema.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "detalleFactura")
public class DetalleFactura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codDetalleFactura;
	private int cantidad;
	private int total;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkFactura")
	private Factura fkFactura;	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkProducto")
	private Producto fkProducto;	

	
	public DetalleFactura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodDetalleFactura() {
		return codDetalleFactura;
	}
	public void setCodDetalleFactura(int codDetalleFactura) {
		this.codDetalleFactura = codDetalleFactura;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	

}
