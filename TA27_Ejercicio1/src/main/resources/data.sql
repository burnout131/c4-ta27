DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS piezas;

CREATE TABLE usuarios (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE piezas(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE proveedores(
	id CHAR(4) NOT NULL,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE suministra(
	id INT NOT NULL AUTO_INCREMENT,
	pieza INT NOT NULL,
	proveedor CHAR(4) NOT NULL,
	precio INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_pieza FOREIGN KEY (pieza) REFERENCES piezas (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_proveedor FOREIGN KEY (proveedor) REFERENCES proveedores (id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO piezas(nombre) VALUES ('Manguito intercooler');
INSERT INTO piezas(nombre) VALUES ('Junta culata');
INSERT INTO piezas(nombre) VALUES ('Filtro de aire');

INSERT INTO proveedores(id, nombre) VALUES ('MM01', 'Magneti Marelli');
INSERT INTO proveedores(id, nombre) VALUES ('RB02', 'Bavarian Motor Works');
INSERT INTO proveedores(id, nombre) VALUES ('MA03', 'Mann');

INSERT INTO suministra(pieza, proveedor, precio) VALUES (1, 'MM01', 100);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (2, 'RB02', 300);
INSERT INTO suministra(pieza, proveedor, precio) VALUES (3, 'MA03', 20);