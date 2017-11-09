-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-06-2017 a las 09:52:17
-- Versión del servidor: 10.1.23-MariaDB
-- Versión de PHP: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_radiodiagnostico`
--

CREATE DATABASE proyecto_radiodiagnostico;
USE proyecto_radiodiagnostico;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudio`
--

CREATE TABLE `estudio` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `costo` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `estudio`
--

INSERT INTO `estudio` (`codigo`, `nombre`, `costo`, `created_at`, `update_at`, `is_active`) VALUES
(1, 'Seleccione una opcion...', 0, '2017-06-04 17:03:04', NULL, 1),
(2, 'Ecografia abdominal', 35000, '2017-06-04 17:03:04', NULL, 1),
(3, 'Mamografia', 122000, '2017-06-04 17:03:04', NULL, 1),
(4, 'Ecografia mamaria', 89000, '2017-06-04 17:03:04', NULL, 1),
(5, 'Ecografia pelvica', 78000, '2017-06-04 17:03:04', NULL, 1),
(6, 'RX Torax', 18000, '2017-06-04 17:03:04', NULL, 1),
(7, 'RX de codo', 450000, '2017-06-05 16:57:10', '2017-06-05 12:59:05', 1),
(9, 'Densimetria osea', 4000, '2017-06-05 22:43:41', NULL, 1),
(10, 'hh', 88, '2017-06-07 09:09:28', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `usuario` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `usuario`, `password`) VALUES
(1, 'a', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `information` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`codigo`, `nombre`, `cantidad`, `information`, `created_at`, `update_at`, `is_active`) VALUES
(1, 'Papel ecografico 110mm X 18m', 10, 'Unidad de medida? Como se determinara cuanto se utiliza?', '2017-06-04 16:40:02', NULL, 1),
(2, 'Revelador Mega Rev', 100, '', '2017-06-04 16:43:26', NULL, 1),
(3, 'Fijador Mega Fix', 85, 'Determinar como se medira el gasto de un producto, no es lo mismo que que diga que se ha gastado 1 un producto que 100ml', '2017-06-04 16:45:23', NULL, 1),
(4, 'Agua', 10, 'Galones, MIlilitros, cm3?', '2017-06-04 16:57:08', NULL, 1),
(5, 'Peliculas radigrafica', 0, '', '2017-06-04 16:58:59', NULL, 1),
(6, 'Peliculas radigrafica', 10, '', '2017-06-04 16:59:07', NULL, 1),
(7, 'Baucita', 45, 'dddddd', '2017-06-05 13:19:35', NULL, 1),
(9, 'Puerto Rico lindo', 230, 'klloloo', '2017-06-05 15:12:27', '2017-06-05 11:16:52', 1),
(13, 'ththhgjjjj', 5474, 'shgh', '2017-06-07 09:44:36', '2017-06-07 05:44:54', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `nHistoria` int(11) NOT NULL,
  `cedula` int(10) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genero` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `embarazo` tinyint(1) NOT NULL,
  `alergias` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, `correo`, `genero`, `embarazo`, `alergias`, `created_at`, `update_at`, `is_active`) VALUES
(3, 23431062, 'Jeison', 'Perez', '1995-05-25', '0147-456789', 'jeisonj@hotmail.com', 'Masculino', 0, 1, '2017-06-04 02:30:56', '2017-06-03 23:06:43', 1),
(4, 123456, 'Jacinto', 'Papa', '2000-06-06', '1041-4561234', 'juanpa@gmail.com', 'Masculino', 0, 0, '2017-06-04 02:37:59', '2017-06-03 22:43:53', 1),
(6, 1234568, 'Jacinto', 'Papa', '2000-06-06', '1041-4561234', 'juanpa@gmail.com', 'Masculino', 0, 0, '2017-06-04 02:38:41', '2017-06-03 22:43:53', 1),
(7, 123, 'Juan', 'Perola', '2017-06-07', '0147-14567896767', 'jejsj@gmail', 'Femenino', 0, 0, '2017-06-04 02:57:38', '2017-06-07 05:46:09', 1),
(9, 77, 'Jeison', 'Perez', '1995-05-25', '0147-456789', 'jeisonj@hotmail.com', 'Masculino', 0, 1, '2017-06-04 05:31:59', '2017-06-04 01:34:08', 1),
(10, 1459789, 'Pedro', 'Pablo', '2017-06-04', '012-34756', 'jkhkj@gmail.com', 'Masculino', 0, 0, '2017-06-04 19:12:29', NULL, 1),
(12, 34243, 'FEFW', 'EFW', '2017-06-04', 'WEFWE', 'WEFW', 'WEF', 0, 0, '2017-06-04 19:46:19', NULL, 0),
(13, 33, 'Daniel', 'fef', '2017-06-07', 'efef', 'fef', 'Masculino', 0, 0, '2017-06-04 21:16:17', '2017-06-07 05:07:00', 1),
(14, 4654654, 'Carlos', 'pjpoj', '2017-06-04', '07097', 'jpjp', 'Masculino', 1, 1, '2017-06-04 22:46:13', '2017-06-04 18:51:45', 1),
(15, 17236325, 'Antonio ', 'Riera', '2017-06-04', '87987', 'hkhk', 'Masculino', 0, 1, '2017-06-04 22:52:58', '2017-06-04 18:53:43', 1),
(16, 987, 'uhu', 'iuhu', '2017-06-07', '98798', 'hukh', 'Masculino', 0, 0, '2017-06-07 09:13:34', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `realiza`
--

CREATE TABLE `realiza` (
  `codigo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cedula` int(10) NOT NULL,
  `codEstudio` int(11) NOT NULL,
  `tipoPago` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `costoFinal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `realiza`
--

INSERT INTO `realiza` (`codigo`, `fecha`, `cedula`, `codEstudio`, `tipoPago`, `costoFinal`) VALUES
(1, '2017-06-05', 17236325, 9, 'efectivo', 4567),
(2, '2017-06-05', 123, 4, 'Tarjeta de credito', 89000),
(3, '2017-06-05', 123, 2, 'Efectivo', 35000),
(4, '2017-06-05', 123, 9, 'Cheque', 4000),
(5, '2017-06-05', 23431062, 7, 'Tarjeta de credito', 450000),
(6, '2017-06-07', 17236325, 2, 'ss', 222),
(7, '2017-06-08', 4654654, 4, 'cc', 1),
(8, '2017-06-09', 4654654, 4, 'cd', 1),
(9, '2017-06-09', 4654654, 2, '544', 5445),
(10, '2017-06-07', 123, 5, 'Cheque', 78000),
(11, '2017-06-07', 123, 3, 'Tarjeta de debito', 122000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `utiliza`
--

CREATE TABLE `utiliza` (
  `codMaterial` int(11) NOT NULL,
  `cantMaterialU` int(11) NOT NULL,
  `codEstudio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudio`
--
ALTER TABLE `estudio`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`nHistoria`),
  ADD UNIQUE KEY `cedula` (`cedula`);

--
-- Indices de la tabla `realiza`
--
ALTER TABLE `realiza`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cedulaPac` (`cedula`),
  ADD KEY `codEstudio` (`codEstudio`);

--
-- Indices de la tabla `utiliza`
--
ALTER TABLE `utiliza`
  ADD PRIMARY KEY (`codMaterial`),
  ADD KEY `codEstudio` (`codEstudio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudio`
--
ALTER TABLE `estudio`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `nHistoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `realiza`
--
ALTER TABLE `realiza`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `realiza`
--
ALTER TABLE `realiza`
  ADD CONSTRAINT `realiza_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `paciente` (`cedula`),
  ADD CONSTRAINT `realiza_ibfk_2` FOREIGN KEY (`codEstudio`) REFERENCES `estudio` (`codigo`);

--
-- Filtros para la tabla `utiliza`
--
ALTER TABLE `utiliza`
  ADD CONSTRAINT `utiliza_ibfk_1` FOREIGN KEY (`codMaterial`) REFERENCES `materiales` (`codigo`),
  ADD CONSTRAINT `utiliza_ibfk_2` FOREIGN KEY (`codEstudio`) REFERENCES `estudio` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
