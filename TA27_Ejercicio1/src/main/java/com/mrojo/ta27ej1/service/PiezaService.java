/**
 * 
 */
package com.mrojo.ta27ej1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej1.dao.PiezaDAO;
import com.mrojo.ta27ej1.dto.Pieza;

/**
 * @author Marc
 *
 */
@Service
public class PiezaService {
	@Autowired
	PiezaDAO piezaDAO;

	public List<Pieza> listPiezas() {
		return piezaDAO.findAll();
	}

	public Pieza savePieza(Pieza pieza) {
		return piezaDAO.save(pieza);
	}

	public Pieza piezaById(Long id) {
		return piezaDAO.findById(id).get();
	}

	public Pieza updatePieza(Pieza pieza) {
		return piezaDAO.save(pieza);
	}

	public void deletePieza(Long id) {
		piezaDAO.deleteById(id);
	}
}
