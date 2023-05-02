/**
 * 
 */
package com.mrojo.ta27ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej3.dao.MaquinaRegistradoraDAO;
import com.mrojo.ta27ej3.dto.MaquinaRegistradora;

/**
 * @author Marc
 *
 */
@Service
public class MaquinaRegistradoraService {

	@Autowired
	MaquinaRegistradoraDAO maquinaRegistradoraDAO;

	public List<MaquinaRegistradora> listMaquinasRegistradoras() {
		return maquinaRegistradoraDAO.findAll();
	}

	public MaquinaRegistradora saveMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	public MaquinaRegistradora maquinaRegistradoraById(Long id) {
		return maquinaRegistradoraDAO.findById(id).get();
	}

	public MaquinaRegistradora updateMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	public void deleteMaquinaRegistradora(Long id) {
		maquinaRegistradoraDAO.deleteById(id);
	}
}
