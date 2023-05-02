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

import com.mrojo.ta27ej3.dto.MaquinaRegistradora;
import com.mrojo.ta27ej3.service.MaquinaRegistradoraService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraService maquinaRegistradoraService;

	@GetMapping("/maquinas_registradoras")
	public List<MaquinaRegistradora> listMaquinas_Registradoras() {
		return maquinaRegistradoraService.listMaquinasRegistradoras();
	}

	@GetMapping("/maquinas_registradoras/{id}")
	public MaquinaRegistradora maquinaRegistradoraById(@PathVariable(name = "id") Long id) {
		MaquinaRegistradora maquinaRegistradoraxID = new MaquinaRegistradora();

		maquinaRegistradoraxID = maquinaRegistradoraService.maquinaRegistradoraById(id);

		return maquinaRegistradoraxID;
	}

	@PostMapping("/maquinas_registradoras")
	public MaquinaRegistradora saveMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraService.saveMaquinaRegistradora(maquinaRegistradora);
	}

	@PutMapping("/maquinas_registradoras/{id}")
	public MaquinaRegistradora updateMaquinaRegistradora(@PathVariable(name = "id") Long id,
			@RequestBody MaquinaRegistradora maquinaRegistradora) {
		MaquinaRegistradora selectedMaquinaRegistradora = new MaquinaRegistradora(id, maquinaRegistradora.getPiso());
		MaquinaRegistradora updatedMaquinaRegistradora = new MaquinaRegistradora();

		updatedMaquinaRegistradora = maquinaRegistradoraService.updateMaquinaRegistradora(selectedMaquinaRegistradora);
		return updatedMaquinaRegistradora;
	}

	@DeleteMapping("/maquinas_registradoras/{id}")
	public void deleteMaquinaRegistradora(@PathVariable(name = "id") Long id) {
		maquinaRegistradoraService.deleteMaquinaRegistradora(id);
	}
}
