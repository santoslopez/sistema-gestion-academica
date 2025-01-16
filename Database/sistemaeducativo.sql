CREATE DATABASE sistemaeducativo;

use sistemaeducativo;

CREATE TABLE TipoUsuario(
	idTipoUsuario INT AUTO_INCREMENT,
    nombreTipo varchar(20) NOT NULL,
    primary key (idTipoUsuario)
);


CREATE TABLE Usuario(
	idUsuario INT AUTO_INCREMENT,
    nombres varchar(100) NOT NULL,
    apellidos varchar(100) NOT NULL,
    fechaNacimiento date NOT NULL,
    correo varchar(128) NOT NULL,
    username varchar(128) NOT NULL,
    contrasena varchar(128) NOT NULL,
    fechaRegistro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    carnet varchar(10) NOT NULL,
    foto varchar(256) NOT NULL DEFAULT 'nodisponible.png',
    estado char(1) CHECK (estado IN ('A','I')) DEFAULT 'A',
    idTipoUsuario int NOT NULL,
    primary key(idUsuario),
    foreign key (idTipoUsuario) references TipoUsuario(idTipoUsuario)
);

INSERT INTO TipoUsuario(nombreTipo) VALUES ('admin');

INSERT INTO Usuario(nombres,apellidos,fechaNacimiento,correo,username,contrasena,carnet,estado,idTipoUsuario)
VALUES ('Santos','López','1993-10-11','santos.lopez@galileo.edu','santoslopez','hola','15002241','A',1);


