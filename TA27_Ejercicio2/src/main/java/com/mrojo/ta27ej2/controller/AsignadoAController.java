/**
 * 
 */
package com.mrojo.ta27ej2.controller;

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

import com.mrojo.ta27ej2.dto.AsignadoA;
import com.mrojo.ta27ej2.service.AsignadoAService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class AsignadoAController {

	@Autowired
	AsignadoAService asignadoAService;

	@GetMapping("/asignado_a")
	public List<AsignadoA> listAsignadoA() {
		return asignadoAService.listAsignadoA();
	}

	@GetMapping("/asignado_a/{id}")
	public AsignadoA asignadoAById(@PathVariable(name = "id") Long id) {
		AsignadoA asignadoAxID = new AsignadoA();

		asignadoAxID = asignadoAService.asignadoAById(id);

		return asignadoAxID;
	}

	@PostMapping("/asignado_a")
	public AsignadoA saveAsignado_A(@RequestBody AsignadoA asignadoA) {
		return asignadoAService.saveAsignadoA(asignadoA);
	}

	@PutMapping("/asignado_a/{id}")
	public AsignadoA updateAsignadoA(@PathVariable(name = "id") Long id, @RequestBody AsignadoA asignadoA) {
		AsignadoA selectedAsignadoA = new AsignadoA(id, asignadoA.getCientifico(), asignadoA.getProyecto());
		AsignadoA updatedAsignadoA = new AsignadoA();

		updatedAsignadoA = asignadoAService.updateAsignadoA(selectedAsignadoA);
		return updatedAsignadoA;
	}

	@DeleteMapping("/asignado_a/{id}")
	public void deleteAsignadoA(@PathVariable(name = "id") Long id) {
		asignadoAService.deleteAsignadoA(id);
	}
}
