/**
 * 
 */
package com.mrojo.ta27ej1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Marc
 *
 */
@Entity
@Table(name = "piezas")
public class Pieza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany
	@JoinColumn(name = "pieza")
	private List<Suministro> suministro;

	/**
	 * 
	 */
	public Pieza() {
	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Pieza(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the suministro
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministro")
	public List<Suministro> getSuministro() {
		return suministro;
	}

	/**
	 * @param suministro the suministro to set
	 */
	public void setSuministro(List<Suministro> suministro) {
		this.suministro = suministro;
	}

}
