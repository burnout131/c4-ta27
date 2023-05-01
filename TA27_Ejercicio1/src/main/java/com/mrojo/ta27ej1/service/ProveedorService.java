/**
 * 
 */
package com.mrojo.ta27ej1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej1.dao.ProveedorDAO;
import com.mrojo.ta27ej1.dto.Proveedor;

/**
 * @author Marc
 *
 */
@Service
public class ProveedorService {
	@Autowired
	ProveedorDAO proveedorDAO;

	public List<Proveedor> listProveedores() {
		return proveedorDAO.findAll();
	}

	public Proveedor saveProveedor(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}

	public Proveedor proveedorById(String id) {
		return proveedorDAO.findById(id).get();
	}

	public Proveedor updateProveedor(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}

	public void deleteProveedor(String id) {
		proveedorDAO.deleteById(id);
	}

}
