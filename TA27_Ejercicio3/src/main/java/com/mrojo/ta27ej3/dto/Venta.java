/**
 * 
 */
package com.mrojo.ta27ej3.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Marc
 *
 */
@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajero cajero;

	@ManyToOne
	@JoinColumn(name = "producto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "maquina_registradora")
	private MaquinaRegistradora maquinaRegistradora;

	public Venta() {
	}

	public Venta(Long id, Cajero cajero, Producto producto, MaquinaRegistradora maquinaRegistradora) {
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinaRegistradora = maquinaRegistradora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}

}
