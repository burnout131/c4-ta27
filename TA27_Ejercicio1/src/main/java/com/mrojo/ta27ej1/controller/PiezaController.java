/**
 * 
 */
package com.mrojo.ta27ej1.controller;

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

import com.mrojo.ta27ej1.dto.Pieza;
import com.mrojo.ta27ej1.service.PiezaService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaService piezaService;

	@GetMapping("/piezas")
	public List<Pieza> listPiezas() {
		return piezaService.listPiezas();
	}

	@GetMapping("/piezas/{id}")
	public Pieza piezaById(@PathVariable(name = "id") Long id) {
		Pieza piezaxID = new Pieza();

		piezaxID = piezaService.piezaById(id);

		return piezaxID;
	}

	@PostMapping("/piezas")
	public Pieza savePieza(@RequestBody Pieza pieza) {
		return piezaService.savePieza(pieza);
	}

	@PutMapping("/piezas/{id}")
	public Pieza updatePieza(@PathVariable(name = "id") Long id, @RequestBody Pieza pieza) {
		Pieza selectedPieza = new Pieza(id, pieza.getNombre());
		Pieza updatedPieza = new Pieza();

		updatedPieza = piezaService.updatePieza(selectedPieza);
		return updatedPieza;
	}

	@DeleteMapping("/piezas/{id}")
	public void deletePieza(@PathVariable(name = "id") Long id) {
		piezaService.deletePieza(id);
	}
}
