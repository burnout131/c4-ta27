/**
 * 
 */
package com.mrojo.ta27ej4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrojo.ta27ej4.dto.Investigador;
import com.mrojo.ta27ej4.service.InvestigadorService;

/**
 * @author Marc
 *
 */
@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorService investigadorService;

	@GetMapping("/investigadores")
	public List<Investigador> listInvestigadores() {
		return investigadorService.listInvestigadores();
	}

	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorById(@PathVariable(name = "dni") String dni) {
		Investigador investigadorxID = new Investigador();

		investigadorxID = investigadorService.InvestigadorById(dni);

		return investigadorxID;
	}

	@PostMapping("/investigadores")
	public Investigador saveInvestigador(@RequestBody Investigador investigador) {
		return investigadorService.saveInvestigador(investigador);
	}

	@PutMapping("/investigadores/{dni}")
	public Investigador updateInvestigador(@PathVariable(name = "dni") String dni,
			@RequestBody Investigador investigador) {
		Investigador selectedInvestigador = new Investigador(dni, investigador.getNombre(), investigador.getFacultad());
		Investigador updatedInvestigador = new Investigador();

		updatedInvestigador = investigadorService.updateInvestigador(selectedInvestigador);
		return updatedInvestigador;
	}

	@DeleteMapping("/investigadores/{dni}")
	public void deleteInvestigador(@PathVariable(name = "dni") String dni) {
		investigadorService.deleteInvestigador(dni);
	}
}
