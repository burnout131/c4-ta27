package com.mrojo.ta27ej1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrojo.ta27ej1.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}