USE `proyecto_radiodiagnostico`;

-- --------------------------------------------------------

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
(11, 'RXRXRXR', 11, '2017-06-12 01:36:23', '2017-06-11 21:55:18', 1),
(13, 'DF', 123, '2017-07-03 00:24:55', NULL, 1),
(14, 'DF3', 123, '2017-07-03 00:25:20', '2017-07-03 02:25:07', 1),
(15, 'JS', 23, '2017-07-03 00:39:45', NULL, 1),
(16, 'yguy', 86876, '2017-07-03 06:24:51', NULL, 1),
(17, 'hhh', 7, '2017-07-03 06:45:10', NULL, 1),
(18, 'Funcionando fino', 12000, '2017-07-03 06:46:09', NULL, 1),
(19, 'Hay que implementarlo en modificar? D:', 700, '2017-07-03 06:50:35', NULL, 1),
(20, 'yyyeeeeee', 888, '2017-07-03 06:51:02', '2017-07-03 04:16:50', 1),
(21, 'SSSS', 6576, '2017-07-03 08:16:11', NULL, 1);

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `usuario`, `password`) VALUES
(1, 'a', '1');

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`codigo`, `nombre`, `created_at`, `update_at`, `is_active`) VALUES
(1, 'Papel ecografico 110mm X 18m', '2017-06-04 16:40:02', NULL, 1),
(2, 'Revelador Mega Rev', '2017-06-04 16:43:26', NULL, 1),
(3, 'Fijador Mega Fix', '2017-06-04 16:45:23', NULL, 1),
(4, 'Agua', '2017-06-04 16:57:08', NULL, 1),
(5, 'Peliculas radigrafica', '2017-06-04 16:58:59', NULL, 1),
(6, 'Peliculas radigrafica', '2017-06-04 16:59:07', NULL, 1),
(7, 'Baucita', '2017-06-05 13:19:35', NULL, 1),
(9, 'Puerto Rico lindo', '2017-06-05 15:12:27', '2017-06-05 11:16:52', 1),
(13, 'ththhgjjjj', '2017-06-07 09:44:36', '2017-06-07 05:44:54', 1),
(14, 'kjio', '2017-06-30 08:58:46', NULL, 1),
(16, 'nrrtt', '2017-07-03 03:42:35', '2017-07-03 04:17:09', 1),
(18, 'Guayava', '2017-07-03 06:16:30', '2017-07-03 02:17:56', 1),
(19, 'rtrdd', '2017-07-03 08:17:03', NULL, 1);

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, `correo`, `genero`, `embarazo`, `alergias`, `created_at`, `update_at`, `is_active`) VALUES
(4, 123456, 'Jacinto', 'Papa', '2000-06-06', '1041-4561234', 'juanpa@gmail.com', 'Masculino', 0, 0, '2017-06-04 02:37:59', '2017-06-03 22:43:53', 1),
(6, 1234568, 'Jacinto', 'Papa', '2000-06-06', '1041-4561234', 'juanpa@gmail.com', 'Masculino', 0, 0, '2017-06-04 02:38:41', '2017-06-03 22:43:53', 1),
(7, 123, 'Juan', 'Perola', '2017-06-07', '0147-14567896767', 'jejsj@gmail', 'Femenino', 0, 0, '2017-06-04 02:57:38', '2017-06-07 05:46:09', 1),
(10, 1459789, 'Pedro', 'Pablo', '2017-06-04', '012-34756', 'jkhkj@gmail.com', 'Masculino', 0, 0, '2017-06-04 19:12:29', NULL, 1),
(12, 34243, 'FEFW', 'EFW', '2017-06-04', 'WEFWE', 'WEFW', 'WEF', 0, 0, '2017-06-04 19:46:19', NULL, 0),
(13, 33, 'Daniel', 'fef', '2017-06-07', 'efef', 'fef', 'Masculino', 0, 0, '2017-06-04 21:16:17', '2017-06-07 05:07:00', 1),
(14, 4654654, 'Carlos', 'pjpoj', '2017-06-04', '07097', 'jpjp', 'Masculino', 1, 1, '2017-06-04 22:46:13', '2017-06-04 18:51:45', 1),
(15, 17236325, 'Antonio ', 'Riera', '2017-06-04', '87987', 'hkhk', 'Masculino', 0, 1, '2017-06-04 22:52:58', '2017-06-04 18:53:43', 1),
(16, 987, 'uhu', 'iuhu', '2017-06-07', '98798', 'hukh', 'Masculino', 0, 0, '2017-06-07 09:13:34', NULL, 1),
(17, 8888, 'Alberto', 'Pedrosa', '1986-08-06', '123456', 'albertoproso@hotmail.com', 'Masculino', 0, 0, '2017-06-12 00:54:45', NULL, 1),
(18, 23, 'we', 'we', '2003-07-12', '23', '23', 'Femenino', 1, 0, '2017-06-12 01:01:10', NULL, 1),
(19, 55555, 're', 'reh', '2017-06-30', '434', 'erg', 'Masculino', 1, 1, '2017-06-30 06:10:50', NULL, 1),
(20, 704926718, 'iuhui', 'uhiu', '2017-06-30', '6786', 'uh@uhgui.com', 'Masculino', 0, 0, '2017-06-30 08:56:23', NULL, 1),
(21, 7894567, 'Abrahan', 'Pulido', '1987-07-03', '656', 'kjhkj@kh.com', 'Masculino', 0, 0, '2017-07-03 08:14:15', NULL, 1);

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `realiza`
--

INSERT INTO `realiza` (`codigo`, `fecha`, `cedula`, `codEstudio`, `tipoPago`, `costoFinal`) VALUES
(1, '2017-06-05', 17236325, 9, 'efectivo', 4567),
(2, '2017-06-05', 123, 4, 'Tarjeta de credito', 89000),
(3, '2017-06-05', 123, 2, 'Efectivo', 35000),
(4, '2017-06-05', 123, 9, 'Cheque', 4000),
(6, '2017-06-07', 17236325, 2, 'ss', 222),
(7, '2017-06-08', 4654654, 4, 'cc', 1),
(8, '2017-06-09', 4654654, 4, 'cd', 1),
(9, '2017-06-09', 4654654, 2, '544', 5445),
(10, '2017-06-07', 123, 5, 'Cheque', 78000),
(11, '2017-06-07', 123, 3, 'Tarjeta de debito', 122000),
(17, '2017-06-11', 8888, 4, 'Tarjeta de credito', 89000),
(18, '2017-06-11', 8888, 3, 'Efectivo', 122000),
(19, '2017-06-30', 123, 3, 'Tarjeta de credito', 122000),
(20, '2017-07-03', 7894567, 19, 'Efectivo', 700);

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `utiliza`
--

INSERT INTO `utiliza` (`codMaterial`, `codEstudio`) VALUES
(2, 2),
(4, 2),
(1, 2),
(1, 2),
(1, 2),
(13, 2),
(18, 17),
(9, 18),
(13, 18),
(14, 18),
(16, 18),
(18, 18),
(1, 19),
(2, 19),
(3, 19),
(4, 19),
(2, 20),
(3, 20),
(4, 20),
(5, 20),
(1, 21),
(2, 21),
(3, 21),
(4, 21),
(5, 21),
(6, 21),
(7, 21),
(9, 21),
(13, 21),
(14, 21),
(16, 21),
(18, 21);

--
-- Índices para tablas volcadas
--