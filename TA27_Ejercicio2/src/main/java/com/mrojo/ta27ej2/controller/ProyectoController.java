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

import com.mrojo.ta27ej2.dto.Proyecto;
import com.mrojo.ta27ej2.service.ProyectoService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;

	@GetMapping("/proyectos")
	public List<Proyecto> listProyectos() {
		return proyectoService.listProyectos();
	}

	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoById(@PathVariable(name = "id") String id) {
		Proyecto proyectoxID = new Proyecto();

		proyectoxID = proyectoService.proyectoById(id);

		return proyectoxID;
	}

	@PostMapping("/proyectos")
	public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.saveProyecto(proyecto);
	}

	@PutMapping("/proyectos/{id}")
	public Proyecto updateProyecto(@PathVariable(name = "id") String id, @RequestBody Proyecto proyecto) {
		Proyecto selectedProyecto = new Proyecto(id, proyecto.getNombre(), proyecto.getHoras());
		Proyecto updatedProyecto = new Proyecto();

		updatedProyecto = proyectoService.updateProyecto(selectedProyecto);
		return updatedProyecto;
	}

	@DeleteMapping("/proyectos/{id}")
	public void deleteProyecto(@PathVariable(name = "id") String id) {
		proyectoService.deleteProyecto(id);
	}
}
