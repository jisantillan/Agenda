CREATE DATABASE `agenda`;
USE agenda;

CREATE TABLE `domicilio`
(
  `idDomicilio` int(11) NOT NULL AUTO_INCREMENT,
  `Localidad` varchar(45) NOT NULL,
  `Calle` varchar(50) NOT NULL,
  `Altura` varchar(5) NOT NULL,
  `Piso` varchar(50) NOT NULL,
  `Departamento` varchar(50) NOT NULL,
  `Pais` varchar(50) NOT NULL,
  `Provincia` varchar(50) NOT NULL,
  `CodPostal` varchar(10) NOT NULL,


    PRIMARY KEY (`idDomicilio`)
);



CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
   `signoZodiacal` varchar(50) NOT NULL,
  `Fecha` varchar(50) NOT NULL,
  `Contacto` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL, 
  `idDomicilio` int(11) NOT NULL ,
    FOREIGN KEY (`idDomicilio`) REFERENCES `domicilio`(`idDomicilio`) ON UPDATE CASCADE ,
  PRIMARY KEY (`idPersona`)
);




CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
      PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `provincias` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
    FOREIGN KEY (`idLocalidad`) REFERENCES `localidades`(`idLocalidad`) ON UPDATE CASCADE ,
          PRIMARY KEY (`idProvincia`)

    
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `paises` (
  `idPais` int(11) NOT NULL  AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `idProvincia` int(11) NOT NULL,
        FOREIGN KEY (`idProvincia`) REFERENCES `provincias`(`idProvincia`) ON UPDATE CASCADE ,
              PRIMARY KEY (`idPais`)


) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





INSERT INTO `localidades` (`idLocalidad`, `Nombre`) VALUES
(1, 'Del Viso');

INSERT INTO `provincias` (`idProvincia`, `Nombre`, `idLocalidad`) VALUES
(1, 'Buenos Aires', 1);

INSERT INTO `paises` (`idPais`, `Nombre`, `idProvincia`) VALUES
(1, 'Argentina', 1);

INSERT INTO `localidades` (`idLocalidad`, `Nombre`) VALUES
(2, 'Valparaiso');

INSERT INTO `provincias` (`idProvincia`, `Nombre`, `idLocalidad`) VALUES
(2, 'Santiago', 2);

INSERT INTO `paises` (`idPais`, `Nombre`, `idProvincia`) VALUES
(2, 'Chile', 2);




INSERT INTO `localidades` (`idLocalidad`, `Nombre`) VALUES
(3, 'Carlos Paz');

INSERT INTO `provincias` (`idProvincia`, `Nombre`, `idLocalidad`) VALUES
(3, 'Cordoba', 3);
INSERT INTO `paises` (`idPais`, `Nombre`, `idProvincia`) VALUES
(3, 'Argentina', 3);



INSERT INTO `localidades` (`idLocalidad`, `Nombre`) VALUES
(4, 'Pocito');

INSERT INTO `provincias` (`idProvincia`, `Nombre`, `idLocalidad`) VALUES
(4, 'San Juan', 4);


INSERT INTO `paises` (`idPais`, `Nombre`, `idProvincia`) VALUES
(4, 'Argentina', 4);

INSERT INTO `localidades` (`idLocalidad`, `Nombre`) VALUES (5, 'San Miguel');
INSERT INTO `provincias` (`idProvincia`, `Nombre`, `idLocalidad`) VALUES (5, 'Buenos Aires', 5);
INSERT INTO `paises` (`idPais`, `Nombre`, `idProvincia`) VALUES (5, 'Argentina', 5);