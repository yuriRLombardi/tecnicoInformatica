-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Jul-2024 às 21:57
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `acidente_carro`
--

CREATE TABLE `acidente_carro` (
  `NUMERO` int(11) DEFAULT NULL,
  `REGISTROCARRO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `apolice`
--

CREATE TABLE `apolice` (
  `NUMERO` int(11) NOT NULL,
  `VALOR` float DEFAULT NULL,
  `MARCA` varchar(40) DEFAULT NULL,
  `REGISTRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `NUMERO` int(11) NOT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `ENDERECO` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`NUMERO`, `NOME`, `ENDERECO`) VALUES
(1, 'JOÃO DIAS', 'RUA 1, 30 JD. SÃO DOMINGOS,SUMARÉ'),
(2, 'MARIA MACHADO', 'RUA VICENTE DE SOUZA,430 VILA JOÃO PAULO, PEDREIRA');

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
  ADD PRIMARY KEY (`NUMERO`);

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
  MODIFY `NUMERO` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `acidente_carro`
--
ALTER TABLE `acidente_carro`
  ADD CONSTRAINT `acidente_carro_ibfk_1` FOREIGN KEY (`NUMERO`) REFERENCES `acidente` (`NUMERO`),
  ADD CONSTRAINT `acidente_carro_ibfk_2` FOREIGN KEY (`REGISTROCARRO`) REFERENCES `apolice` (`NUMERO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
