-- phpMyAdmin SQL Dump
-- version 5.1.4
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql-csjurado.alwaysdata.net
-- Tiempo de generación: 06-09-2022 a las 11:29:54
-- Versión del servidor: 10.6.7-MariaDB
-- Versión de PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `csjurado_bdd`
--
CREATE DATABASE IF NOT EXISTS `csjurado_bdd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `csjurado_bdd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `celular` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id`, `nombre`, `email`, `celular`, `direccion`, `password`) VALUES
(1, 'Tanner Bentley', 'maecenas.mi.felis@icloud.net', '(270) 723-3836', '513-5898 Quis St.', '86882'),
(2, 'Rhona Bailey', 'vestibulum@icloud.org', '(512) 232-4836', 'P.O. Box 600, 5033 Mattis Rd.', '28525'),
(3, 'Hedwig Poole', 'adipiscing.elit.aliquam@yahoo.net', '(213) 235-2917', '817-2144 Quam. Av.', '31456'),
(4, 'Georgia O\'connor', 'mauris@icloud.couk', '(272) 176-2582', 'Ap #819-1707 Non, Av.', '52462'),
(5, 'Rafael Oneal', 'augue.ac.ipsum@hotmail.net', '(771) 671-5584', 'Ap #413-3889 Cursus Av.', '46995'),
(6, 'Fuller Moon', 'orci.phasellus@hotmail.com', '(683) 971-7437', 'P.O. Box 496, 7307 Nisi Avenue', '34412'),
(7, 'Lucian Ramos', 'magnis.dis.parturient@protonmail.org', '1-981-748-5516', '779-3162 Lectus. Rd.', '40270'),
(8, 'Charlotte Lott', 'non.sollicitudin@yahoo.couk', '1-710-811-7925', 'Ap #220-8643 Adipiscing, Road', '78361'),
(9, 'Anika Mack', 'aliquam.erat@outlook.edu', '(492) 283-8716', '692-2722 Augue St.', '56531'),
(10, 'Caryn Watts', 'duis.volutpat@google.org', '1-912-810-8712', 'Ap #614-9939 Tristique Av.', '11286'),
(11, 'Carlos', 'administrador@gmail.com', '098xxxxxx', 'Quito Ecuador', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodegueros`
--

CREATE TABLE `bodegueros` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `celular` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bodegueros`
--

INSERT INTO `bodegueros` (`id`, `nombre`, `email`, `celular`, `direccion`, `password`) VALUES
(1, 'Zephania Robles', 'tempor.est.ac@yahoo.ca', '(435) 281-5104', 'Ap #448-2675 Vel, St.', '87121'),
(2, 'Ryder Wynn', 'nibh@hotmail.edu', '(385) 635-3283', '338-8115 Conubia Street', '47805'),
(3, 'Quinn Patton', 'lobortis.tellus.justo@aol.edu', '1-945-864-3533', '537-6747 Arcu. Street', '57221'),
(4, 'Keaton Mcdonald', 'parturient.montes@hotmail.ca', '(256) 179-5857', '2295 Nibh. Street', '73389'),
(5, 'Gail Hester', 'faucibus@protonmail.couk', '(671) 688-6448', 'Ap #804-5607 Ultricies Avenue', '33147'),
(6, 'Shana Hood', 'ullamcorper.nisl@yahoo.couk', '(881) 453-7432', 'Ap #343-360 Pede. Rd.', '87327'),
(7, 'Buffy Valencia', 'blandit@yahoo.couk', '(304) 717-3121', 'P.O. Box 526, 2627 Tempus Street', '95245'),
(8, 'Travis Rodriguez', 'mauris@hotmail.ca', '(338) 588-0566', '309-7646 Ultricies Street', '69461'),
(9, 'Chastity Hudson', 'ut.semper.pretium@yahoo.net', '(584) 526-1084', '6137 Diam Street', '12041'),
(10, 'Ryder Tanner', 'in.faucibus@aol.net', '1-772-941-6584', 'P.O. Box 622, 177 Vitae Av.', '52356'),
(11, 'Carlos Jurado', 'bodeguero@gmail.com', '098399xxx', 'Puente 3 Armenia', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajeros`
--

