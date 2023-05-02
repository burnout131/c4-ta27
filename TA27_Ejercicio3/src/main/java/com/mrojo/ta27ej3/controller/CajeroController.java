/**
 * 
 */
package com.mrojo.ta27ej3.controller;

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

import com.mrojo.ta27ej3.dto.Cajero;
import com.mrojo.ta27ej3.service.CajeroService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroService cajeroService;

	@GetMapping("/cajeros")
	public List<Cajero> listCajeros() {
		return cajeroService.listCajeros();
	}

	@GetMapping("/cajeros/{id}")
	public Cajero cajeroById(@PathVariable(name = "id") Long id) {
		Cajero cajeroxID = new Cajero();

		cajeroxID = cajeroService.cajeroById(id);

		return cajeroxID;
	}

	@PostMapping("/cajeros")
	public Cajero saveCajero(@RequestBody Cajero cajero) {
		return cajeroService.saveCajero(cajero);
	}

	@PutMapping("/cajeros/{id}")
	public Cajero updateCajero(@PathVariable(name = "id") Long id, @RequestBody Cajero cajero) {
		Cajero selectedCajero = new Cajero(id, cajero.getNombreApellidos());
		Cajero updatedCajero = new Cajero();

		updatedCajero = cajeroService.updateCajero(selectedCajero);
		return updatedCajero;
	}

	@DeleteMapping("/cajeros/{id}")
	public void deleteCajero(@PathVariable(name = "id") Long id) {
		cajeroService.deleteCajero(id);
	}
}
