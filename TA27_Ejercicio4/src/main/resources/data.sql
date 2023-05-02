DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS reservas;
DROP TABLE IF EXISTS equipos;
DROP TABLE IF EXISTS investigadores;
DROP TABLE IF EXISTS facultades;

CREATE TABLE usuarios (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE facultades(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE equipos(
	id CHAR(4) NOT NULL,
	nombre VARCHAR(100) DEFAULT NULL,
	facultad INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_facultad_equipo FOREIGN KEY (facultad) REFERENCES facultades(id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE investigadores(
	dni VARCHAR(9) NOT NULL,
	nombre VARCHAR(100) DEFAULT NULL,
	facultad INT NOT NULL,
	PRIMARY KEY(dni),
	CONSTRAINT FK_facultad_investigador FOREIGN KEY (facultad) REFERENCES facultades(id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE reservas(
	id INT NOT NULL AUTO_INCREMENT,
	equipo CHAR(4) NOT NULL,
	investigador VARCHAR(9) NOT NULL,
	comienzo DATETIME NOT NULL,
	fin DATETIME NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_equipo FOREIGN KEY (equipo) REFERENCES equipos(id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_investigador FOREIGN KEY (investigador) REFERENCES investigadores(dni)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO facultades(nombre) VALUES ('Facultad de Medicina');
INSERT INTO facultades(nombre) VALUES ('Facultad de Ciencia');
INSERT INTO facultades(nombre) VALUES ('Facultad de Fisica');

INSERT INTO equipos(id, nombre, facultad) VALUES ('TEM1', 'Equipo 1', 1);
INSERT INTO equipos(id, nombre, facultad) VALUES ('TEM2', 'Equipo 2', 2);
INSERT INTO equipos(id, nombre, facultad) VALUES ('TEM3', 'Equipo 3', 3);

INSERT INTO investigadores(dni, nombre, facultad) VALUES ('12345678A', 'Alexander Fleming', 1);
INSERT INTO investigadores(dni, nombre, facultad) VALUES ('12345678B', 'Marie Curie', 2);
INSERT INTO investigadores(dni, nombre, facultad) VALUES ('12345678C', 'Isaac Newton', 3);

INSERT INTO reservas(equipo, investigador, comienzo, fin) VALUES ('TEM1', '12345678A', '1900-01-01 00:00:00', '1900-03-01 00:00:00');
INSERT INTO reservas(equipo, investigador, comienzo, fin) VALUES ('TEM2', '12345678B', '1910-02-01 00:00:00', '1915-04-30 00:00:00');
INSERT INTO reservas(equipo, investigador, comienzo, fin) VALUES ('TEM3', '12345678C', '1870-10-01 00:00:00', '1890-12-31 00:00:00');