CREATE TABLE `cajeros` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `celular` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cajeros`
--

INSERT INTO `cajeros` (`id`, `nombre`, `email`, `celular`, `direccion`, `password`) VALUES
(1, 'Isabella Stokes', 'non.egestas.a@icloud.ca', '1-736-319-0771', 'P.O. Box 412, 7046 Ornare Rd.', '05736'),
(2, 'Lysandra Logan', 'elit.pharetra@hotmail.org', '1-624-493-2147', '591-8760 Urna Street', '27224'),
(3, 'Zena Glass', 'ultrices.sit.amet@protonmail.ca', '(650) 847-7748', '5757 Enim. Av.', '75175'),
(4, 'Orla Alvarez', 'sodales.mauris@protonmail.net', '(852) 644-4826', '727-1775 Venenatis Street', '75444'),
(5, 'Porter Yang', 'aenean.euismod.mauris@outlook.net', '1-818-471-4516', '9141 Urna Ave', '96723'),
(6, 'Kristen Gilmore', 'eleifend.vitae@google.org', '1-811-447-4703', '3757 Iaculis Avenue', '85177'),
(7, 'Hillary Adkins', 'diam.vel@aol.couk', '1-413-610-8645', 'P.O. Box 941, 1967 Consectetuer Street', '32373'),
(8, 'Amir Garner', 'iaculis.enim@protonmail.couk', '1-291-221-2236', '573 Magnis Avenue', '19771'),
(9, 'Ignacia Lester', 'turpis@protonmail.org', '1-528-271-8094', 'Ap #709-735 Ac Rd.', '11155'),
(10, 'Tyler Bartlett', 'nullam.lobortis@protonmail.edu', '1-351-185-1218', 'Ap #166-3025 Id Av.', '65121'),
(11, 'Carlos ', 'cajero@gmail.com', '098xxxxxxx', 'Quito Ecuador ', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `celular` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `email`, `celular`, `direccion`, `password`) VALUES
(1, 'Ezekiel Adkins', 'adipiscing.fringilla.porttitor@outlook.org', '(915) 246-5350', 'Ap #246-655 Non, Street', '83553'),
(2, 'Penelope Romero', 'ridiculus.mus@icloud.com', '(235) 442-8206', '820-7075 Libero Ave', '67594'),
(3, 'Oprah Holman', 'nec.tempus@yahoo.couk', '1-439-579-3797', 'Ap #204-1025 Enim. Ave', '31532'),
(4, 'Haviva Shepard', 'lorem.ipsum.dolor@icloud.edu', '(310) 525-2876', '175-2161 Rutrum Road', '66638'),
(5, 'Robert Combs', 'nec@aol.com', '1-944-600-7753', 'Ap #475-2354 Neque Avenue', '17127'),
(6, 'Stone Munoz', 'nam.interdum@aol.com', '1-383-445-1363', '116-3185 Fusce Street', '06492'),
(7, 'Illana Cooley', 'elit.pellentesque.a@protonmail.net', '1-321-942-8885', 'Ap #326-3231 Sociis Ave', '37451'),
(8, 'Ulric Huber', 'tempus.eu@hotmail.ca', '(331) 243-5375', 'Ap #971-2232 Tellus St.', '80247'),
(9, 'Walker Sharpe', 'penatibus.et@google.com', '1-272-274-7419', 'Ap #194-8288 Integer Road', '09697'),
(10, 'Guy Snider', 'eu.tellus@google.edu', '1-474-547-2078', '818-4134 Sed Ave', '77331');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `nombreProducto` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `cantidad` mediumint(9) DEFAULT NULL,
  `precio` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombreProducto`, `codigo`, `cantidad`, `precio`) VALUES
