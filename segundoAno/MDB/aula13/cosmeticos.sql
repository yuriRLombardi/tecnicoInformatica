-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/10/2024 às 01:07
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cosmeticos`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `yrlcliente`
--

CREATE TABLE `yrlcliente` (
  `YRLID` int(11) NOT NULL,
  `YRLNome` varchar(80) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `yrlcliente`
--

INSERT INTO `yrlcliente` (`YRLID`, `YRLNome`, `telefone`) VALUES
(1000, 'Afrotide Atacado', NULL),
(2001, 'Mercado Bauru', NULL),
(2122, 'Mercado Pedrito', NULL),
(2412, 'Atacado São José', NULL),
(2901, 'Lojas Du Peter', NULL),
(5577, 'Banca Maurício', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `yrlcontem`
--

CREATE TABLE `yrlcontem` (
  `YRLPedido` int(11) NOT NULL,
  `YRLProduto` int(11) NOT NULL,
  `YRLQTDE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `yrlcontem`
--

INSERT INTO `yrlcontem` (`YRLPedido`, `YRLProduto`, `YRLQTDE`) VALUES
(100, 387, 5),
(588, 111, 50),
(588, 470, 25),
(588, 631, 12),
(588, 123, 20),
(588, 358, 20),
(588, 123, 25),
(738, 631, 15),
(900, 631, 10),
(900, 345, 20),
(900, 358, 10),
(936, 897, 10),
(976, 111, 40),
(7709, 897, 80),
(7709, 243, 100),
(7709, 470, 20);

-- --------------------------------------------------------

--
-- Estrutura para tabela `yrlpedido`
--

CREATE TABLE `yrlpedido` (
  `YRLNum` int(11) NOT NULL,
  `YRLData_Pedido` varchar(10) NOT NULL,
  `YRLVendedor` int(11) NOT NULL,
  `YRLCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `yrlpedido`
--

INSERT INTO `yrlpedido` (`YRLNum`, `YRLData_Pedido`, `YRLVendedor`, `YRLCliente`) VALUES
(100, '08/09/2017', 97, 5577),
(588, '23/04/2017', 55, 5577),
(738, '01/11/2017', 17, 2412),
(888, '08/08/2017', 17, 2901),
(900, '15/09/2017', 97, 5577),
(936, '20/07/2017', 97, 2901),
(976, '15/10/2017', 76, 2901),
(7709, '21/02/2017', 76, 2122);

-- --------------------------------------------------------

--
-- Estrutura para tabela `yrlproduto`
--

CREATE TABLE `yrlproduto` (
  `YRLID` int(11) NOT NULL,
  `YRLDescricao` varchar(100) NOT NULL,
  `YRLValor` float(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `yrlproduto`
--

INSERT INTO `yrlproduto` (`YRLID`, `YRLDescricao`, `YRLValor`) VALUES
(111, 'Shampoo', 23.50),
(123, 'Spray Cabelo', 34.50),
(243, 'Removedor esmalte', 5.60),
(256, 'Condicionador', 25.60),
(345, 'Batom', 10.85),
(358, 'Reparador de Pontas', 10.90),
(387, 'Pomada', 12.50),
(470, 'Pó compacto', 32.80),
(631, 'Creme mãos', 18.20),
(897, 'Esmalte', 4.90);

-- --------------------------------------------------------

--
-- Estrutura para tabela `yrlvendedor`
--

CREATE TABLE `yrlvendedor` (
  `YRLID` int(11) NOT NULL,
  `YRLNome` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `yrlvendedor`
--

INSERT INTO `yrlvendedor` (`YRLID`, `YRLNome`) VALUES
(17, 'Jorge Esteves'),
(18, 'Paulino Alcantara'),
(55, 'Santos Silvio'),
(76, 'Braulio Pinheiros'),
(97, 'Felipe Dias');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `yrlcliente`
--
ALTER TABLE `yrlcliente`
  ADD PRIMARY KEY (`YRLID`);

--
-- Índices de tabela `yrlcontem`
--
ALTER TABLE `yrlcontem`
  ADD KEY `YRLPedido` (`YRLPedido`),
  ADD KEY `YRLProduto` (`YRLProduto`);

--
-- Índices de tabela `yrlpedido`
--
ALTER TABLE `yrlpedido`
  ADD PRIMARY KEY (`YRLNum`),
  ADD KEY `YRLVendedor` (`YRLVendedor`),
  ADD KEY `YRLCliente` (`YRLCliente`);

--
-- Índices de tabela `yrlproduto`
--
ALTER TABLE `yrlproduto`
  ADD PRIMARY KEY (`YRLID`);

--
-- Índices de tabela `yrlvendedor`
--
ALTER TABLE `yrlvendedor`
  ADD PRIMARY KEY (`YRLID`);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `yrlcontem`
--
ALTER TABLE `yrlcontem`
  ADD CONSTRAINT `yrlcontem_ibfk_1` FOREIGN KEY (`YRLPedido`) REFERENCES `yrlpedido` (`YRLNum`),
  ADD CONSTRAINT `yrlcontem_ibfk_2` FOREIGN KEY (`YRLProduto`) REFERENCES `yrlproduto` (`YRLID`);

--
-- Restrições para tabelas `yrlpedido`
--
ALTER TABLE `yrlpedido`
  ADD CONSTRAINT `yrlpedido_ibfk_1` FOREIGN KEY (`YRLVendedor`) REFERENCES `yrlvendedor` (`YRLID`),
  ADD CONSTRAINT `yrlpedido_ibfk_2` FOREIGN KEY (`YRLCliente`) REFERENCES `yrlcliente` (`YRLID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
