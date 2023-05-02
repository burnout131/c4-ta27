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

import com.mrojo.ta27ej2.dto.Cientifico;
import com.mrojo.ta27ej2.service.CientificoService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoService cientificoService;

	@GetMapping("/cientificos")
	public List<Cientifico> listCientificos() {
		return cientificoService.listCientificos();
	}

	@GetMapping("/cientificos/{dni}")
	public Cientifico cientificoById(@PathVariable(name = "dni") String dni) {
		Cientifico cientificoxID = new Cientifico();

		cientificoxID = cientificoService.cientificoById(dni);

		return cientificoxID;
	}

	@PostMapping("/cientificos")
	public Cientifico saveCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.saveCientifico(cientifico);
	}

	@PutMapping("/cientificos/{dni}")
	public Cientifico updateCientifico(@PathVariable(name = "dni") String dni, @RequestBody Cientifico cientifico) {
		Cientifico selectedCientifico = new Cientifico(dni, cientifico.getNombreApellidos());
		Cientifico updatedCientifico = new Cientifico();

		updatedCientifico = cientificoService.updateCientifico(selectedCientifico);
		return updatedCientifico;
	}

	@DeleteMapping("/cientificos/{dni}")
	public void deleteCientifico(@PathVariable(name = "dni") String dni) {
		cientificoService.deleteCientifico(dni);
	}
}
