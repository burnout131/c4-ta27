/**
 * 
 */
package com.mrojo.ta27ej4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej4.dao.ReservaDAO;
import com.mrojo.ta27ej4.dto.Reserva;

/**
 * @author Marc
 *
 */
@Service
public class ReservaService {

	@Autowired
	ReservaDAO reservaDAO;

	public List<Reserva> listReservas() {
		return reservaDAO.findAll();
	}

	public Reserva saveReserva(Reserva reserva) {
		return reservaDAO.save(reserva);
	}

	public Reserva reservaById(Long id) {
		return reservaDAO.findById(id).get();
	}

	public Reserva updateReserva(Reserva reserva) {
		return reservaDAO.save(reserva);
	}

	public void deleteReserva(Long id) {
		reservaDAO.deleteById(id);
	}
}
