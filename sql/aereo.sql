-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-09-2018 a las 20:17:41
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aereo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `ID` int(11) NOT NULL,
  `CANT_PASAJERO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`ID`, `CANT_PASAJERO`, `DESCRIPCION`) VALUES
(1, 8, 'Embraer Phenom 100'),
(2, 12, 'Beechcraft King Air 350i'),
(3, 10, 'Learjet 70'),
(4, 16, 'Dassault Falcon 7X'),
(5, 18, 'Gulfstream G650'),
(6, 6, 'Cirrus Vision SF50'),
(20, 500, 'Tango01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `ID` int(11) NOT NULL,
  `NOMBRE_CIUDAD` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`ID`, `NOMBRE_CIUDAD`) VALUES
(1, 'BUENOS AIRES'),
(2, 'CORDOBA'),
(3, 'ROSARIO'),
(4, 'BAHIA BLANCA'),
(5, 'MAR DEL PLATA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compania`
--

CREATE TABLE `compania` (
  `ID` int(11) NOT NULL,
  `NOMBRE_COMPANIA` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `compania`
--

INSERT INTO `compania` (`ID`, `NOMBRE_COMPANIA`) VALUES
(1, 'Cielos Argentinos'),
(2, 'Delta Airlines'),
(3, 'Alas Reionegrinas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipaje_vuelo_pasajero`
--

CREATE TABLE `equipaje_vuelo_pasajero` (
  `ID` int(11) NOT NULL,
  `ID_VUELO` int(11) NOT NULL,
  `ID_PASAJERO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `PESO` decimal(18,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero`
--

CREATE TABLE `pasajero` (
  `ID` int(11) NOT NULL,
  `DNI` bigint(20) NOT NULL,
  `EDAD` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `ID` int(11) NOT NULL,
  `ID_COMPANIA` int(11) NOT NULL,
  `ID_CIUDAD_ORIGEN` int(11) NOT NULL,
  `ID_CIUDAD_DESTINO` int(11) NOT NULL,
  `ID_AVION` int(11) NOT NULL,
  `FECHA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo_pasajero`
--

CREATE TABLE `vuelo_pasajero` (
  `ID_VUELO` int(11) NOT NULL,
  `ID_PASAJERO` int(11) NOT NULL,
  `PESO_TOTAL_EQUIPAJE` decimal(18,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `compania`
--
ALTER TABLE `compania`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `equipaje_vuelo_pasajero`
--
ALTER TABLE `equipaje_vuelo_pasajero`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `vuelo_pasajero`
--
ALTER TABLE `vuelo_pasajero`
  ADD PRIMARY KEY (`ID_VUELO`,`ID_PASAJERO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
