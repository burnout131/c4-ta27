/**
 * 
 */
package com.mrojo.ta27ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej3.dao.ProductoDAO;
import com.mrojo.ta27ej3.dto.Producto;

/**
 * @author Marc
 *
 */
@Service
public class ProductoService {

	@Autowired
	ProductoDAO productoDAO;

	public List<Producto> listProductos() {
		return productoDAO.findAll();
	}

	public Producto saveProducto(Producto producto) {
		return productoDAO.save(producto);
	}

	public Producto productoById(Long id) {
		return productoDAO.findById(id).get();
	}

	public Producto updateProducto(Producto producto) {
		return productoDAO.save(producto);
	}

	public void deleteProducto(Long id) {
		productoDAO.deleteById(id);
	}
}
