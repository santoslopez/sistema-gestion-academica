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

INSERT INTO Usuario(nombres,apellidos,fechaNacimiento,correo,username,carnet,idTipoUsuario) 
VALUES ('Santos2','López','1996-01-10','info@gmail.com','santoslopez','15002241',1);

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
	IF EXISTS(SELECT 1 FROM Usuario WHERE correo=datosCorreo OR username=datosUsername) THEN
        SELECT 'enuso' AS 'mensaje' ;
	ELSE
		# agregado
		INSERT INTO Usuario(nombres,apellidos,fechaNacimiento,correo,username,carnet,idTipoUsuario) VALUES (datosNombres,
		datosApellidos,datosFechaNacimiento,datosCorreo,datosUsername,datosCarnet,datosTipoUsuario);
        COMMIT;
        SELECT 'registrado' AS 'mensaje';
    END IF;
END $$
DELIMITER ;

-- muestra el listado de estudiantes
DELIMITER $$
CREATE PROCEDURE listarUsuarios(IN tipoUsuarioID INT)
BEGIN
	SELECT * FROM Usuario WHERE idTipoUsuario=tipoUsuarioID;
END $$
DELIMITER ;

CREATE TABLE Facultad(
	idFacultad INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (idFacultad)
);

-- registrar facultad
DELIMITER $$
CREATE PROCEDURE registrarFacultad(IN nombreFacultad varchar(100))
BEGIN
	IF EXISTS(SELECT 1 FROM Facultad WHERE nombre=nombreFacultad) THEN
		SELECT 'enuso' AS mensaje;
    ELSE
		INSERT INTO Facultad(nombre) VALUES(nombreFacultad);
        COMMIT;
		SELECT 'registrado' AS mensaje;
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE modificarDatosFacultad(
	IN nuevosDatosFacultad varchar (100),
    IN idFacultadModificar INT
)
BEGIN
	-- necesario para devolver un mensaje personalizado
    DECLARE mensaje VARCHAR(20);
    
    -- necesario para guardar el nombre actual
    DECLARE nombreActualFacultad VARCHAR(50);
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		-- si surge errores
        ROLLBACK;
        set mensaje = 'errorproducido';
        
	-- empezar la transacción
	START TRANSACTION;
    SELECT nombre INTO nombreActualFacultad FROM Facultad WHERE idFacultad=idFacultadModificar;
    
    IF nombreActualFacultad  = nuevosDatosFacultad  THEN
		set mensaje = 'mismosdatos';
    ELSE
		IF ROW_COUNT() = 0 THEN
			set mensaje = 'noactualizado';
        ELSE
        
			UPDATE Facultad SET nombre=nuevosDatosFacultad WHERE idFacultad=idFacultadModificar;
			COMMIT;
            
            set mensaje = 'actualizado';
        END IF;
	END IF;
    
    SELECT mensaje as mensaje;
END $$
DELIMITER ;

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

-- procedimiento almacenado para registrar usuario

CREATE TABLE Carreras(
	idCarrera INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    idFacultad INT NOT NULL,
    PRIMARY KEY (idCarrera),
    FOREIGN KEY (idFacultad) REFERENCES Facultad(idFacultad),
    UNIQUE (nombre,idFacultad)
);

-- procedimiento almacenado para guardar carreras
DELIMITER $$
CREATE PROCEDURE agregarCarreras(
IN datosNombre varchar(15),
IN datosIdFacultad int
)
BEGIN
	IF EXISTS(SELECT 1 FROM Carreras WHERE nombre=datosNombre) THEN 
		SELECT 'enuso' AS mensaje;
    ELSE
        INSERT INTO Carreras(nombre,idFacultad) VALUES(datosNombre,datosIdFacultad);
        COMMIT;
        SELECT 'registrado' AS mensaje;        
    END IF;
END $$
DELIMITER ;

-- actualizar nombre carreras
/**DELIMITER $$
CREATE PROCEDURE modificarDatosCarreras(
IN nuevosDatosNombre varchar(15),
IN idCarreraModificar INT
)
BEGIN
	UPDATE Carreras SET nombre=nuevosDatosNombre WHERE idCarrera=idCarreraModificar;
    COMMIT;
    
    SELECT 'actualizado' AS mensaje;
END $$
DELIMITER ;**/

