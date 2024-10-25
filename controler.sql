-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2024 a las 14:42:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `controler`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `borrado` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `codigo`, `nombre`, `borrado`) VALUES
(1, '213', 'Pablo Aimar', 1),
(2, '1000', 'Walter Samuel', 1),
(3, '111', 'Sosa', 1),
(4, '12344', 'Lucas de Huaranca', 1),
(5, '4322', 'JuanFra', 1),
(6, '905', 'Palavecino', 0),
(7, '100', 'Pepe', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meses`
--

CREATE TABLE `meses` (
  `id_mes` int(11) NOT NULL,
  `nombre_mes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `meses`
--

INSERT INTO `meses` (`id_mes`, `nombre_mes`) VALUES
(1, 'Enero'),
(2, 'Febrero'),
(3, 'Marzo'),
(4, 'Abril'),
(5, 'Mayo'),
(6, 'Junio'),
(7, 'Julio'),
(8, 'Agosto'),
(9, 'Septiembre'),
(10, 'Octubre'),
(11, 'Noviembre'),
(12, 'Diciembre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `semana` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `zona` varchar(300) NOT NULL,
  `total_inicial` float NOT NULL,
  `puntos_venta_inicial` int(11) NOT NULL,
  `clientes_fiado` int(11) NOT NULL,
  `fiado_saldo` float NOT NULL,
  `fiado_estado` int(11) NOT NULL,
  `fiado_total` float NOT NULL,
  `rendicion_efectivo` float NOT NULL,
  `rendicion_transferencia` float NOT NULL,
  `cobranza` double NOT NULL,
  `gastos` float NOT NULL,
  `rendicion_total` float NOT NULL,
  `devolucion_cliente` int(11) NOT NULL,
  `devolucion_saldo` float NOT NULL,
  `devolucion_total` float NOT NULL,
  `pd_cantidad` int(11) NOT NULL,
  `pd_nombre` varchar(200) NOT NULL,
  `pd_precio_uni` float NOT NULL,
  `pd_saldo` float NOT NULL,
  `pd_total` float NOT NULL,
  `total_real` float NOT NULL,
  `tr_total` float NOT NULL,
  `puntos_venta_final` int(11) NOT NULL,
  `devolucion` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semanas`
--

CREATE TABLE `semanas` (
  `id_semana` int(11) NOT NULL,
  `numero_semana` varchar(20) NOT NULL,
  `id_mes` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `semanas`
--

INSERT INTO `semanas` (`id_semana`, `numero_semana`, `id_mes`) VALUES
(1, 'Semana 1', NULL),
(2, 'Semana 2 ', NULL),
(3, 'Semana 3 ', NULL),
(4, 'Semana 4 ', NULL),
(5, 'Semana 5 ', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `meses`
--
ALTER TABLE `meses`
  ADD PRIMARY KEY (`id_mes`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `semanas`
--
ALTER TABLE `semanas`
  ADD PRIMARY KEY (`id_semana`),
  ADD KEY `id_mes` (`id_mes`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `meses`
--
ALTER TABLE `meses`
  MODIFY `id_mes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `semanas`
--
ALTER TABLE `semanas`
  MODIFY `id_semana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `semanas`
--
ALTER TABLE `semanas`
  ADD CONSTRAINT `semanas_ibfk_1` FOREIGN KEY (`id_mes`) REFERENCES `meses` (`id_mes`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
