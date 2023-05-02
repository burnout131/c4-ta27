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

import com.mrojo.ta27ej4.dto.Facultad;
import com.mrojo.ta27ej4.service.FacultadService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadService facultadService;

	@GetMapping("/facultades")
	public List<Facultad> listFacultades() {
		return facultadService.listFacultades();
	}

	@GetMapping("/facultades/{id}")
	public Facultad facultadById(@PathVariable(name = "id") Long id) {
		Facultad facultadxID = new Facultad();

		facultadxID = facultadService.facultadById(id);

		return facultadxID;
	}

	@PostMapping("/facultades")
	public Facultad saveFacultad(@RequestBody Facultad facultad) {
		return facultadService.saveFacultad(facultad);
	}

	@PutMapping("/facultades/{id}")
	public Facultad updateFacultad(@PathVariable(name = "id") Long id, @RequestBody Facultad facultad) {
		Facultad selectedFacultad = new Facultad(id, facultad.getNombre());
		Facultad updatedFacultad = new Facultad();

		updatedFacultad = facultadService.updateFacultad(selectedFacultad);
		return updatedFacultad;
	}

	@DeleteMapping("/facultades/{id}")
	public void deleteFacultad(@PathVariable(name = "id") Long id) {
		facultadService.deleteFacultad(id);
	}

}
