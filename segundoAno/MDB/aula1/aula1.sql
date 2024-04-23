-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Fev-2024 às 21:02
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
-- Banco de dados: `aula1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bicho`
--

CREATE TABLE `bicho` (
  `TIPO` varchar(50) DEFAULT NULL,
  `RACA` varchar(30) DEFAULT NULL,
  `COR` varchar(30) DEFAULT NULL,
  `TAMANHO` varchar(1) DEFAULT NULL,
  `GENERO` varchar(1) DEFAULT NULL,
  `ID` int(11) NOT NULL,
  `ID_DONO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `bicho`
--

INSERT INTO `bicho` (`TIPO`, `RACA`, `COR`, `TAMANHO`, `GENERO`, `ID`, `ID_DONO`) VALUES
('CACHORRO', 'BITBULL', 'BRANCO', 'M', 'F', 1, 1),
('CACHORRA', 'VIRA-LATA', 'PRETO', 'M', 'F', 2, 2),
('GATO', 'BOMBAIM', 'PRETO', 'M', 'M', 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `NOME` varchar(30) DEFAULT NULL,
  `IDADE` int(11) DEFAULT NULL,
  `GENERO` varchar(1) DEFAULT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`NOME`, `IDADE`, `GENERO`, `ID`) VALUES
('YURI', 15, 'M', 1),
('CARLOS', 16, 'M', 2),
('YAGO', 16, 'M', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `bicho`
--
ALTER TABLE `bicho`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_DONO` (`ID_DONO`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bicho`
--
ALTER TABLE `bicho`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `bicho`
--
ALTER TABLE `bicho`
  ADD CONSTRAINT `bicho_ibfk_1` FOREIGN KEY (`ID_DONO`) REFERENCES `pessoa` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
