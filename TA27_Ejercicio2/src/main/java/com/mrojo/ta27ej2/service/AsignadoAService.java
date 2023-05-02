/**
 * 
 */
package com.mrojo.ta27ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej2.dao.AsignadoADAO;
import com.mrojo.ta27ej2.dto.AsignadoA;

/**
 * @author Marc
 *
 */
@Service
public class AsignadoAService {
	@Autowired
	AsignadoADAO asignadoADAO;

	public List<AsignadoA> listAsignadoA() {
		return asignadoADAO.findAll();
	}

	public AsignadoA saveAsignadoA(AsignadoA asignadoA) {
		return asignadoADAO.save(asignadoA);
	}

	public AsignadoA asignadoAById(Long id) {
		return asignadoADAO.findById(id).get();
	}

	public AsignadoA updateAsignadoA(AsignadoA asignadoA) {
		return asignadoADAO.save(asignadoA);
	}

	public void deleteAsignadoA(Long id) {
		asignadoADAO.deleteById(id);
	}
}
