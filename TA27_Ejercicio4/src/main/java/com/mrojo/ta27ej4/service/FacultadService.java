/**
 * 
 */
package com.mrojo.ta27ej4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej4.dao.FacultadDAO;
import com.mrojo.ta27ej4.dto.Facultad;

/**
 * @author Marc
 *
 */
@Service
public class FacultadService {

	@Autowired
	FacultadDAO facultadDAO;

	public List<Facultad> listFacultades() {
		return facultadDAO.findAll();
	}

	public Facultad saveFacultad(Facultad facultad) {
		return facultadDAO.save(facultad);
	}

	public Facultad facultadById(Long id) {
		return facultadDAO.findById(id).get();
	}

	public Facultad updateFacultad(Facultad facultad) {
		return facultadDAO.save(facultad);
	}

	public void deleteFacultad(Long id) {
		facultadDAO.deleteById(id);
	}
}
