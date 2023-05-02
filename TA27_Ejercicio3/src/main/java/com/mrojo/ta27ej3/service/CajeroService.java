/**
 * 
 */
package com.mrojo.ta27ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej3.dao.CajeroDAO;
import com.mrojo.ta27ej3.dto.Cajero;

/**
 * @author Marc
 *
 */
@Service
public class CajeroService {

	@Autowired
	CajeroDAO cajeroDAO;

	public List<Cajero> listCajeros() {
		return cajeroDAO.findAll();
	}

	public Cajero saveCajero(Cajero cajero) {
		return cajeroDAO.save(cajero);
	}

	public Cajero cajeroById(Long id) {
		return cajeroDAO.findById(id).get();
	}

	public Cajero updateCajero(Cajero cajero) {
		return cajeroDAO.save(cajero);
	}

	public void deleteCajero(Long id) {
		cajeroDAO.deleteById(id);
	}
}
