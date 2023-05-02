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

import com.mrojo.ta27ej3.dto.Producto;
import com.mrojo.ta27ej3.service.ProductoService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/productos")
	public List<Producto> listProductos() {
		return productoService.listProductos();
	}

	@GetMapping("/productos/{id}")
	public Producto productoById(@PathVariable(name = "id") Long id) {
		Producto productoxID = new Producto();

		productoxID = productoService.productoById(id);

		return productoxID;
	}

	@PostMapping("/productos")
	public Producto saveProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}

	@PutMapping("/productos/{id}")
	public Producto updateProducto(@PathVariable(name = "id") Long id, @RequestBody Producto producto) {
		Producto selectedProducto = new Producto(id, producto.getNombre(), producto.getPrecio());
		Producto updatedProducto = new Producto();

		updatedProducto = productoService.updateProducto(selectedProducto);
		return updatedProducto;
	}

	@DeleteMapping("/productos/{id}")
	public void deleteProducto(@PathVariable(name = "id") Long id) {
		productoService.deleteProducto(id);
	}
}
