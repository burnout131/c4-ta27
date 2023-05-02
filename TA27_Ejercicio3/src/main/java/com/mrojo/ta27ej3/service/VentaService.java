/**
 * 
 */
package com.mrojo.ta27ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej3.dao.VentaDAO;
import com.mrojo.ta27ej3.dto.Venta;

/**
 * @author Marc
 *
 */
@Service
public class VentaService {

	@Autowired
	VentaDAO ventaDAO;

	public List<Venta> listVentas() {
		return ventaDAO.findAll();
	}

	public Venta saveVenta(Venta venta) {
		return ventaDAO.save(venta);
	}

	public Venta ventaById(Long id) {
		return ventaDAO.findById(id).get();
	}

	public Venta updateVenta(Venta venta) {
		return ventaDAO.save(venta);
	}

	public void deleteVenta(Long id) {
		ventaDAO.deleteById(id);
	}
}
