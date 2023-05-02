/**
 * 
 */
package com.mrojo.ta27ej4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrojo.ta27ej4.dto.Equipo;
import com.mrojo.ta27ej4.service.EquipoService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoService equipoService;

	@GetMapping("/equipos")
	public List<Equipo> listEquipos() {
		return equipoService.listEquipos();
	}

	@GetMapping("/equipos/{id}")
	public Equipo equipoById(@PathVariable(name = "id") String id) {
		Equipo equipoxID = new Equipo();

		equipoxID = equipoService.equipoById(id);

		return equipoxID;
	}

	@PostMapping("/equipos")
	public Equipo saveEquipo(@RequestBody Equipo equipo) {
		return equipoService.saveEquipo(equipo);
	}

	@PutMapping("/equipos/{id}")
	public Equipo updateEquipo(@PathVariable(name = "id") String id, @RequestBody Equipo equipo) {
		Equipo selectedEquipo = new Equipo(id, equipo.getNombre(), equipo.getFacultad());
		Equipo updatedEquipo = new Equipo();

		updatedEquipo = equipoService.updateEquipo(selectedEquipo);
		return updatedEquipo;
	}

	@DeleteMapping("/equipos/{id}")
	public void deleteEquipo(@PathVariable(name = "id") String id) {
		equipoService.deleteEquipo(id);
	}
}
