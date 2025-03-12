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
VALUES ('Santos','López','1996-01-10','info@gmail.com','santoslopez','15002241',1);

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
	SELECT * FROM Usuario ;
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
IN datosNombre varchar(50),
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

DELIMITER $$
CREATE PROCEDURE sp_agregarEdificio(
	IN datosNombreEdificio VARCHAR(20)
)
BEGIN
	DECLARE mensaje VARCHAR(20);
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION 
		ROLLBACK;
        set mensaje = 'errorproducido';
		
	START TRANSACTION;
		IF EXISTS (SELECT 1 FROM Edificio WHERE nombreEdificio=datosNombreEdificio) THEN
			set mensaje='yaexiste';
        ELSE
            INSERT Edificio (nombreEdificio) VALUES (datosNombreEdificio);
            COMMIT;
            set mensaje='registrado';
		END IF;
        select mensaje as mensaje;
END $$ 
DELIMITER ; 

-- representa el aula donde se imparten las clases
CREATE TABLE Aula(
	idAula INT AUTO_INCREMENT NOT NULL,
    salon VARCHAR(20) NOT NULL UNIQUE,
    idEdificio INT NOT NULL,
    nivel INT NOT NULL CHECK (nivel >=0), 
    PRIMARY KEY (idAula),
    FOREIGN KEY (idEdificio) REFERENCES Edificio(idEdificio)
);

-- DROP PROCEDURE  sp_agregarAulas;
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
    SELECT nombre INTO nombreCursoActual FROM Cursos WHERE idCurso=cursoID;
    
    IF codCursoActual = nuevoCodigoCurso THEN
		UPDATE Cursos set codigo=nuevoCodigoCurso,nombre=nuevoNombreCurso WHERE 
        idCurso=cursoID;
        COMMIT;
		set mensaje = 'enusocodigo';
        
	ELSEIF nombreCursoActual =  nuevoNombreCurso THEN
        UPDATE Cursos set codigo=nuevoCodigoCurso,nombre=nuevoNombreCurso WHERE 
        idCurso=cursoID;
        commit;
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
CREATE TABLE CursosCicloImpartir(
	idCursoCiclo INT AUTO_INCREMENT NOT NULL,
    idCurso INT NOT NULL,
    idCarrera INT NOT NULL,
    #yearImpartido YEAR NOT NULL,
    fechaInicioClase varchar(10) NOT NULL,
    fechaFinClase varchar(10) NOT NULL,
    horarioClaseInicio varchar(5) NOT NULL,
    horarioClaseFin varchar(5) NOT NULL,
    idCiclo INT NOT NULL,
    idAula INT NOT NULL,
	#idProfesor INT NOT NULL,
    PRIMARY KEY (idCursoCiclo),
    FOREIGN KEY (idCarrera) REFERENCES Carreras(idCarrera),
    FOREIGN KEY (idCiclo) REFERENCES Ciclos(idCiclo),
	FOREIGN KEY (idCurso) REFERENCES Cursos(idCurso),
    FOREIGN KEY (idAula) REFERENCES Aula(idAula)
	#FOREIGN KEY (idProfesor) REFERENCES Usuario(idUsuario)
);

DELIMITER $$
CREATE PROCEDURE sp_detallesCursosCicloImpartir()
BEGIN
select cursoimp.idCursoCiclo,cursos.nombre,car.nombre,cursoimp.fechaInicioClase,
cursoimp.fechaFinClase,cursoimp.horarioClaseInicio,cursoimp.horarioClaseFin,cic.descripcion,au.salon from CursosCicloImpartir AS cursoimp
inner join cursos on cursos.idCurso=cursoimp.idCurso
inner join carreras as car on car.idCarrera=cursoimp.idCarrera
inner join ciclos as cic on cic.idCiclo=cursoimp.idCiclo
inner join aula as au on au.idAula=cursoimp.idAula;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_agregarCursosCicloImpartir(
	IN cursoID INT,
    IN carreraID INT,
    IN inicioClaseFecha VARCHAR(10),
    IN finClaseFecha VARCHAR(10),
    IN claseHorarioInicio VARCHAR(5),
    IN claseHorarioFin VARCHAR(5),
    IN cicloID INT,
    IN aulaID INT
)
BEGIN
	DECLARE mensaje varchar(20);
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
		ROLLBACK;
        SET mensaje='errorproducido';
	
    START TRANSACTION;
		
		IF EXISTS (SELECT 1 FROM CursosCicloImpartir WHERE idCurso=cursoID AND idCarrera=carreraID
        AND fechaInicioClase=inicioClaseFecha AND idCiclo=cicloID AND idAula=aulaID 
        AND horarioClaseInicio=claseHorarioInicio) THEN
			set mensaje = 'yaexiste';
		ELSE
			INSERT INTO CursosCicloImpartir(idCurso,idCarrera,fechaInicioClase,fechaFinClase,horarioClaseInicio,horarioClaseFin,idCiclo,idAula)
			VALUES (cursoID,carreraID,inicioClaseFecha,finClaseFecha,claseHorarioInicio,claseHorarioFin,cicloID,aulaID);
			COMMIT;
            set mensaje = 'registrado';
		END IF;
		
		select mensaje as mensaje;
END $$
DELIMITER ;

CREATE TABLE DiasSemana(
	idDiasSemana INT AUTO_INCREMENT NOT NULL,
    dia VARCHAR(15) NOT NULL,
    PRIMARY KEY (idDiasSemana)
);

