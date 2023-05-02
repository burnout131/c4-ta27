/**
 * 
 */
package com.mrojo.ta27ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej2.dao.CientificoDAO;
import com.mrojo.ta27ej2.dto.Cientifico;

/**
 * @author Marc
 *
 */
@Service
public class CientificoService {
	@Autowired
	CientificoDAO cientificoDAO;

	public List<Cientifico> listCientificos() {
		return cientificoDAO.findAll();
	}

	public Cientifico saveCientifico(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}

	public Cientifico cientificoById(String id) {
		return cientificoDAO.findById(id).get();
	}

	public Cientifico updateCientifico(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}

	public void deleteCientifico(String id) {
		cientificoDAO.deleteById(id);
	}
}
