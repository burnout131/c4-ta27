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

import com.mrojo.ta27ej3.dto.Venta;
import com.mrojo.ta27ej3.service.VentaService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaService ventaService;

	@GetMapping("/ventas")
	public List<Venta> listVentas() {
		return ventaService.listVentas();
	}

	@GetMapping("/ventas/{id}")
	public Venta ventaById(@PathVariable(name = "id") Long id) {
		Venta ventaxID = new Venta();

		ventaxID = ventaService.ventaById(id);

		return ventaxID;
	}

	@PostMapping("/ventas")
	public Venta saveVenta(@RequestBody Venta venta) {
		return ventaService.saveVenta(venta);
	}

	@PutMapping("/ventas/{id}")
	public Venta updateVenta(@PathVariable(name = "id") Long id, @RequestBody Venta venta) {
		Venta selectedVenta = new Venta(id, venta.getCajero(), venta.getProducto(), venta.getMaquinaRegistradora());
		Venta updatedVenta = new Venta();

		updatedVenta = ventaService.updateVenta(selectedVenta);
		return updatedVenta;
	}

	@DeleteMapping("/ventas/{id}")
	public void deleteVenta(@PathVariable(name = "id") Long id) {
		ventaService.deleteVenta(id);
	}
}