INSERT INTO DiasSemana (dia)  VALUES ('Lunes');
INSERT INTO DiasSemana (dia)  VALUES ('Martes');
INSERT INTO DiasSemana (dia)  VALUES ('Miércoles');
INSERT INTO DiasSemana (dia)  VALUES ('Jueves');
INSERT INTO DiasSemana (dia)  VALUES ('Viernes');
INSERT INTO DiasSemana (dia)  VALUES ('Sábado');

CREATE TABLE HorarioClaseProfesor(
	idHorarioClaseProfesor INT AUTO_INCREMENT NOT NULL,
    idCursoCiclo INT NOT NULL,
    idDiasSemana INT NOT NULL,
    idProfesor INT NOT NULL,
    PRIMARY KEY (idHorarioClaseProfesor),
    FOREIGN KEY (idCursoCiclo) REFERENCES CursosCicloImpartir(idCursoCiclo),
    FOREIGN KEY (idDiasSemana) REFERENCES DiasSemana(idDiasSemana),
    FOREIGN KEY (idProfesor) REFERENCES Usuario(idUsuario)
);

DELIMITER $$
CREATE PROCEDURE sp_agregarProfesorCurso(
	IN cicloCursoID INT,
    IN diaSemana INT,
    IN codigoProfesor INT
)
BEGIN

DECLARE mensaje varchar(20);

DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	ROLLBACK;
	set mensaje='errorproducido';
	
START TRANSACTION;
	INSERT INTO HorarioClaseProfesor(idCursoCiclo,idDiasSemana,idProfesor) 
	VALUES (cicloCursoID,diaSemana,codigoProfesor);
	COMMIT;
    set mensaje='registrado';
select mensaje as mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE listarProfesores()
BEGIN
SELECT idUsuario,nombres,apellidos,correo,username FROM Usuario AS u INNER JOIN TipoUsuario AS t ON u.idTipoUsuario=t.idTipoUsuario
WHERE u.estado='A';
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE listarDatosHorarioProfesor()
BEGIN

SELECT DISTINCT usu.idUsuario as idUsuario,CONCAT(usu.nombres, ' ',usu.apellidos) AS Profesor,fac.nombre as Facultad,carre.nombre as Carrera,
cursosCicloI.fechaInicioClase,cursosCicloI.fechaFinClase,cic.descripcion as Ciclo,edif.nombreEdificio
  FROM HorarioClaseProfesor AS horar
INNER JOIN Usuario AS usu ON
horar.idProfesor=usu.idUsuario 
INNER JOIN CursosCicloImpartir AS cursosCicloI ON 
horar.idCursoCiclo=cursosCicloI.idCursoCiclo
INNER JOIN Cursos AS curs ON cursosCicloI.idCurso=curs.idCurso
INNER JOIN Carreras AS carre ON cursosCicloI.idCarrera=carre.idCarrera
INNER JOIN Facultad AS fac ON carre.idFacultad=fac.idFacultad
INNER JOIN Ciclos AS cic ON cursosCicloI.idCiclo=cic.idCiclo
INNER JOIN Aula AS aul ON cursosCicloI.idAula=aul.idAula
INNER JOIN Edificio AS edif ON aul.idEdificio=edif.idEdificio
WHERE usu.idTipoUsuario=1;
END $$
DELIMITER ;

/* se recupera todos los cursos que imparte el profesor, con sus respectivos horarios, salones, dias*/
DELIMITER $$
CREATE PROCEDURE sp_DetallesHorarioProfesor(
IN codigoIDProfesor INT,
IN carreraIngresado VARCHAR(100),
IN facultadIngresado VARCHAR(100),
IN descripcionIngresado VARCHAR(30),
IN fechaInicioClaseIngresado varchar(10),
IN fechaFinClaseIngresado varchar(10)
)
BEGIN
SELECT DISTINCT aul.salon,edif.nombreEdificio,cursosCicloI.horarioClaseInicio,
cursosCicloI.horarioClaseFin,dias.dia,curs.nombre as nombre,cursosCicloI.fechaInicioClase as fechaInicioCurso,
cursosCicloI.fechaFinClase as fechaFinCurso
  FROM HorarioClaseProfesor AS horar
INNER JOIN Usuario AS usu ON
horar.idProfesor=usu.idUsuario 
INNER JOIN CursosCicloImpartir AS cursosCicloI ON 
horar.idCursoCiclo=cursosCicloI.idCursoCiclo
INNER JOIN Cursos AS curs ON cursosCicloI.idCurso=curs.idCurso
INNER JOIN Carreras AS carre ON cursosCicloI.idCarrera=carre.idCarrera
INNER JOIN Facultad AS fac ON carre.idFacultad=fac.idFacultad
INNER JOIN Ciclos AS cic ON cursosCicloI.idCiclo=cic.idCiclo
INNER JOIN Aula AS aul ON cursosCicloI.idAula=aul.idAula
INNER JOIN Edificio AS edif ON aul.idEdificio=edif.idEdificio
INNER JOIN DiasSemana AS dias ON horar.idDiasSemana=dias.idDiasSemana 
WHERE usu.idTipoUsuario=1 AND horar.idProfesor=codigoIDProfesor AND carre.nombre=carreraIngresado AND fac.nombre=facultadIngresado
AND cic.descripcion=descripcionIngresado
AND cursosCicloI.fechaInicioClase=fechaInicioClaseIngresado  
AND cursosCicloI.fechaFinClase=fechaFinClaseIngresado;
END $$
DELIMITER ;


