DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS asignado_a;
DROP TABLE IF EXISTS cientificos;
DROP TABLE IF EXISTS proyectos;

CREATE TABLE usuarios (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE cientificos(
	dni VARCHAR(9) NOT NULL,
	nombre_apellidos VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY (dni)
);

CREATE TABLE proyectos(
	id CHAR(4) NOT NULL,
	nombre VARCHAR(255) DEFAULT NULL,
	horas INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE asignado_a(
	id INT NOT NULL AUTO_INCREMENT,
	cientifico VARCHAR(9) NOT NULL,
	proyecto CHAR(4) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_cientifico FOREIGN KEY (cientifico) REFERENCES cientificos (dni)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_proyecto FOREIGN KEY (proyecto) REFERENCES proyectos (id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO cientificos(dni, nombre_apellidos) VALUES ('01037892H', 'Marie Curie');
INSERT INTO cientificos(dni, nombre_apellidos) VALUES ('40123456L', 'Alexander Fleming');
INSERT INTO cientificos(dni, nombre_apellidos) VALUES ('12345678X', 'Bonaventura Clotet');

INSERT INTO proyectos(id, nombre, horas) VALUES ('PR1', 'Lo del polonio', 50);
INSERT INTO proyectos(id, nombre, horas) VALUES ('PR2', 'Lo de la penicilina', 200);
INSERT INTO proyectos(id, nombre, horas) VALUES ('PR3', 'Vacuna VIH', 1000);

INSERT INTO asignado_a(cientifico, proyecto) VALUES ('01037892H', 'PR1');
INSERT INTO asignado_a(cientifico, proyecto) VALUES ('40123456L', 'PR2');
INSERT INTO asignado_a(cientifico, proyecto) VALUES ('12345678X', 'PR3');