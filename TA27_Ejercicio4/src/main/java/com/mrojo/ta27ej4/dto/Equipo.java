/**
 * 
 */
package com.mrojo.ta27ej4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Marc
 *
 */
@Entity
@Table(name = "equipos")
public class Equipo {

	@Id
	private String id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "equipo")
	private List<Reserva> reserva;

	public Equipo() {
	}

	public Equipo(String id, String nombre, Facultad facultad) {
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	
	
}