DELIMITER $$
CREATE PROCEDURE modificarDatosCarreras(
IN nuevosDatosNombre varchar(50),
IN idCarreraModificar INT
)
BEGIN
    -- necesario para devolver un mensaje personalizado
    DECLARE mensaje varchar(20);
    
    -- necesario para comparar si el nombre es el mismo que tiene
    DECLARE datosActuales varchar(50);
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		-- Si surge un error revertir la transacción
        ROLLBACK;
        set mensaje = 'errorproducido';

	-- empezar la transacción
    START TRANSACTION;
    
    -- comparar si es distinto el nombre que quiero guardar
    SELECT nombre INTO datosActuales
    FROM Carreras WHERE idCarrera=idCarreraModificar;
    
    
    IF datosActuales = nuevosDatosNombre THEN 
		set mensaje = 'mismosdatos';
	
    ELSE
    
		UPDATE Carreras SET nombre=nuevosDatosNombre WHERE idCarrera=idCarreraModificar;
		
		-- verificar que se actualizo alguna fila
		IF ROW_COUNT() = 0 THEN
			set mensaje = 'noactualizado';
		ELSE
			COMMIT;
			set mensaje = 'actualizado';
		END IF;
    END IF;
    
    SELECT mensaje as mensaje;
END $$

DELIMITER ;

-- representa el edificio donde se imparten las clases
CREATE TABLE Edificio(
	idEdificio INT AUTO_INCREMENT,
    nombreEdificio VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (idEdificio)
);

INSERT INTO Edificio(nombreEdificio) VALUES ("TORRE GALILEO");

-- representa el aula donde se imparten las clases
CREATE TABLE Aula(
	idAula INT AUTO_INCREMENT NOT NULL,
    salon VARCHAR(20) NOT NULL UNIQUE,
    idEdificio INT NOT NULL,
    nivel INT NOT NULL CHECK (nivel >=0), 
    PRIMARY KEY (idAula),
    FOREIGN KEY (idEdificio) REFERENCES Edificio(idEdificio)
);


-- 
 DROP PROCEDURE  sp_agregarAulas;
DELIMITER $$
CREATE PROCEDURE sp_agregarAulas(
	IN datosSalon varchar(20),
    IN datosIdEdificio INT,
    IN datosNivel INT
)
BEGIN
	DECLARE mensaje varchar(20);
    
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		-- Si surge un error revertir la transacción
        ROLLBACK;
        set mensaje = 'errorproducido';

	-- empezar la transacción
    START TRANSACTION;
    
	IF EXISTS (SELECT 1 FROM Aula WHERE salon=datosSalon) THEN
		set mensaje = 'salonexiste';
    ELSE
		-- Se verifica que exista el edificio
		IF EXISTS (SELECT 1 FROM Edificio WHERE idEdificio=datosIdEdificio) THEN
			INSERT INTO Aula(salon,idEdificio,nivel) VALUES (datosSalon,datosIdEdificio,datosNivel);
			COMMIT;
			set mensaje = 'registrado';        
         ELSE
			 set mensaje = 'edificionoexiste';
        
		 END IF;
	END IF;
    
    select mensaje as mensaje;
END $$
DELIMITER ;

-- Muestra los salones y el edificio que le corresponde
DELIMITER $$
CREATE PROCEDURE listarSalonesDeEdificio()
BEGIN
SELECT a.idAula,a.salon,e.nombreEdificio,a.nivel FROM Aula AS a INNER JOIN Edificio AS e ON 
A.idEdificio=E.idEdificio;
END $$

DELIMITER ;

CREATE TABLE Ciclos(
	idCiclo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(30),
    PRIMARY KEY (idCiclo)
);

DELIMITER $$
CREATE PROCEDURE agregarCiclo(
	IN nombreCiclo varchar(30))
