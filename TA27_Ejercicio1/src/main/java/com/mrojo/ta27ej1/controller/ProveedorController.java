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

import com.mrojo.ta27ej1.dto.Proveedor;
import com.mrojo.ta27ej1.service.ProveedorService;

/**
 * @author Marc
 *
 */
@RestController // Rest controller
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorService proveedorService;

	@GetMapping("/proveedores")
	public List<Proveedor> listProveedores() {
		return proveedorService.listProveedores();
	}

	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorById(@PathVariable(name = "id") String id) {
		Proveedor proveedorxID = new Proveedor();

		proveedorxID = proveedorService.proveedorById(id);

		return proveedorxID;
	}

	@PostMapping("/proveedores")
	public Proveedor saveProveedor(@RequestBody Proveedor proveedor) {
		return proveedorService.saveProveedor(proveedor);
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor updateProveedor(@PathVariable(name = "id") String id, @RequestBody Proveedor proveedor) {
		Proveedor selectedProveedor = new Proveedor(id, proveedor.getNombre());
		Proveedor updatedProveedor = new Proveedor();

		updatedProveedor = proveedorService.updateProveedor(selectedProveedor);
		return updatedProveedor;
	}

	@DeleteMapping("/proveedores/{id}")
	public void deleteProveedor(@PathVariable(name = "id") String id) {
		proveedorService.deleteProveedor(id);
	}
}
