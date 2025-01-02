-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 15-Out-2024 às 19:13
-- Versão do servidor: 10.2.38-MariaDB
-- versão do PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `aula1510Yuri`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `codproduto` int(11) NOT NULL,
  `descricao` tinytext DEFAULT NULL,
  `valorunitario` float DEFAULT NULL,
  `qtdeestoque` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`codproduto`, `descricao`, `valorunitario`, `qtdeestoque`) VALUES
(1, 'Tintas', 5.41, 60),
(2, 'Lápis', 3.5, 200),
(3, 'Cadernos', 10, 100),
(4, 'Post-it', 1, 500),
(5, 'Caderno de Desenhos', 20.5, 80),
(6, 'Grampos', 1, 250),
(7, 'Caneta', 3.5, 200),
(8, 'Folha de fichario', 20.5, 100),
(9, 'Lápis de Cor', 1.5, 300),
(10, 'Cadernos de Caligráfia', 23, 80);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`codproduto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