BEGIN
	-- verificar que el ciclo ya existe
    IF EXISTS (SELECT 1 FROM Ciclos WHERE descripcion=nombreCiclo) THEN
		SELECT 'enuso' AS mensaje; 
    ELSE
		INSERT INTO Ciclos(descripcion) VALUE (nombreCiclo);    
        COMMIT;
		SELECT 'registrado' AS mensaje;
	END IF;
END $$
DELIMITER ;

INSERT INTO Ciclos(descripcion) VALUES ("Semestre 1");

DELIMITER $$
CREATE PROCEDURE sp_modificarCiclos(
	IN cicloID INT,
    IN datosCiclo VARCHAR(30)
    
)
BEGIN 
	DECLARE mensaje VARCHAR(20);
	DECLARE cicloDatos VARCHAR(30);
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		ROLLBACK;
		set mensaje='errorproducido';
	
    START TRANSACTION;
    
		SELECT descripcion INTO cicloDatos from ciclos;
        
        IF datosCiclo = cicloDatos THEN
			set mensaje='mismosdatos';
        ELSE
			UPDATE Ciclos SET descripcion=datosCiclo WHERE idCiclo=cicloID;
            
            COMMIT;
            set mensaje = 'actualizado';
		END IF;
        
        SELECT mensaje AS mensaje;
END $$

DELIMITER ;

-- tabla que indica que cursos se van a impartir
CREATE TABLE Cursos(
	idCurso INT AUTO_INCREMENT NOT NULL,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (idCurso)
);

DELIMITER $$
CREATE PROCEDURE sp_agregarCursos(
	IN codigoCurso varchar(20),
	IN nombreCurso varchar(100)
)
BEGIN
	IF EXISTS (SELECT 1 FROM Cursos WHERE codigo=codigoCurso OR nombre=nombreCurso) THEN
		SELECT 'enuso' AS mensaje;
    ELSE
		INSERT INTO Cursos(codigo,nombre) VALUES (codigoCurso,nombreCurso);
		SELECT 'registrado' as mensaje;
    END IF;
END $$
DELIMITER ; 

INSERT INTO Cursos(codigo,nombre) VALUES ('a1','Matematica 1');

DELIMITER $$
CREATE PROCEDURE sp_modificarCursos(
	IN cursoID INT,
	IN nuevoCodigoCurso varchar(20),
    IN nuevoNombreCurso varchar(100)
)
BEGIN
	DECLARE mensaje varchar(20);
    DECLARE codCursoActual varchar(20);
    DECLARE nombreCursoActual varchar(100);
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		ROLLBACK;
        set mensaje = 'errorproducido';
	START TRANSACTION;
	
	SELECT codigo INTO codCursoActual from cursos WHERE idCurso=cursoID;
    SELECT nombre INTO nombreCursoActual FROM Cursos WHERE idCurso=cursoID ;
    
    IF codCursoActual = nuevoCodigoCurso THEN
		set mensaje = 'enusocodigo';
	ELSEIF nombreCursoActual =  nuevoNombreCurso THEN
		set mensaje = 'enusonombre';
    ELSE

        UPDATE Cursos set codigo=nuevoCodigoCurso,nombre=nuevoNombreCurso WHERE 
        idCurso=cursoID;
		
        IF ROW_COUNT() = 0 THEN
			set mensaje = 'noactualizado';
        ELSE
			COMMIT;
			set mensaje = 'actualizado';
        END IF;
	
	END IF;
    SELECT mensaje as mensaje;
END $$
DELIMITER ;

-- representa los cursos que se van a impartir, cada curso tiene asociado la carrera y la facultad a la que pertenece.
-- fecha registro regresenta la fecha en que se hizo el insert
CREATE TABLE CursosCicloProfesor(
	idCursoCiclo INT AUTO_INCREMENT NOT NULL,
    idCurso INT NOT NULL,
    idCarrera INT NOT NULL,
    añoImpartido DATE NOT NULL,
    fechaInicioClase DATE NOT NULL,
    fechaFinClase DATE NOT NULL,
    idCiclo INT NOT NULL,
    idAula INT NOT NULL,
	idProfesor INT NOT NULL,
    PRIMARY KEY (idCursoCiclo),
    FOREIGN KEY (idCarrera) REFERENCES Carreras(idCarrera),
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