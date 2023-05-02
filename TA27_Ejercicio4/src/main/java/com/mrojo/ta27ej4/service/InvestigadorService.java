/**
 * 
 */
package com.mrojo.ta27ej4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej4.dao.InvestigadorDAO;
import com.mrojo.ta27ej4.dto.Investigador;

/**
 * @author Marc
 *
 */
@Service
public class InvestigadorService {

	@Autowired
	InvestigadorDAO InvestigadorDAO;

	public List<Investigador> listInvestigadores() {
		return InvestigadorDAO.findAll();
	}

	public Investigador saveInvestigador(Investigador Investigador) {
		return InvestigadorDAO.save(Investigador);
	}

	public Investigador InvestigadorById(String dni) {
		return InvestigadorDAO.findById(dni).get();
	}

	public Investigador updateInvestigador(Investigador Investigador) {
		return InvestigadorDAO.save(Investigador);
	}

	public void deleteInvestigador(String dni) {
		InvestigadorDAO.deleteById(dni);
	}
}
