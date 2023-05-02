/**
 * 
 */
package com.mrojo.ta27ej2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Marc
 *
 */
@Entity
@Table(name = "cientificos")
public class Cientifico {

	@Id
	private String dni;

	@Column (name = "nombre_apellidos")
	private String nombreApellidos;

	@OneToMany
	@JoinColumn(name = "cientifico")
	private List<AsignadoA> asignadoA;

	
	public Cientifico() {
	}

	public Cientifico(String dni, String nombreApellidos) {
		this.dni = dni;
		this.nombreApellidos = nombreApellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(List<AsignadoA> asignadoA) {
		this.asignadoA = asignadoA;
	}

	

}
