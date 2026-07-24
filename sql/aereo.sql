-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-01-2019 a las 00:55:09
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
(14, 0, 'Mi gran avion'),
(15, 0, 'Mi otro avion'),
(20, 500, 'Tango01'),
(33, 1333, 'Optimus 300'),
(48, 500, 'super avion'),
(122, 20, 'avioneta'),
(133, 0, 'Pajaron XV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `break`
--

CREATE TABLE `break` (
  `id` int(11) NOT NULL,
  `user` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `comienzo_o_final` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `horario` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `break`
--

INSERT INTO `break` (`id`, `user`, `comienzo_o_final`, `horario`) VALUES
(6, 'Ale', 'comienzo', '2019-01-06 11:27:01'),
(7, 'Ale', 'final', '2019-01-06 11:27:31'),
(8, 'Ale', 'comienzo', '2019-01-06 11:48:38'),
(9, 'Ale', 'final', '2019-01-06 11:49:02'),
(10, 'Ale', 'comienzo', '2019-01-06 11:55:04'),
(11, 'Ale', 'final', '2019-01-06 11:55:39'),
(12, 'Ale', 'comienzo', '2019-01-06 11:59:18'),
(13, 'Ale', 'comienzo', '2019-01-06 11:59:45'),
(14, 'Ale', 'final', '2019-01-06 12:00:00'),
(15, 'Ale', 'comienzo', '2019-01-06 18:04:41'),
(16, 'Ale', 'final', '2019-01-06 18:05:04'),
(17, 'Ale', 'comienzo', '2019-01-06 20:08:06'),
(18, 'Ale', 'final', '2019-01-06 20:10:04');

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

--
-- Volcado de datos para la tabla `equipaje_vuelo_pasajero`
--

INSERT INTO `equipaje_vuelo_pasajero` (`ID`, `ID_VUELO`, `ID_PASAJERO`, `DESCRIPCION`, `PESO`) VALUES
(1, 1, 1, 'MOCHILA GRANDE ROJA', '10.00'),
(2, 1, 1, 'VALIJA MEDIANA NEGRAS', '14.50'),
(3, 1, 16, 'VALIJA GRANDE PLASTICA NEGRA', '18.30'),
(4, 1, 16, 'VALIJA MEDINA PLASTICA MARRON', '15.10'),
(5, 1, 17, 'MOCHILA MEDIANA BLANCA', '8.20'),
(6, 1, 17, 'VALIJA SAMSONITE CARRI ON', '11.00'),
(7, 1, 17, 'VALIJA GRANDE NEGRA', '15.10'),
(8, 1, 19, 'VALIJA GRANDE GREEMOND NEGRA', '21.30'),
(9, 1, 20, 'MOCHILA JACKPOT VERDE', '5.10'),
(10, 1, 20, 'VALIJA MEDIANOA SAMSONITE CARRITO BLANCA', '11.30'),
(11, 1, 20, 'VALIJA MEDIANA ELF NEGRA', '10.85'),
(12, 3, 2, 'VALIJA 2', '10.00'),
(13, 3, 3, 'VALIJA CARGADA MAL', '9999999999999999.99'),
(14, 3, 3, 'VALIJA CARGADA MAL', '9999999999999999.99'),
(15, 3, 4, 'VALIJA 1', '10.00'),
(16, 3, 4, 'VALIJA 2', '11.00'),
(17, 3, 4, 'VALIJA 3', '8.00'),
(18, 3, 4, 'VALIJA 4', '99.00'),
(19, 3, 4, 'VAJIJA 4', '55.00'),
(20, 3, 4, 'VALIJA 5', '33.00'),
(21, 3, 4, 'VALIJA 6', '12.00'),
(22, 3, 4, 'VALIJA 7', '31.50'),
(23, 3, 4, 'VALIJA 8', '88.22'),
(24, 1, 2, 'mochila vieja', '50.00'),
(25, 1, 1, 'Mochilotota', '2.00'),
(27, 2, 1, 'Mochilota', '32.00'),
(28, 3, 29, 'Gran bolso', '60.00'),
(30, 1, 31, 'mochilita', '4.00'),
(31, 4, 32, 'Mochilon chico', '3.00'),
(32, 3, 33, 'guitarra', '15.00'),
(33, 2, 34, 'Sarcofago', '600.00'),
(34, 6, 34, 'Salchichon', '64.00'),
(35, 6, 34, 'no', '0.00'),
(36, 3, 34, 'Mochilon', '70.00'),
(37, 1, 35, 'Valija con plata', '50.00'),
(38, 1, 36, 'Bolso grande', '30.00'),
(39, 7, 37, 'Bolso grande', '30.00'),
(40, 3, 38, 'Bolso grande', '50.00'),
(41, 3, 39, 'Mochila verde', '120.00'),
(43, 3, 41, 'Bolso grande', '70.00'),
(44, 8, 42, 'Bolsa con ropa', '5.10'),
(46, 5, 44, 'Balija italiana', '45.90'),
(47, 8, 45, 'Balija con oro', '8.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
  `id` int(11) NOT NULL,
  `nombre_y_apel` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `destino` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `costo` int(15) NOT NULL,
  `medio_pago` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `numero_tarjeta` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `num_seguridad` int(3) NOT NULL
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

--
-- Volcado de datos para la tabla `pasajero`
--

INSERT INTO `pasajero` (`ID`, `DNI`, `EDAD`, `NOMBRE`) VALUES
(0, 30247777, 12, 'Velasquez Andres'),
(1, 24911146, 40, 'Jorge Insfran'),
(2, 24657342, 41, 'Gerardo Gonzalez'),
(3, 27300989, 35, 'Ignacio Castillo'),
(4, 31199832, 27, 'Catalano Lucas'),
(5, 29766765, 33, 'Funes Juan'),
(6, 22888989, 45, 'Salguero Walter'),
(7, 49810143, 6, 'Dolores Gonzalez'),
(8, 24535032, 41, 'Medel Maria Florencia'),
(9, 52311132, 4, 'Mercedes Medel'),
(10, 34899012, 30, 'Moyano Luis'),
(11, 46333890, 28, 'Glock Vanesa'),
(12, 22989111, 44, 'Latorre Trinidad'),
(13, 32400560, 28, 'Guaycochea Lucas'),
(14, 33123456, 29, 'Surace Marina'),
(15, 56789123, 66, 'Sabrina Lattorre'),
(16, 28555123, 34, 'Julieta Sampaolli'),
(17, 55668876, 3, 'Emilia Sampaolli'),
(18, 52345518, 2, 'Ignacio Sampaolli'),
(19, 4197240, 70, 'Maria Gregoria Tulian'),
(20, 4345442, 72, 'Victoria Tulian'),
(21, 20987654, 45, 'Marcela Valenta'),
(24, 19320147, 50, 'Daniel Vera'),
(25, 5236987, 60, 'Vergara Miguel'),
(26, 20347844, 45, 'Santamaria Daniela'),
(27, 29334551, 38, 'Gallardo Marcelo'),
(28, 11256399, 35, 'ale'),
(29, 332047709, 30, 'Alvarez Gabriela'),
(31, 45321655, 15, 'Camaron Leandro'),
(32, 40511245, 15, 'Santamaria Daniela'),
(33, 15222333, 55, 'Atahualpa Martin'),
(34, 20136654, 55, 'Lagarto Amelia'),
(35, 20136547, 40, 'Farjat Samanta'),
(36, 30247722, 35, 'Santamaria Daniela'),
(37, 30247888, 30, 'ali el gran ali'),
(38, 20356489, 35, 'Moreno Dario'),
(39, 20568945, 47, 'Sanabria Soraya'),
(41, 45123569, 20, 'Lautaro carlos'),
(42, 1235468, 98, 'Rey David'),
(44, 20147258, 56, 'Murua Lautaro'),
(45, 10235698, 50, 'Tinelli Marcelo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `name` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`name`, `password`, `id`) VALUES
('Ale', 'qwerty', 0);

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

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`ID`, `ID_COMPANIA`, `ID_CIUDAD_ORIGEN`, `ID_CIUDAD_DESTINO`, `ID_AVION`, `FECHA`) VALUES
(1, 1, 1, 5, 6, '2016-05-02'),
(2, 1, 5, 1, 6, '2016-05-04'),
(3, 2, 1, 2, 4, '2016-05-02'),
(4, 2, 2, 1, 4, '2016-05-03'),
(5, 3, 3, 5, 1, '2016-05-03'),
(6, 3, 5, 3, 1, '2016-05-04'),
(7, 1, 1, 4, 2, '2016-05-05'),
(8, 3, 4, 5, 3, '2016-05-05');

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
-- Volcado de datos para la tabla `vuelo_pasajero`
--

INSERT INTO `vuelo_pasajero` (`ID_VUELO`, `ID_PASAJERO`, `PESO_TOTAL_EQUIPAJE`) VALUES
(1, 1, '276.75'),
(1, 16, '276.75'),
(1, 17, '276.75'),
(1, 18, '276.75'),
(1, 19, '276.75'),
(1, 20, '276.75'),
(1, 22, '276.75'),
(1, 28, '276.75'),
(1, 31, '276.75'),
(1, 35, '276.75'),
(1, 36, '276.75'),
(2, 16, '632.00'),
(2, 17, '632.00'),
(2, 18, '632.00'),
(2, 19, '632.00'),
(2, 20, '632.00'),
(2, 27, '632.00'),
(3, 2, '99999999.90'),
(3, 3, '99999999.90'),
(3, 4, '99999999.90'),
(3, 5, '99999999.90'),
(3, 6, '99999999.90'),
(3, 7, '99999999.90'),
(3, 8, '99999999.90'),
(3, 9, '99999999.90'),
(3, 10, '99999999.90'),
(3, 11, '99999999.90'),
(3, 23, '99999999.90'),
(3, 25, '99999999.90'),
(3, 29, '99999999.90'),
(3, 33, '99999999.90'),
(3, 34, '99999999.90'),
(3, 38, '99999999.90'),
(3, 39, '99999999.90'),
(3, 40, '99999999.90'),
(3, 41, '99999999.90'),
(4, 2, '3.00'),
(4, 3, '3.00'),
(4, 4, '3.00'),
(4, 7, '3.00'),
(4, 8, '3.00'),
(4, 9, '3.00'),
(4, 10, '3.00'),
(4, 26, '3.00'),
(4, 32, '3.00'),
(5, 12, '45.90'),
(5, 13, '45.90'),
(5, 14, '45.90'),
(5, 15, '45.90'),
(5, 21, '45.90'),
(5, 22, '45.90'),
(5, 44, '45.90'),
(6, 12, '64.00'),
(6, 13, '64.00'),
(6, 14, '64.00'),
(6, 15, '64.00'),
(6, 21, '64.00'),
(6, 22, '64.00'),
(6, 27, '64.00'),
(7, 11, '30.00'),
(7, 12, '30.00'),
(7, 13, '30.00'),
(7, 14, '30.00'),
(7, 15, '30.00'),
(7, 16, '30.00'),
(7, 17, '30.00'),
(7, 18, '30.00'),
(7, 19, '30.00'),
(7, 20, '30.00'),
(7, 21, '30.00'),
(7, 37, '30.00'),
(8, 1, '70.10'),
(8, 2, '70.10'),
(8, 3, '70.10'),
(8, 4, '70.10'),
(8, 5, '70.10'),
(8, 6, '70.10'),
(8, 7, '70.10'),
(8, 24, '70.10'),
(8, 42, '70.10'),
(8, 45, '70.10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `break`
--
ALTER TABLE `break`
  ADD PRIMARY KEY (`id`);

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
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

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

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `break`
--
ALTER TABLE `break`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
