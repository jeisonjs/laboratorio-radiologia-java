
CREATE DATABASE proyecto_radiodiagnostico;
USE proyecto_radiodiagnostico;

CREATE TABLE `login` (
  `id` 		 INTEGER 	 NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `usuario`  VARCHAR(60) NOT NULL,
  `password` VARCHAR(40) NOT NULL
) ENGINE INNODB;

CREATE TABLE paciente (
	nHistoria  INTEGER 	 	 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cedula     INTEGER(10) 	 NOT NULL UNIQUE,
    nombre 	   VARCHAR(100)  NOT NULL,
    apellido   VARCHAR(100)  NOT NULL,
    fechaNac   DATE 		 NOT NULL,
    telefono   VARCHAR(50)   NOT NULL,
    correo 	   VARCHAR(80) 	 NOT NULL,
    genero 	   VARCHAR(100)  NOT NULL,
    embarazo   BOOLEAN 	     NOT NULL,
    alergias   BOOLEAN 	     NOT NULL,
    created_at TIMESTAMP     DEFAULT CURRENT_TIMESTAMP  NOT NULL,
    update_at  DATETIME      DEFAULT NULL,
    is_active  BOOLEAN 		 NOT NULL DEFAULT 1)
    ENGINE INNODB;


CREATE TABLE materiales(
	codigo      INTEGER   	  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre 	    VARCHAR(100)  NOT NULL,
	created_at  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_at   DATETIME      DEFAULT NULL,
    is_active   BOOLEAN  	  NOT NULL DEFAULT 1)
ENGINE INNODB;


CREATE TABLE estudio(
	codigo 		 INTEGER   	   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre 		 VARCHAR(100)  NOT NULL,
    costo 		 INTEGER       NOT NULL,
    created_at   TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_at    DATETIME      DEFAULT NULL,
    is_active    BOOLEAN  	   NOT NULL DEFAULT 1)
ENGINE INNODB;

CREATE TABLE realiza(
	codigo 		INTEGER 	  NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fecha   	DATE 		  NOT NULL,
	cedula   	INTEGER(10)   NOT NULL,
    codEstudio  INTEGER       NOT NULL,
	tipoPago 	VARCHAR(100)  NOT NULL,
    costoFinal  INTEGER       NOT NULL,
	FOREIGN KEY(`cedula`)  	  REFERENCES  `paciente`(`cedula`),
    FOREIGN KEY(`codEstudio`) REFERENCES  `estudio`(`codigo`))
ENGINE INNODB;

CREATE TABLE `utiliza` (
  `codMaterial`     INTEGER   NOT NULL,
  `codEstudio`      INTEGER   NOT NULL,
  FOREIGN KEY (`codMaterial`) REFERENCES `materiales` (`codigo`),
  FOREIGN KEY (`codEstudio`)  REFERENCES `estudio`    (`codigo`))
ENGINE INNODB;

/*CREATE TABLE detalle_realiza(
	codRealiza 		INTEGER    NOT NULL,
    codEstudio      INTEGER    NOT NULL,
	codMaterial     INTEGER	   NOT NULL,
	cantidadUsada 	INTEGER    NOT NULL,
    costo           INTEGER    NOT NULL,
	FOREIGN KEY(`codRealiza`)  REFERENCES  `realiza`(`codigo`),
    FOREIGN KEY(`codEstudio`)  REFERENCES  `estudio`(`codigo`),
	FOREIGN KEY(`codMaterial`) REFERENCES  `materiales`(`codigo`))
ENGINE INNODB;
*/