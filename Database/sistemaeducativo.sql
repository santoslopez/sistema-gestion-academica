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

DROP PROCEDURE listarUsuarios;
CALL listarUsuarios(2);

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

select * from usuario;

-- representa el edificio donde se imparten las clases
CREATE TABLE Edificio(
	idEdificio INT AUTO_INCREMENT,
    edificio VARCHAR(20) NOT NULL
);

-- representa el aula donde se imparten las clases
CREATE TABLE Aula(
	idAula INT AUTO_INCREMENT NOT NULL,
    salon VARCHAR(20) NOT NULL UNIQUE,
    idEdificio INT NOT NULL,
    nivel VARCHAR(30) NOT NULL, 
    PRIMARY KEY (idAula),
    FOREIGN KEY (idEdificio) REFERENCES Edificio(idEdificio)
);

CREATE TABLE Ciclos(
	idCiclo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(30),
    PRIMARY KEY (idCiclo)
);
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 1");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 2");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 3");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 4");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 5");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 6");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 7");
INSERT INTO Ciclos(descripcion) VALUES ("Semestre 8");
INSERT INTO Ciclos(descripcion) VALUES ("Trimestre 1");
INSERT INTO Ciclos(descripcion) VALUES ("Trimestre 2");
INSERT INTO Ciclos(descripcion) VALUES ("Trimestre 3");
INSERT INTO Ciclos(descripcion) VALUES ("Trimestre 4");
INSERT INTO Ciclos(descripcion) VALUES ("INTERCICLO");


-- tabla que indica que cursos se van a impartir
CREATE TABLE Cursos(
	idCurso INT AUTO_INCREMENT NOT NULL,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (idCurso)
);

-- representa los cursos que se van a impartir, cada curso tiene asociado la carrera y la facultad a la que pertenece.
-- fecha registro regresenta la fecha en que se hizo el insert
CREATE TABLE CursosCicloProfesor(
	idCursoCiclo INT AUTO_INCREMENT NOT NULL,
    idCurso INT NOT NULL,
    idCarreras INT NOT NULL,
    añoImpartido DATE NOT NULL,
    fechaInicioClase DATE NOT NULL,
    fechaFinClase DATE NOT NULL,
    idCiclo INT NOT NULL,
    idAula INT NOT NULL,
	idProfesor INT NOT NULL,
    PRIMARY KEY (idCursoCiclo),
    FOREIGN KEY (idCarreras) REFERENCES Carreras(idCarreras),
    FOREIGN KEY (idCiclo) REFERENCES Ciclos(idCiclo),
	FOREIGN KEY (idCurso) REFERENCES Cursos(idCurso),
    FOREIGN KEY (idAula) REFERENCES Aula(idAula),
	FOREIGN KEY (idProfesor) REFERENCES Usuario(idProfesor)
);


CREATE TABLE DiasSemana(
	idDiasSemana INT AUTO_INCREMENT NOT NULL,
    dia VARCHAR(15) NOT NULL,
    PRIMARY KEY (idDiasSemana)
);

CREATE TABLE HorarioClaseProfesor(
	idHorarioClaseProfesor INT AUTO_INCREMENT NOT NULL,
    idCursoCiclo INT NOT NULL,
    idDiasSemana INT NOT NULL,
	horacioClaseInicio TIME NOT NULL,
    horarioClaseFin TIME NOT NULL,
    PRIMARY KEY (idHorarioClaseProfesor),
    FOREIGN KEY (idCursoCiclo) REFERENCES CursosCicloProfesor(idCursoCiclo),
    FOREIGN KEY (idDiasSemana) REFERENCES DiasSemana(idDiasSemana)
);
