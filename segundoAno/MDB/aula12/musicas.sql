-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Ago-2024 às 22:00
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
-- Banco de dados: `musicas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cantor_banda`
--

CREATE TABLE `cantor_banda` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `NACIONALIDADE` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cantor_banda`
--

INSERT INTO `cantor_banda` (`ID`, `NOME`, `NACIONALIDADE`) VALUES
(1, 'Gustavo Lima', 'Brasileiro'),
(2, 'Alok', 'Brasileiro'),
(3, 'Skillet', 'Americano'),
(4, 'Imagine Dragons', 'Americano'),
(5, 'Alan Walker', 'Norueguês');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estilo`
--

CREATE TABLE `estilo` (
  `ID` int(11) NOT NULL,
  `descricao` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `estilo`
--

INSERT INTO `estilo` (`ID`, `descricao`) VALUES
(1, 'Sertanejo'),
(2, 'Eletrônica'),
(3, 'Rock');

-- --------------------------------------------------------

--
-- Estrutura da tabela `musica`
--

CREATE TABLE `musica` (
  `ID` int(11) NOT NULL,
  `TITULO` varchar(50) DEFAULT NULL,
  `IDCANTOR` int(11) DEFAULT NULL,
  `IDESTILO` int(11) DEFAULT NULL,
  `ANO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `musica`
--

INSERT INTO `musica` (`ID`, `TITULO`, `IDCANTOR`, `IDESTILO`, `ANO`) VALUES
(1, 'Termina comigo antes', 1, 1, NULL),
(2, 'Hear me now', 2, 2, NULL),
(3, 'Monster', 3, 3, NULL),
(4, 'Beliver', 4, 3, NULL),
(5, 'Faded', 5, 2, NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cantor_banda`
--
ALTER TABLE `cantor_banda`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `estilo`
--
ALTER TABLE `estilo`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `musica`
--
ALTER TABLE `musica`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDCANTOR` (`IDCANTOR`),
  ADD KEY `IDESTILO` (`IDESTILO`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cantor_banda`
--
ALTER TABLE `cantor_banda`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `estilo`
--
ALTER TABLE `estilo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `musica`
--
ALTER TABLE `musica`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `musica`
--
ALTER TABLE `musica`
  ADD CONSTRAINT `musica_ibfk_1` FOREIGN KEY (`IDCANTOR`) REFERENCES `cantor_banda` (`ID`),
  ADD CONSTRAINT `musica_ibfk_2` FOREIGN KEY (`IDESTILO`) REFERENCES `estilo` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