(1, 'Carisoprodol 80Mg', 'BSZ32MVW6CP', 35, '29.00'),
(2, 'Folic Acid 150 ml', 'ARV54MQW6WLXS', 18, '18.52'),
(3, 'Allopurinol', 'ZST75RWN0BQ', 70, '9.94'),
(4, 'Amlodipine Besylate', 'ASX35TQZ8FL', 13, '20.43'),
(5, 'LevothyroxineSodium', 'TTX41PLL6RS', 50, '20.87'),
(6, 'Oxycodone/APAP', 'WEK32ZPU5AM', 52, '44.00'),
(7, 'Citalopram HBr Plus', 'VNC98KXH2MIP', 21, '34.72'),
(8, 'Omeprazole (Rx)', 'XYA49WHV0KR', 99, '42.12'),
(9, 'Zyprexa', 'FIU35ZDE6OR', 25, '34.86'),
(10, 'Pravastatin Sodium', 'KUX58ZMM7SE', 27, '11.89'),
(11, 'Zyprexa 200 mg', 'FIU354DE6OR', 20, '14.60'),
(12, 'Advair Diskus', 'OOP23DQJ7NM', 78, '1.37'),
(13, 'Premarin', 'LEG81QOS7GH', 41, '32.19'),
(14, 'Carisoprodol', 'BSZ32MVW6CP', 45, '31.03'),
(15, 'LevothyroxineSodium', 'TTX41PLL6RS', 50, '20.87'),
(16, 'Proair HFA', 'QNY26CZD2WU', 19, '26.50'),
(17, 'Doxycycline Hyclate', 'INY43OXD2AL', 84, '30.06'),
(18, 'Proair HFA Plus', 'FSG26OWV2OBP', 78, '33.42'),
(19, 'Atenolol 200 mg', 'HMC80TVW7OV', 63, '44.11'),
(20, 'Meloxicam', 'PLG25YDO7TR', 36, '39.03'),
(21, 'Gianvi', 'WEP70KXW7TB', 18, '42.16'),
(22, 'Metoprolol Tartrate', 'MCL29AYC6XN', 35, '15.70'),
(23, 'Ibuprofen (Rx)', 'ISR07TMT9YG', 33, '30.04'),
(24, 'Carvedilol 30 mg', 'ESD60QWB1HMT', 60, '15.03'),
(25, 'Cyclobenzaprin HCl', 'DTT61YWU6FP', 76, '14.58'),
(26, 'Clindamycin HCl', 'IEO02SEM6FN', 10, '27.30'),
(27, 'Premarin', 'FUQ78UDF1HM', 26, '27.52'),
(28, 'Benicar HCT', 'VRN23DBX4PF', 97, '37.65'),
(29, 'Alprazolam 500 mg', 'UBS60VCO5MEX', 66, '12.74'),
(30, 'Amphetamine Salts', 'TII44YXA5OZ', 5, '19.42'),
(31, 'Metformin HCl', 'CQR43NSM8KM', 7, '6.91'),
(32, 'Enalapril Maleate', 'VEA17GKE9CC', 34, '30.56'),
(33, 'Albuterol', 'WNX43HTM2WR', 94, '4.13'),
(34, 'Klor-Con M20', 'XRV11YOK6LV', 66, '40.41'),
(35, 'Potassium Chloride', 'MGT64VOH4AJ', 50, '36.43'),
(36, 'Allopurinol', 'ZST75RWN0BQ', 70, '9.94'),
(37, 'Ventolin HFA', 'FJR81HSR8BB', 24, '36.48'),
(38, 'Warfarin Sodium', 'WQJ58JZQ6PP', 16, '26.01'),
(39, 'Crestor', 'CYO41EKX2JO', 76, '10.50'),
(40, 'Fluticasone Propionate', 'GEJ74QFJ1II', 41, '18.34'),
(41, 'Pravastatin Sodium', 'SPJ37KKF4PW', 92, '31.83'),
(42, 'Niaspan', 'LXC31KTI7PZ', 32, '12.80'),
(43, 'Warfarin Sodium', 'DMG32EVW1AQ', 64, '43.77'),
(44, 'Ibuprofen (Rx)', 'BAD31IRY2ZC', 10, '37.55'),
(45, 'Pantoprazole Sodium', 'CDY51XFE6DF', 85, '19.75'),
(46, 'Doxycycline Hyclate', 'IKA45JKQ2DC', 52, '4.57'),
(47, 'Endocet', 'HOJ77FLU7BA', 22, '6.68'),
(48, 'Carvedilol', 'ESD60QWB1HM', 60, '35.03'),
(49, 'Celebrex', 'JFE71MYY6MB', 87, '5.53'),
(50, 'Abilify', 'OCC97XEF1TF', 22, '42.32'),
(51, 'Vitamin D (Rx)', 'FLJ78RBZ7EM', 96, '26.32'),
(52, 'Levothyroxine Sodium', 'OFD13RJZ7JC', 25, '36.05'),
(53, 'Vyvanse', 'EMK98LOO2JQ', 7, '39.46'),
(54, 'Famotidine', 'FAM13PDQ8XF', 20, '17.63'),
(55, 'Januvia', 'BWD35HMF2BC', 55, '16.94'),
(56, 'TriNessa', 'PFI23OMV8VO', 37, '7.40'),
(57, 'Suboxone', 'LUL95COP4GE', 81, '41.24'),
(58, 'Symbicort', 'EID86JER0WH', 53, '31.36'),
(59, 'Doxycycline Hyclate', 'CHD62JNC8MQ', 95, '43.12'),
(60, 'Digoxin', 'BRJ81TKG4KU', 84, '6.90'),
(61, 'Citalopram HBR', 'VNC98KXH2MI', 20, '34.72'),
(62, 'Levaquin', 'GWL56WKD7WF', 91, '15.79'),
(63, 'Fluticasone Propionate', 'TRJ54ODP2RR', 49, '16.46'),
(64, 'Viagra', 'XGR68RZK4TH', 70, '12.17'),
(65, 'Viagra', 'OQS55QTE1TL', 51, '38.55'),
(66, 'Atenolol', 'RST80ARD1XW', 91, '43.72'),
(67, 'Alendronate Sodium', 'HHT40ZQL3MR', 80, '17.61'),
(68, 'Methylprednisolone', 'PUG47UIO1WF', 22, '28.46'),
(69, 'Lovaza', 'SIL11ITW1OC', 47, '23.94'),
(70, 'Warfarin Sodium', 'NFX33MWH8WE', 31, '42.58'),
(71, 'Citalopram ', 'IJK21UYP7AS-', 5, '5.77'),
(72, 'Oxycontin', 'IPN46LEQ3BC', 86, '12.50'),
(73, 'Nexium', 'NLK33HST1XE', 90, '3.91'),
(74, 'Nexium', 'BLJ05NWT7KN', 12, '18.43'),
(75, 'Sulfamethoxazole/Trimethoprim', 'GGX76QYG2SL', 38, '2.10'),
(76, 'Levoxyl', 'KUI56VES4HO', 51, '36.10'),
(77, 'Levothyroxine Sodium X', 'VCX17ISG5QJXX', 90, '15.67'),
(78, 'Lisinopril', 'HPE72FQI1QC', 22, '27.30'),
(79, 'Tramadol HCl', 'NXJ85JHC2CG', 97, '43.74'),
(80, 'Ciprofloxacin HCl', 'BSK88VID5QN', 76, '38.83'),
(81, 'Suboxone', 'LKM11UPB9GT', 38, '38.78'),
(82, 'Nasonex', 'THS92XCP2YK', 28, '34.90'),
(83, 'Allopurinol 200 ml', 'RCX32HAI3HOKQA', 84, '45.89'),
(84, 'Celebrex', 'IUW06POL5VS', 64, '25.19'),
(85, 'Lovastatin', 'LGW45MCW8RU', 38, '8.80'),
(86, 'Lantus Solostar', 'BTI13MQB1OU', 33, '31.43'),
(87, 'Clonazepam', 'BFE42KFR6MJ', 48, '43.28'),
(88, 'Warfarin Sodium', 'TJI57ZAS2IC', 49, '21.25'),
(89, 'Carvedilol 50 mg', 'ESD60QWB1HMC', 60, '30.03'),
(90, 'Namenda', 'KRV81DML2KH', 68, '2.71'),
(91, 'Ranitidine HCl', 'VUR81RGI8SH', 19, '40.72'),
(92, 'Metoprolol Tartrate', 'ILB56JLM8HH', 86, '7.00'),
(93, 'Carvedilol 80 mg', 'ESD60QWB1HMO', 60, '35.03'),
(94, 'Alprazolam', 'UBS60VCO5ME', 66, '22.74'),
(95, 'Triamcinolone Acetonide', 'XET53UOD6SY', 51, '33.91'),
(96, 'Sertraline HCl', 'AML43HWT5QE', 69, '14.85'),
(97, 'Cyclobenzaprin HCl', 'WHV87PIN7QJ', 25, '12.90'),
(98, 'Hydrochlorothiazide', 'XXX02VHI7CH', 67, '17.69'),
(99, 'Trazodone HCl', 'SLH21ASR3ML', 76, '1.54'),
(100, 'Oxycodone HCl', 'IJM27FST1ZU', 14, '32.48'),
(101, 'Pañales', 'PAPANON88X', 50, '2.36');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bodegueros`
--
ALTER TABLE `bodegueros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cajeros`
--
ALTER TABLE `cajeros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `bodegueros`
--
ALTER TABLE `bodegueros`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `cajeros`
--
ALTER TABLE `cajeros`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
