-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 11-Out-2024 às 19:52
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
-- Banco de dados: `AtualizacaoRemosao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `classificacao`
--

CREATE TABLE `classificacao` (
  `COD` int(1) NOT NULL DEFAULT 0,
  `CLASSIFICACAO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `classificacao`
--

INSERT INTO `classificacao` (`COD`, `CLASSIFICACAO`) VALUES
(1, 'Sapato'),
(2, 'Roupa'),
(3, 'Acessório'),
(4, 'Brinde');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cor`
--

CREATE TABLE `cor` (
  `id` int(11) NOT NULL,
  `descricao` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cor`
--

INSERT INTO `cor` (`id`, `descricao`) VALUES
(128, 'Color'),
(129, 'Preto'),
(130, 'Pto/Vrm'),
(131, 'Preto Fosco '),
(132, 'Azul'),
(133, 'Branco'),
(134, 'Vermelho'),
(135, 'Pto/Branco'),
(136, 'Caf'),
(137, 'Verde'),
(138, 'Amarelo'),
(139, 'Pink'),
(140, 'Rosa Claro'),
(141, 'Azul/Preto'),
(142, 'Azul/Verde'),
(143, 'Amr/Verde'),
(144, 'Rosa/Roxo'),
(145, 'Marrom'),
(146, 'Caramelo '),
(147, 'Cinza'),
(148, 'Azul Escuro'),
(149, 'Rosa/Pink'),
(150, 'Azul Marinho'),
(151, 'Preto/Rosa'),
(152, 'Lilas '),
(153, 'Taupe'),
(154, 'Azul/Branco'),
(155, 'Dourado'),
(156, 'Ouro'),
(157, 'Rosa'),
(158, 'Prata'),
(159, 'Roxo'),
(160, 'Grafite'),
(161, 'Marinho'),
(162, 'Preto/Dourado'),
(163, 'Jeans'),
(164, 'Brnc/Vrm'),
(165, 'Cinza/Azul'),
(166, 'Bronze'),
(167, 'Natural'),
(168, 'Cinza/Brnc'),
(169, 'Vinho'),
(170, 'Branca'),
(171, 'Preto/Cinza');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `CODIGO` int(2) NOT NULL DEFAULT 0,
  `produtos` varchar(46) DEFAULT NULL,
  `CLASSIFICACAO` int(1) DEFAULT NULL,
  `GENERO` varchar(5) DEFAULT NULL,
  `TAMANHO` varchar(6) DEFAULT NULL,
  `PRECO` decimal(6,2) DEFAULT NULL,
  `qtde_estoque` int(11) DEFAULT NULL,
  `idcor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `classificacao`
--
ALTER TABLE `classificacao`
  ADD PRIMARY KEY (`COD`);

--
-- Índices para tabela `cor`
--
ALTER TABLE `cor`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `CODIGO` (`CODIGO`),
  ADD KEY `CLASSIFICACAO` (`CLASSIFICACAO`),
  ADD KEY `idcor` (`idcor`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cor`
--
ALTER TABLE `cor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`idcor`) REFERENCES `cor` (`id`),
  ADD CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`CLASSIFICACAO`) REFERENCES `classificacao` (`COD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
