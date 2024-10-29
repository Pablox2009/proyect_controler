-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2024 a las 19:36:34
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
-- Estructura de tabla para la tabla `mes`
--

CREATE TABLE `mes` (
  `mes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mes`
--

INSERT INTO `mes` (`mes`) VALUES
('Abril'),
('Agosto'),
('Diciembre '),
('Enero'),
('Febrero'),
('Julio'),
('Junio'),
('Marzo'),
('Mayo'),
('Noviembre'),
('Octubre'),
('Septiembre ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meses`
--

CREATE TABLE `meses` (
  `id_mes` int(11) NOT NULL,
  `nombre_mes` varchar(20) DEFAULT NULL,
  `Objetivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `meses`
--

INSERT INTO `meses` (`id_mes`, `nombre_mes`, `Objetivo`) VALUES
(29, 'Abril', 1),
(30, 'Abril', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `semana` varchar(20) DEFAULT NULL,
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

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`id`, `semana`, `fecha`, `zona`, `total_inicial`, `puntos_venta_inicial`, `clientes_fiado`, `fiado_saldo`, `fiado_estado`, `fiado_total`, `rendicion_efectivo`, `rendicion_transferencia`, `cobranza`, `gastos`, `rendicion_total`, `devolucion_cliente`, `devolucion_saldo`, `devolucion_total`, `pd_cantidad`, `pd_nombre`, `pd_precio_uni`, `pd_saldo`, `pd_total`, `total_real`, `tr_total`, `puntos_venta_final`, `devolucion`) VALUES
(3, 'semana 1', '2024-10-01', 'san pedro ', 1000, 12, 12, 1000, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 'luis', 12, 12, 12, 12, 12, 12, 12),
(4, 'semana 2', '2024-10-09', 'as', 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 21, 'as', 12, 12, 2, 12, 12, 12, 12),
(5, 'semana 4 ', '2024-10-23', 'as', 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 'a', 12, 12, 12, 12, 12, 12, 12),
(6, 'semana 1', '2024-10-10', 'ds', 12, 32, 34, 45, 45, 45, 54, 56, 65, 56, 53, 45, 345, 345, 435, 'sd', 345, 5435, 3453450, 535, 355, 35, 345);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semana`
--

CREATE TABLE `semana` (
  `semana` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `semana`
--

INSERT INTO `semana` (`semana`) VALUES
('semana 1'),
('semana 2'),
('semana 3 '),
('semana 4 '),
('semana 5 ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semanas`
--

CREATE TABLE `semanas` (
  `id_semana` int(11) NOT NULL,
  `numero_semana` varchar(20) DEFAULT NULL,
  `mes` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `semanas`
--

INSERT INTO `semanas` (`id_semana`, `numero_semana`, `mes`) VALUES
(26, 'semana 1', 'Abril'),
(27, 'semana 1', 'Abril'),
(28, 'semana 2', 'Febrero'),
(29, 'semana 4 ', 'Julio');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mes`
--
ALTER TABLE `mes`
  ADD PRIMARY KEY (`mes`);

--
-- Indices de la tabla `meses`
--
ALTER TABLE `meses`
  ADD PRIMARY KEY (`id_mes`),
  ADD KEY `nombre_mes` (`nombre_mes`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `semana` (`semana`);

--
-- Indices de la tabla `semana`
--
ALTER TABLE `semana`
  ADD PRIMARY KEY (`semana`);

--
-- Indices de la tabla `semanas`
--
ALTER TABLE `semanas`
  ADD PRIMARY KEY (`id_semana`),
  ADD KEY `fk_numero_semana` (`numero_semana`),
  ADD KEY `id_mes` (`mes`);

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
  MODIFY `id_mes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `semanas`
--
ALTER TABLE `semanas`
  MODIFY `id_semana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `meses`
--
ALTER TABLE `meses`
  ADD CONSTRAINT `meses_ibfk_1` FOREIGN KEY (`nombre_mes`) REFERENCES `mes` (`mes`);

--
-- Filtros para la tabla `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`semana`) REFERENCES `semana` (`semana`);

--
-- Filtros para la tabla `semanas`
--
ALTER TABLE `semanas`
  ADD CONSTRAINT `fk_numero_semana` FOREIGN KEY (`numero_semana`) REFERENCES `semana` (`semana`),
  ADD CONSTRAINT `semanas_ibfk_1` FOREIGN KEY (`mes`) REFERENCES `mes` (`mes`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
