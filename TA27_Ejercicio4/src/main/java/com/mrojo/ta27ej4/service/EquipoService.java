/**
 * 
 */
package com.mrojo.ta27ej4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej4.dao.EquipoDAO;
import com.mrojo.ta27ej4.dto.Equipo;

/**
 * @author Marc
 *
 */
@Service
public class EquipoService {

	@Autowired
	EquipoDAO equipoDAO;

	public List<Equipo> listEquipos() {
		return equipoDAO.findAll();
	}

	public Equipo saveEquipo(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	public Equipo equipoById(String id) {
		return equipoDAO.findById(id).get();
	}

	public Equipo updateEquipo(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	public void deleteEquipo(String id) {
		equipoDAO.deleteById(id);
	}
}
