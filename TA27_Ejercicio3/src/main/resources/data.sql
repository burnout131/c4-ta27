DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS maquinas_registradoras;

CREATE TABLE usuarios (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE cajeros(
	id INT NOT NULL AUTO_INCREMENT,
	nombre_apellidos VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE productos(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	precio INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE maquinas_registradoras(
	id INT NOT NULL AUTO_INCREMENT,
	piso INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE ventas(
	id INT NOT NULL AUTO_INCREMENT,
	cajero INT NOT NULL,
	producto INT NOT NULL,
	maquina_registradora INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FK_cajero FOREIGN KEY (cajero) REFERENCES cajeros (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_producto FOREIGN KEY (producto) REFERENCES productos (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_maquina_registradora FOREIGN KEY (maquina_registradora)
	REFERENCES maquinas_registradoras (id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO cajeros(nombre_apellidos) VALUES ('Antonio Recio');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Enrique Pastor');
INSERT INTO cajeros(nombre_apellidos) VALUES ('Fermin Trujillo');

INSERT INTO productos(nombre, precio) VALUES ('Cafe Marcilla', 4);
INSERT INTO productos(nombre, precio) VALUES ('Pera conferencia', 2);
INSERT INTO productos(nombre, precio) VALUES ('Sarten Tefal', 15);

INSERT INTO maquinas_registradoras(piso) VALUES (1);
INSERT INTO maquinas_registradoras(piso) VALUES (2);
INSERT INTO maquinas_registradoras(piso) VALUES (3);

INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (1, 1, 1);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (2, 2, 2);
INSERT INTO ventas(cajero, producto, maquina_registradora) VALUES (3, 3, 3);