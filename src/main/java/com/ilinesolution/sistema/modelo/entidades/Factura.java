package com.ilinesolution.sistema.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "factura")
public class Factura implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codFactura;
	private String numFactura;
	private double totalVenta;
	private Date fechaRegistro;
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkFactura")
    private List<DetalleFactura> fkDetalleFactura = new ArrayList<>();
		
		@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		@JoinColumn(name = "fkVendedor")
		private Vendedor fkVendedor;	
		
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinColumn(name = "fkCliente")		
		private Cliente fkCliente;

		public Factura() {
			super();
			// TODO Auto-generated constructor stub
		}	
	private static final long serialVersionUID = 1L;
	public int getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(int codFactura) {
		this.codFactura = codFactura;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

		
	}
		
