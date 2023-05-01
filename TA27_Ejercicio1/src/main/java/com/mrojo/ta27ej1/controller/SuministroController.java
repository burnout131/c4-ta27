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

import com.mrojo.ta27ej1.dto.Suministro;
import com.mrojo.ta27ej1.service.SuministroService;

/**
 * @author Marc
 *
 */
@RestController // Rest controller
@RequestMapping("/api")
public class SuministroController {
	
	@Autowired
	SuministroService suministroService;

	@GetMapping("/suministros")
	public List<Suministro> listSuministros() {
		return suministroService.listSuministros();
	}

	@GetMapping("/suministros/{id}")
	public Suministro suministroById(@PathVariable(name = "id") Long id) {
		Suministro suministroxID = new Suministro();

		suministroxID = suministroService.suministroById(id);

		return suministroxID;
	}

	@PostMapping("/suministros")
	public Suministro saveSuministro(@RequestBody Suministro suministro) {
		return suministroService.saveSuministro(suministro);
	}

	@PutMapping("/suministros/{id}")
	public Suministro updateSuministro(@PathVariable(name = "id") Long id, @RequestBody Suministro suministro) {
		Suministro selectedSuministro = new Suministro(id, suministro.getPieza(), suministro.getProveedor(),
				suministro.getPrecio());
		Suministro updatedSuministro = new Suministro();

		updatedSuministro = suministroService.updateSuministro(selectedSuministro);
		return updatedSuministro;
	}

	@DeleteMapping("/suministros/{id}")
	public void deleteSuministro(@PathVariable(name = "id") Long id) {
		suministroService.deleteSuministro(id);
	}
}
