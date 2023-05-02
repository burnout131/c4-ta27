/**
 * 
 */
package com.mrojo.ta27ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej2.dao.ProyectoDAO;
import com.mrojo.ta27ej2.dto.Proyecto;

/**
 * @author Marc
 *
 */
@Service
public class ProyectoService {
	@Autowired
	ProyectoDAO proyectoDAO;

	public List<Proyecto> listProyectos() {
		return proyectoDAO.findAll();
	}

	public Proyecto saveProyecto(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}

	public Proyecto proyectoById(String id) {
		return proyectoDAO.findById(id).get();
	}

	public Proyecto updateProyecto(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}

	public void deleteProyecto(String id) {
		proyectoDAO.deleteById(id);
	}

}
