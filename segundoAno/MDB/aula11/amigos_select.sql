-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19-Jul-2024 às 22:13
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `amigos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`ID`, `DESCRICAO`) VALUES
(1, 'HORTOLÂNDIA'),
(2, 'SUMARÉ'),
(3, 'CAMPINAS'),
(4, 'PAULÍNIA'),
(5, 'AMERICANA'),
(6, 'MONTE MOR'),
(7, 'SÃO PAULO'),
(8, 'RIBEIRÃO PRETO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `losamigos`
--

CREATE TABLE `losamigos` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `CELULAR` varchar(14) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `DATANASC` date DEFAULT NULL,
  `IDCIDADE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Extraindo dados da tabela `losamigos`
--

INSERT INTO `losamigos` (`ID`, `NOME`, `CELULAR`, `EMAIL`, `DATANASC`, `IDCIDADE`) VALUES
(1, 'JOSÉ FERREIRA DA SILVA', '(19)99380-593', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(2, 'JOSÉ OTAVIO FERREIRA', '(19)99380-759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(3, 'LUCAS RESENDE DA SILVA', '(19)98963-949', 'LUCASRESENDE942@gmail.com', '2007-11-25', 1),
(4, 'ABNER DUTRA DE BRITO', '(19)99380-759', 'ABNER0135@GMAIL.COM', '2007-07-24', 2),
(5, 'AUGUSTUS KLINGBEIL', '(19)98441-483', 'AUGUSTUSKROSSI@GMAIL.COM', '2007-02-13', 2),
(6, 'ZOVERSON MOURA DA COSTA', '(19)97458-095', 'ZOVERSONMC@GMAIL.COM', '2007-08-10', 3),
(7, 'HAVERTON LOPES JUNIOR', '(19)99523-635', 'HAVERTON7345@GMAIL.COM', '2007-12-08', 3),
(8, 'TOM HOLLAND', '(19)95479-001', 'TOMHOLLAND@GMAIL.COM', '2005-10-05', 4),
(9, 'CAIO RIBEIRO', '(19)91235-567', 'RIBEIROCAIO12@GMAIL.COM', '2007-09-15', 3),
(10, 'CELSO PORTIÓLI', '(19)97531-246', 'CELSOPORTI1207@GMAIL.COM', '2007-09-11', 6),
(11, 'DORIVAL JUNIOR', '(19)99323-678', 'JDORIVAL23@GMAIL.COM', '2007-01-23', 3),
(12, 'JOSÉ FERREIRA DA SILVA', '(19)99380-759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(13, 'EDUARDA VERÍSSIMO', '(19) 98710-37', 'E.VERISSIMO@ALUNO.IFSP.EDU.BR', '2007-08-23', 2),
(14, 'ANA CLARA MARTINS CACIQUE LUZ', '(19) 98719-94', 'ANA.LUZ@ALUNO.IFSP.EDU.BR', '2007-06-06', 3),
(15, 'STHEFANY ROCHA LOBO', '(19) 98180-52', 'STHEFANYROCHALOBO@GMAIL.COM', '2007-07-15', 4),
(16, 'LORENA  CARL MARTINEZ DE ABREU', '(19) 99397-36', 'LORENA.CARL19@GMAIL.COM', '2008-02-27', 5),
(17, 'SABRINA FAUSTINO DE MORAES', '(19) 98234-29', 'FAUSTINOSAB@GMAIL.COM', '2007-08-22', 6),
(18, 'GIOVANNA DORNE', '(19) 99900-77', 'VANNADORNE@GMAIL.COM', '2008-04-02', 7),
(19, 'MATHEUS HENRIQUE PAES', '(19) 99722-69', 'MPAES6537@GMAIL.COM', '2008-11-09', 8),
(20, 'AUGUSTUS KLINGBEIL ROSSI', '(19) 98441-48', 'GUTINHO@GMAIL.COM', '2007-02-13', 2),
(21, 'LUCAS RESENDE DA SILVA', '(19) 96589-77', 'LUCASRESENDEDA@GMAIL.COM', '2007-11-25', 4),
(22, 'ANA CLARA SOARES ABRANTES', '(19) 98176-47', 'ABRANTESA@GMAIL.COM', '2007-10-01', 1),
(23, 'EMILLY VITORIA SOARES MARQUES BONFIM', '(19) 4002-892', 'VITORIACHAN@GMAIL.COM', '2008-01-21', 5),
(24, 'GLEICIELLY APARECIDA RIBEIRO SANTOS', '(19) 98776-48', 'GLEICYLINDA@GMAIL.COM', '2006-07-09', 7),
(25, 'CLAUDIO TOMAZ DE AQUINO', '(19) 45688-96', 'CLAUDIOAQUINO@GMAIL.COM', '2007-04-08', 6),
(26, 'GABRIEL CACHIMIRO DE BIAZZIO', '(19) 95684-99', 'GCACHIMIRO@GMAIL.COM', '2007-02-22', 1),
(27, 'NICOLAS HENRIQUE AMORIM DOS SANTOS', '(19) 99390-76', 'NICOLASAMORIM@GMAIL.COM', '2006-11-30', 5),
(28, 'JOAO PEDRO MARQUETE BARBOSA', '(19) 96584-98', 'JOAOMARQUETE@GMAIL.COM', '2007-05-02', 3),
(29, 'LARISSA LORAYNE SANTOS GOMES', '(19) 99654-79', 'LARILUKA@GMAIL.COM', '2007-10-25', 2),
(30, 'RAVERTON JUNIOR AMERICANO', '(19) 98654-32', 'REVERTONAMERICANO@GMAIL.COM', '2002-10-25', 4),
(35, 'DANIEL MEIRA DA SILVA', '(19)983149001', 'MEIRADANIEL132@GMAIL.COM', '2008-12-10', 3),
(36, 'MATHEUS SANTANA DE BASTOS', '(19)987730030', 'MSBASTOS006@GMAIL.COM', '2006-12-19', 1),
(37, 'PEDRO LUIZ MARIANO VOGADO FILH', '(19)999102008', 'PLMVFILHO@GMAIL.COM', '2008-05-03', 1),
(38, 'KEVIN DOS SANTOS REIS', '(19)981817005', 'KREIS0070@GMAIL.COM', '2007-08-16', 6),
(39, 'VITORIA SERRA', '(19)99083-9623', 'SERRINHA33688@GMAIL.COM', '2008-10-26', 1),
(40, 'VIVIAN ISABELLE CHAVES', '(19)99462-3529', 'VIVISBELLE87@GMAIL.COM', '2008-04-12', 2),
(41, 'PEROLA ISABELLY BANZATO', '(19)99345-0923', 'ISINHALINDA@GMAIL.COM', '2006-12-30', 1),
(42, 'MARIA EDUARDA EMERICK', '(19)99234-5678', 'MARIAEMERICK2005@YAHOO.COM', '2007-07-18', 3),
(43, 'NICOLAS DIAS', '(19)99567-4321', 'NICOLASDIASSZ2004@HOTMAIL.COM', '2005-06-22', 4),
(44, 'JOAO PEDRO RODRIGUES', '(19)99678-1234', 'JOAOVIDENTE@OUTLOOK.COM', '2007-04-10', 3),
(45, 'NATHALIA BARBOSA', '(19)99789-8765', 'NATHZINHA04@GMAIL.COM', '2008-05-07', 3),
(46, 'ISABELA BARBOSA', '(19)99876-5432', 'ISABELA2008@GMAIL.COM', '2008-07-16', 5),
(47, 'VALENTIONA NAOMI', '(19)99912-3456', 'VALNAOME@GMAIL.COM', '2007-01-10', 5),
(48, 'SOPHIE NAOMI', '(19)99123-4567', 'SOSON2007@YAHOO.COM', '2007-01-10', 5),
(49, 'LUCAS RESENDE DA SILVA', '(19)9896-3949', 'LUCASRESENDE9412@GMAIL.COM', '2007-11-25', 1),
(50, 'ABNER DUTRA DA SILVA', '(19)9923-3275', 'ABNER035@GMAIL.COM', '2007-07-24', 2),
(51, 'ANA CLARA SOARES ABRANTES', '(19)9817-6479', 'A.ABRANTES@ALUNO.IFSP.EDU.BR', '2007-10-01', 1),
(52, 'GLEICIELLY APARECIDA RIBEIRO SANTOS', '(19)9894-6106', 'RIBEIROGLEICIELLY312@GMAIL.COM', '2006-09-07', 1),
(53, 'JOSE FERREIRA DA SILVA', '(19)9938-0759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(54, 'CORINGA RIBEIRO ROSSI', '(19)95359-684', 'CORINGA.ROSSI.@GMAIL.COM', '2002-05-01', 7),
(55, 'ANGELINA JOLLIE', '(19)99239-254', 'A.JOLLIE.@GMAIL.COM', '2012-06-12', 3),
(56, 'MARCOS FREEIRE', '(19)99339-141', 'MRCOS.FREE.@GMAIL.COM', '2017-12-31', 8),
(57, 'CLARK CLENT', '(19)99799-224', 'C.CLENT.@GMAIL.COM', '2001-03-27', 6),
(58, 'PEDRO GONÇALVES ALVES', '(19)98779-339', 'PEDROALVES.@GMAIL.COM', '2017-07-02', 4),
(59, 'VITORIA MARQUES SOARES', '(19)98799-342', 'VITORIASOARES.@GMAIL.COM', '2007-04-30', 5),
(60, 'carlos henrique xavier dos san', '(19)99587-1384', 'chxs290108@gmail.com', '2008-01-29', 1),
(61, 'aracele xavier dos santos', '(19)99535-5462', 'aracelefranca@gmail.com', '1978-07-16', 1),
(62, 'paulo roberto junior', '(19)99579-8637', 'emprestimotiopaulo@gmail.com', '1956-08-27', 4),
(63, 'arthur do val', '(19)99579-8637', 'mamaefalei@gmail.com', '1986-08-21', 7),
(64, 'Bruno Monteiro Aiub', '(19)9957-3437', 'monark@gmail.com', '1990-08-17', 7),
(65, 'NICOLAS SALES SANTOS', '(19) 98871-46', 'NICK.NSS08@GMAIL.COM', '2008-03-14', 4),
(66, 'GIOVANNA DORNE', '(19)  99900-7', 'VANNADORNE@GMAIL.COM', '2008-04-02', 5),
(67, 'DOMINIQUE PEIXOTO SOARES', '(11) 96617-61', 'ZUZUZUJUBA@GMAIL.COM', '2007-07-13', 7),
(68, 'SABRINA FAUSTINO DE MORAES', '(19) 98234-29', 'FAUSTINOSAB@GMAIL.COM', '2007-08-22', 3),
(69, 'LARISSA LORAYNE SANTOS GOMES', '(19) 99266-18', 'KATHIWCCA@GMAIL.COM', '2007-10-26', 2),
(70, 'MATHEUS HENRIQUE PAES', '(19) 99722-69', 'MPAES6537@GMAIL.COM', '2007-11-09', 8),
(71, 'DANIEL MEIRA', '(19) 98314-90', 'DANDANMEIRA@GMAIL.COM', '2008-11-10', 6),
(72, 'NATNAEL MAGDALENA DA SILVA', '(19)98960-4048', 'NATANAELFAIL@GMAIL.COM', '2007-04-05', 1),
(73, 'EDUADA MARESSA DO NASCIMENTO MARTINS', '(19)98113-1308', 'DUDAMARE09@GMAIL.COM', '2007-05-09', 1),
(74, 'CLARA LUIZA DO NASCIMENTO MARTINS DA SILVA', '(19)99598-2654', 'CACADASILVA@GMAIL.COM', '2011-08-07', 3),
(75, 'ISADORA ROBERTA ANTONIA', '(19)99876-4235', 'ISADORATONA@GMAIL.COM', '2007-08-24', 2),
(76, 'CAMILA DE SOUZA', '(19)98954-2324', 'CAMILASS@ICLOUD.COM', '2000-12-25', 4),
(77, 'NICOLAU PEDROSO DE OLIVEIRA', '(19)99695-7893', 'NICOPEDROSO@ICLOUD.COM', '2009-09-15', 6),
(78, 'ROBERTO CARLOS BARTOLI', '(19)98912-4692', 'ROBERTOC@GMAIL.COM', '1998-01-25', 4),
(79, 'ANA GABRIELA DA SILVA', '(19)99458-0982', 'ANAXPT@gmail.COM', '2007-11-23', 8),
(80, 'JOSÉ DONIZETTE DA SILVA', '(19)99654-1765', 'JOSEDONI@gmail.COM', '1979-06-22', 3),
(81, 'GABRIELLY ALVES SANTA ROSA ', '(19)98953-2112', 'GABALVES@gmail.COM', '2007-11-29', 2),
(82, 'Ana Abrantes ', ' (19) 99884-8', ' aninha@gmail.com', '2007-10-22', 1),
(83, 'Emilly', '(19) 96780-23', ' emillyagnaldes@gmail.com', '2008-01-21', 7),
(84, 'Gleicy Marques ', ' (19) 99678-3', ' gleicyfutebel@gmail.com', '2006-09-07', 4),
(85, 'Abner Truta', ' (19) 94567-3', ' trutaabner@gmail.com', '2008-07-24', 2),
(86, 'Lucas Resende ', ' (19) 99700-8', ' resende.lucas@gmail.com', '2007-11-25', 1),
(87, 'Augustus Rossi ', ' (19) 98985-3', ' augustus.roça.plantas@gmail.com', '2007-02-13', 2),
(88, 'Clarisse', '(19) 98770-35', 'clarisse.lança@gmail.com', '2001-12-10', 8),
(89, 'Percy Jackson', ' (19) 96040-2', 'jacksonpercy@gmail.com', '2002-08-21', 6),
(90, 'Annabeth Chase', ' (19) 91345-2', 'bethchase@gmail.com', '2002-03-11', 5),
(91, 'Benjamin Franklin', ' (19) 93849-1', 'benjafranklin@gmail.com', '2004-04-08', 3),
(92, 'Julia Almeida Rocha', ' (19) 93119-4', 'rocha.almeida.julia@gmail.com', '2005-11-15', 4),
(93, 'Woo Seok Byeon', ' (19) 95009-1', 'byeonseok.woo@gmail.com', '1999-12-21', 6),
(94, 'Vinícius Junior', ' (19) 90989-0', 'vinimalvadeza@gmail.com', '2000-05-12', 2),
(95, 'Giorgian De Arrascaeta', ' (19) 90907-0', 'dearrascafutebol@gmail.com', '1994-06-01', 1),
(96, 'Lana Del Rey', ' (19) 9055-03', 'reylanadel@gmail.com', '1985-06-21', 8),
(97, 'Pedro Vitor', ' (19) 92345-1', 'vitorpedro@gmail.com', '2019-06-08', 3),
(98, 'Aurora Viana', ' (19) 90906-1', 'aurorav.011@gmail.com', '2011-10-28', 7),
(99, 'Isac Bonfim', ' (19) 90987-6', 'isacbonf@gmail.com', '2023-02-10', 4),
(100, 'Maria Cecília', ' (19) 99335-4', 'cecimaria@gmail.com', '2016-09-06', 5),
(101, 'GABRIEL DAVID DE OLIVEIRA', '(19)69850-079', 'GABRIELDAVID@GMAIL.COM', '1994-02-16', 1),
(102, 'Haoran Jiang', '(19)98356-092', 'HAORAN@GMAIL.COM', '2004-12-12', 4),
(103, 'RAFAEL OLIVEIRA', '(19)97064-458', 'RAFAELOLIVERA@GMAIL.COM', '1950-07-05', 3),
(104, 'YAGO SANTOS', '(19)89563-983', 'YAGOSANTOS@GMAIL.COM', '1960-06-10', 4),
(105, 'ANA MARIA', '(19)59663-269', 'ANAMARIA2@GMAIL.COM', '2010-09-22', 1),
(106, 'PEDRO PAES', '(19)69850-079', 'PEDROPAES@GMAIL.COM', '1990-04-26', 2),
(107, 'NATANAEL RODRIGUES', '(19)98365-230', 'NATANAELRODRIGUES@GMAIL.COM', '2004-12-02', 3),
(108, 'KAIKY SILVA', '(19)97064-459', 'KAIKYSILVA4@GMAIL.COM', '2002-07-05', 6),
(109, 'TAYANE RIBEIRO', '(19)89568-983', 'TAYANERIBEIRO@GMAIL.COM', '1999-06-10', 8),
(110, 'HIRAN RODRIGUES', '(19)59363-269', 'HIRANRODRIGUES@GMAIL.COM', '2005-09-22', 3),
(111, 'HAORAN JIANG', '(19)99957-421', 'HAORAN.J007@GMAIL.COM', '2007-09-07', 1),
(112, 'YURI', '(19) 986322-0', 'YURIZINHO@GMAIL.COM', '2008-05-22', 1),
(113, 'LUIZ HENRIQUE DE OLIVEIRA', '(19) 99256-60', 'LUZINHO088@GMAIL.COM', '1940-03-06', 3),
(114, 'CHICO BUARQUE', '(19) 26290-43', 'CHICOBUARQUE@GMAIL.COM', '1944-06-19', 4),
(115, 'PEDRO', '(19) 844320-2', 'PEDROPEDREIRO@GMAIL.COM', '2011-03-05', 5),
(116, 'FELIPE', '(19) 0142=397', 'FASTPGP@GMAIL.COM', '2004-05-30', 2),
(117, 'MAH', '(19) 1034-582', 'MAHHA05@GMAIL.COM', '1300-02-19', 7),
(118, 'RENATO', '(19) 4002-892', 'RENATINHO233.@GMAIL.COM', '1955-06-02', 8),
(119, 'ANA SILVA', '(19)98765-432', 'ANA.SILVA@EMAIL.COM', '2004-02-15', 1),
(120, 'CARLOS OLIVEIRA', '(19)99999-888', 'CARLOS.OLIVEIRA@EMAIL.COM', '2005-06-20', 2),
(121, 'JULIANA SANTOS', '(19)12345-678', 'JULIANA.SANTOS@EMAIL.COM', '2006-08-28', 3),
(122, 'MARCOS COSTA', '(19)87654-321', 'MARCOS.COSTA@EMAIL.COM', '2007-04-10', 1),
(123, 'PATRÍCIA SOUZA', '(19)56789-432', 'PATRICIA.SOUZA@EMAIL.COM', '2008-09-02', 2),
(124, 'RENATO FERREIRA', '(19)23456-789', 'RENATO.FERREIRA@EMAIL.COM', '2004-12-18', 3),
(125, 'CARLA LIMA', '(19)33333-444', 'CARLA.LIMA@EMAIL.COM', '2005-03-25', 1),
(126, 'FERNANDO SANTOS', '(19)98765-432', 'FERNANDO.SANTOS@EMAIL.COM', '2006-07-12', 2),
(127, 'MARIANA OLIVEIRA', '(19)87654-321', 'MARIANA.OLIVEIRA@EMAIL.COM', '2007-11-30', 3),
(128, 'RODRIGO SILVA', '(19)55555-666', 'RODRIGO.SILVA@EMAIL.COM', '2008-02-14', 1),
(129, 'JOSÉ FERREIRA DA SILVA', '(19)99380-759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(130, 'LETICIA ARAÚJO DELPINO', '(19)98325-283', 'LE.DELPINO73@GMAIL.COM', '2007-08-24', 1),
(131, 'ROSANA DELPINO', '(19)98709-671', 'ROSANADELPINO8@GMAIL.COM', '1977-06-05', 1),
(132, 'MARIA DAS DORES DA SILVA', '(19)98926-593', 'MADORES.BSILVA@GMAIL.COM', '1968-07-01', 1),
(133, 'TAYANE BENIGNO', '(19)98700-776', 'TAYANEREPRESENTA05@GMAIL.COM', '2007-06-28', 1),
(134, 'KEVIN DOS SANTOS REIS', '(19)98181-700', 'KREIS0070@GMAIL.COM', '2008-05-03', 1),
(135, 'MATHEUS', '(19)99380-759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(136, 'PEDRO', '(19)99380-759', 'PEDRO@ICLOUD.COM', '2007-05-02', 4),
(137, 'ANA CLARA', '(19)99380-759', 'ANACOISADA@ICLOUD.COM', '2007-05-02', 3),
(138, 'GUSTAVO LIMA', '(19)99380-759', 'JOSEOTAVIOFERREIRA19@ICLOUD.COM', '2007-05-02', 1),
(139, 'OSVALDO', '(19)99380-759', 'PEDRO@ICLOUD.COM', '2007-05-02', 4),
(140, 'KAUAN MEDEIROS', '(19)99380-759', 'ANACOISADA@ICLOUD.COM', '2007-05-02', 3),
(141, 'Abner Dutra de Brito', '(19)99233-275', 'ABNER0135@GMAIL.COM', '2007-07-24', 2),
(142, 'Yanco Silva de Jesus', '(19)99321-879', 'YANCOBRASIL@GMAIL.COM', '2002-09-12', 2),
(143, 'Jeclineison Carvalho de Oliveira', '(19)99276-859', 'JECLICARV@ICLOUD.COM', '1990-07-20', 3),
(144, 'Wemerson Golçalves Dias', '(19)99096-254', 'WEMERSONDIAS@GMAIL.COM', '2004-01-10', 4),
(145, 'Vin Diesel da Silva', '(19)99732-949', 'VINDIESEL29@ICLOUD.COM', '1967-05-02', 5),
(146, 'Everson Jacarandá da Penha', '(19)99976-269', 'EVERSONPENHA@GMAIL.COM', '1980-08-14', 6),
(147, 'Julia Pereira Mendes', '(19)99083-769', 'JULIAPEREIRA@GMAIL.COM', '2006-06-26', 7),
(148, 'Amanda Machado Peçanha', '(19)99923-723', 'AMANDAPEÇANHA@GMAIL.COM', '2009-02-22', 8),
(149, 'Genesca Almeida da Silva', '(19)99753-362', 'GENESCAALMEIDA@GMAIL.COM', '1993-08-17', 8),
(150, 'Paulo Resende Moreira', '(19)99284-712', 'PAULORESENDE@GMAIL.COM', '1983-09-11', 8),
(151, 'HAORAN JIANG', '(19)99957-421', 'HAORAN.J007@GMAIL.COM', '2007-09-07', 1),
(152, 'YURI', '(19) 986322-0', 'YURIZINHO@GMAIL.COM', '2008-05-22', 1),
(153, 'LUIZ HENRIQUE DE OLIVEIRA', '(19) 99256-60', 'LUZINHO088@GMAIL.COM', '1940-03-06', 3),
(154, 'CHICO BUARQUE', '(19) 26290-43', 'CHICOBUARQUE@GMAIL.COM', '1944-06-19', 4),
(155, 'PEDRO', '(19) 844320-2', 'PEDROPEDREIRO@GMAIL.COM', '2011-03-05', 5),
(156, 'FELIPE', '(19) 0142=397', 'FASTPGP@GMAIL.COM', '2004-05-30', 2),
(157, 'MAH', '(19) 1034-582', 'MAHHA05@GMAIL.COM', '1300-02-19', 7),
(158, 'RENATO', '(19) 4002-892', 'RENATINHO233.@GMAIL.COM', '1955-06-02', 8),
(159, 'LUÍS MATHEUS HENRIQUE', '(19)2346-9017', 'LUIS@GMAIL.COM', '2001-04-23', 2),
(160, 'IRINEU DA SILVA SARO', '(13)3456-9082', 'IRINEU@GMAIL.COM', '1998-02-21', 5),
(161, 'DIEGO APARECIDO PAZ', '(19)7891-0921', 'DIEGUINHO@GMAIL.COM', '2013-06-22', 3),
(162, 'RYAN ROBERSON CRUSUÉ', '(13)9086-4352', 'RYANTOPE@GMAIL.COM', '2000-02-20', 6),
(163, 'BRIORNY LARKIN', '(12)1988-0987', 'BRUXADOPANTANO@SWAMPSA.COM', '0000-00-00', 8),
(164, 'ALINA STROVAV', '(12)3412-0987', 'DOBRADORADALUZ@GRISCHA.COM', '1893-03-07', 7),
(165, 'MIKAEL AFTON', '(19)1523-2432', 'GUARDADESEGURANCA@FNAF.COM', '1999-12-19', 2),
(166, 'MAGNUS BANE', '(19)9012-0921', 'FEITICEIROMAISGATO@GMAIL.COM', '1000-01-01', 7),
(167, 'GREG POWELL', '(18)2013-0918', 'GREGPOWELL@USROBOTSMACHINE.COM', '1970-09-18', 5),
(168, 'MIKE DONAVAN', '(18)1431-7893', 'MIKEDONAVAN@USROBOTSMACHINE.COM', '1975-06-09', 5),
(169, 'WANDINHA ADDAMS', '(19)4323-0912', 'WANDINHA@GMAIL.COM', '2006-06-06', 4),
(170, 'IGOR VENTRIS SOUZA', '(13)9047-2342', 'IGORVS@ICLOUD.COM', '2007-06-23', 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `losamigos`
--
ALTER TABLE `losamigos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDCIDADE` (`IDCIDADE`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cidade`
--
ALTER TABLE `cidade`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `losamigos`
--
ALTER TABLE `losamigos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=171;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `losamigos`
--
ALTER TABLE `losamigos`
  ADD CONSTRAINT `LOSAMIGOS_ibfk_1` FOREIGN KEY (`IDCIDADE`) REFERENCES `cidade` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
