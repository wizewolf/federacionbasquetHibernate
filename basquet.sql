-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2017 a las 20:39:09
-- Versión del servidor: 10.1.24-MariaDB
-- Versión de PHP: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basquet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carnet`
--

CREATE TABLE `carnet` (
  `idcarnet` int(11) NOT NULL,
  `aniodeseguro` int(11) NOT NULL,
  `idjugador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clubs`
--

CREATE TABLE `clubs` (
  `idclub` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `domicilio` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clubs`
--

INSERT INTO `clubs` (`idclub`, `nombre`, `domicilio`) VALUES
(1, 'regatas', 'boggio y las heras'),
(2, 'boca unidos', 'corrientes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `idJugador` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `fechaNac` date DEFAULT NULL,
  `entregado` tinyint(1) DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `idClub` int(11) DEFAULT NULL,
  `foto` varchar(700) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`idJugador`, `nombre`, `apellido`, `fechaNac`, `entregado`, `dni`, `idClub`, `foto`) VALUES
(1, 'matias', 'parra', NULL, 0, 12345678, 1, 'www.soyunaimagen.com'),
(2, 'saul', 'caceres', NULL, 0, 36765714, 0, 'www.yotambiensoyunaimagen.com\r\n\r\n\Z\Z $.\' \",#(7),01444\'9=82<.342??�C			\r\n\r\n2!!22222222222222222222222222222222222222222222222222??�??\"�??�����������	\r\n??�?���}�!1AQa\"q2???#B??R??$3br?	\r\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz???????????????????????????????????????????????????????????????????????????��������	\r\n??�?��w�!1AQaq\"2?B????	#3R?br?\r\n$4?%?\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz??????????????????????????????????????????????????????????????????????????���?�?֜q??S�??;?v�?P:`)@?H~?�??????҅??\ZS??Pk?g?zp?i?sN?=hh?h??S?E�??Q???b');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carnet`
--
ALTER TABLE `carnet`
  ADD PRIMARY KEY (`idcarnet`);

--
-- Indices de la tabla `clubs`
--
ALTER TABLE `clubs`
  ADD PRIMARY KEY (`idclub`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`idJugador`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `idClub` (`idClub`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carnet`
--
ALTER TABLE `carnet`
  MODIFY `idcarnet` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `clubs`
--
ALTER TABLE `clubs`
  MODIFY `idclub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
