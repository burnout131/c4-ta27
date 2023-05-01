/**
 * 
 */
package com.mrojo.ta27ej1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej1.dao.SuministroDAO;
import com.mrojo.ta27ej1.dto.Suministro;

/**
 * @author Marc
 *
 */
@Service
public class SuministroService {
	@Autowired
	SuministroDAO suministroDAO;

	// CRUD functions
	public List<Suministro> listSuministros() {
		return suministroDAO.findAll();
	}

	public Suministro saveSuministro(Suministro suministro) {
		return suministroDAO.save(suministro);
	}

	public Suministro suministroById(Long id) {
		return suministroDAO.findById(id).get();
	}

	public Suministro updateSuministro(Suministro suministro) {
		return suministroDAO.save(suministro);
	}

	public void deleteSuministro(Long id) {
		suministroDAO.deleteById(id);
	}
}
