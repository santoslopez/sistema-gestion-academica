CREATE DATABASE sistemaeducativo;

use sistemaeducativo;

CREATE TABLE TipoUsuario(
	idTipoUsuario INT AUTO_INCREMENT,
    nombreTipo varchar(20) NOT NULL UNIQUE,
    primary key (idTipoUsuario)
);

INSERT INTO TipoUsuario(nombreTipo) VALUES ('admin');
INSERT INTO TipoUsuario(nombreTipo) VALUES ('student');

CREATE TABLE Usuario(
	idUsuario INT AUTO_INCREMENT,
    nombres varchar(100) NOT NULL,
    apellidos varchar(100) NOT NULL,
    fechaNacimiento date NOT NULL,
    correo varchar(128) NOT NULL UNIQUE,
    username varchar(128) NOT NULL UNIQUE,
    contrasena varchar(128) NOT NULL,
    fechaRegistro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    carnet varchar(10) NOT NULL,
    foto varchar(256) NOT NULL DEFAULT 'nodisponible.png',
    estado char(1) CHECK (estado IN ('A','I','S')) DEFAULT 'A',
    idTipoUsuario int NOT NULL,
    primary key(idUsuario),
    foreign key (idTipoUsuario) references TipoUsuario(idTipoUsuario)
);


INSERT INTO Usuario(nombres,apellidos,fechaNacimiento,correo,username,carnet,idTipoUsuario)
VALUES ('Eva','Maria','1996-01-10','prueba2@gmail.com','eva','15002241',1);

-- Triger para agregar una contraseña por default en la base de datos
DELIMITER //
CREATE TRIGGER createPasswordUser
BEFORE INSERT ON Usuario
FOR EACH ROW
BEGIN
	IF NEW.contrasena IS NULL THEN
		SET NEW.contrasena = NEW.username;
    END IF;
END //
DELIMITER ;

-- DROP TRIGGER createPasswordUser;
CREATE TABLE Facultad(
	idFacultad INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (idFacultad)
);

-- Procedimiento almacenado para que muestre las carreras disponibles y que indique que facultad pertenece
DELIMITER $$
CREATE PROCEDURE listarCarrerasPorFacultad()
BEGIN
	SELECT c.idCarrera,c.nombre,f.nombre FROM Carreras AS c INNER JOIN Facultad AS f ON c.idFacultad=f.idFacultad;
END $$
DELIMITER ;

-- muestra el listado de facultades disponibles
DELIMITER $$ 
CREATE PROCEDURE listarFacultades()
BEGIN
	SELECT * FROM Facultad;
END $$
DELIMITER ;

-- muestra el listado de estudiantes
DELIMITER $$
CREATE PROCEDURE listarUsuarios(IN tipoUsuarioID INT)
BEGIN
	SELECT * FROM Usuario WHERE idTipoUsuario=tipoUsuarioID;
END $$
DELIMITER ;

-- procedimiento almacenado para registrar usuario
DELIMITER $$
CREATE PROCEDURE crearUsuario(
IN datosNombres VARCHAR(100),
IN datosApellidos VARCHAR(100),
IN datosFechaNacimiento DATE,
IN datosCorreo VARCHAR(128), 
IN datosUsername varchar(128),
IN datosCarnet varchar(10),
IN datosTipoUsuario INT)
BEGIN
	INSERT INTO Usuario(nombres,apellidos,fechaNacimiento,correo,username,carnet,idTipoUsuario) VALUES (datosNombres,
    datosApellidos,datosFechaNacimiento,datosCorreo,datosUsername,datosCarnet,datosTipoUsuario);
END $$
DELIMITER ;

CREATE TABLE Carreras(
	idCarrera INT AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    idFacultad INT NOT NULL,
    PRIMARY KEY (idCarrera),
    FOREIGN KEY (idFacultad) REFERENCES Facultad(idFacultad),
    UNIQUE (nombre,idFacultad)
);
