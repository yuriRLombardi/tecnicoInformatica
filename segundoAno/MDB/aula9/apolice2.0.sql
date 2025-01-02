-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Jul-2024 às 22:07
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
-- Banco de dados: `apolice`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acidente`
--

CREATE TABLE `acidente` (
  `NUMERO` int(11) NOT NULL,
  `DATA` date DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `LOCAL` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `acidente`
--

INSERT INTO `acidente` (`NUMERO`, `DATA`, `HORA`, `LOCAL`) VALUES
(1, '2024-07-12', '07:40:00', 'AVENIDA AMPÉLIO GAZZETA EM NOVA ODESSA'),
(2, '2024-03-20', '08:20:00', 'Rua das Acácias em Americana'),
(3, '2024-05-10', '15:00:00', 'Avenida 7 de Setembro em Sumaré'),
(4, '2024-07-08', '23:40:00', 'Avenida da Amizade em Sumaré'),
(5, '2024-07-10', '22:00:00', 'Rua Vicente Ferreira em Campinas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `acidente_carro`
--

CREATE TABLE `acidente_carro` (
  `NUMERO` int(11) DEFAULT NULL,
  `REGISTROCARRO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `acidente_carro`
--

INSERT INTO `acidente_carro` (`NUMERO`, `REGISTROCARRO`) VALUES
(1, 2),
(1, 1),
(1, 3),
(2, 4),
(2, 5),
(3, 10),
(3, 11),
(4, 9),
(4, 7),
(4, 6),
(5, 3),
(5, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `apolice`
--

CREATE TABLE `apolice` (
  `NUMERO` int(11) NOT NULL,
  `VALOR` float DEFAULT NULL,
  `MARCA` varchar(40) DEFAULT NULL,
  `NUMEROCLIENTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `apolice`
--

INSERT INTO `apolice` (`NUMERO`, `VALOR`, `MARCA`, `NUMEROCLIENTE`) VALUES
(1, 45240.4, 'FIAT TORO', 1),
(2, 23456.7, 'FORD KA', 2),
(3, 120568, 'MONTANA CHEVROLET', 2),
(4, 45135.5, 'AGILE CHEVROLET', 1),
(5, 56789, 'C3 Citroen', 57),
(6, 24678.9, 'Palio Fiat', 94),
(7, 65354.4, 'Fit Honda', 57),
(8, 90354.5, 'Argo Fiat', 10),
(9, 46784.5, 'Astra Chevrolet', 11),
(10, 78543, 'Onix Chevrolet', 40),
(11, 56345, 'Cobalt Chevrolet', 35),
(12, 78900, 'Polo Volkswagen', 40),
(13, 90567.5, 'Pulse Fiat', 10),
(14, 56890.4, 'Mobi Fiat', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `NUMERO` int(11) NOT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `ENDERECO` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`NUMERO`, `NOME`, `ENDERECO`) VALUES
(1, 'JOÃO DIAS', 'RUA 1, 30 JD. SÃO DOMINGOS,SUMARÉ'),
(2, 'MARIA MACHADO', 'RUA VICENTE DE SOUZA,430 VILA JOÃO PAULO, PEDREIRA'),
(3, 'VICENTE DA SILVA MACHADO', 'RUA 3,780 VILA SANTA MADALENA,SÃO PAULO'),
(10, 'Teresa Dias Soares', 'Rua Heitor 450 - Centro - Hortolândia'),
(11, 'Carlos Silva', 'Rua 01 45 - Centro - Sumaré'),
(35, 'Viviane Aparecida Silva', 'Rua 01 45 - Centro - Sumaré'),
(40, 'Antônio Dias Machado', 'Avenida Teresa Dias - 200 - Jd. São Judas Tadeu - Hortolândia'),
(57, 'Catarina Metieres', 'Avenida Paulo Adulto Duarte - 340 - Centro - Campinas'),
(80, 'Paula Aparecida Souza', 'Rua das Acácias - 30 - Pq. das Flores - Americana'),
(94, 'Pedro Giacomo Santos', 'Rua 40 43 -  Morro Alto - Campinas');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `acidente`
--
ALTER TABLE `acidente`
  ADD PRIMARY KEY (`NUMERO`);

--
-- Índices para tabela `acidente_carro`
--
ALTER TABLE `acidente_carro`
  ADD KEY `NUMERO` (`NUMERO`),
  ADD KEY `REGISTROCARRO` (`REGISTROCARRO`);

--
-- Índices para tabela `apolice`
--
ALTER TABLE `apolice`
  ADD PRIMARY KEY (`NUMERO`),
  ADD KEY `NUMEROCLIENTE` (`NUMEROCLIENTE`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`NUMERO`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `acidente`
--
ALTER TABLE `acidente`
  MODIFY `NUMERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `acidente_carro`
--
ALTER TABLE `acidente_carro`
  ADD CONSTRAINT `acidente_carro_ibfk_1` FOREIGN KEY (`NUMERO`) REFERENCES `acidente` (`NUMERO`),
  ADD CONSTRAINT `acidente_carro_ibfk_2` FOREIGN KEY (`REGISTROCARRO`) REFERENCES `apolice` (`NUMERO`);

--
-- Limitadores para a tabela `apolice`
--
ALTER TABLE `apolice`
  ADD CONSTRAINT `apolice_ibfk_1` FOREIGN KEY (`NUMEROCLIENTE`) REFERENCES `cliente` (`NUMERO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
