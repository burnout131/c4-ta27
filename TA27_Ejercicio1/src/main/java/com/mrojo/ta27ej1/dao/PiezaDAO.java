/**
 * 
 */
package com.mrojo.ta27ej1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrojo.ta27ej1.dto.Pieza;

/**
 * @author Marc
 *
 */
public interface PiezaDAO extends JpaRepository<Pieza, Long> {
	
}
