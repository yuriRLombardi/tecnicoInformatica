-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Ago-2024 às 20:01
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
-- Estrutura da tabela `pwbb`
--

CREATE TABLE `pwbb` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `NICK` varchar(30) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `CIDADE_NASCIMENTO` varchar(30) DEFAULT NULL,
  `CIDADE_MORA` varchar(30) DEFAULT NULL,
  `E_MAIL` varchar(50) DEFAULT NULL,
  `COR_PREFERIDA` varchar(30) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `USA_OCULOS` enum('S','N') DEFAULT NULL,
  `SIGNO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pwbb`
--

INSERT INTO `pwbb` (`ID`, `NOME`, `NICK`, `DATA_NASCIMENTO`, `CIDADE_NASCIMENTO`, `CIDADE_MORA`, `E_MAIL`, `COR_PREFERIDA`, `time`, `USA_OCULOS`, `SIGNO`) VALUES
(1, 'Abner', 'Mininin', '2007-07-24', 'Campinas', 'Sumaré', 'abner0135@gmail.com', 'Azul', 'Santos', 'S', 'Leão'),
(2, 'Lucas', 'Lucaix', '2007-11-25', 'Campinas', 'Hortolândia', 'lucasresendebg@gmail.com', '-', 'Santos', 'N', 'Sagitário'),
(3, 'Augustus', 'AKR100', '2007-02-13', 'Curitiba', 'Sumaré', 'augutuskrossi@gmail.com', '-', 'Santos', 'N', 'Aquário'),
(4, 'Emilly', 'Emilia', '1992-01-21', 'São Paulo', 'Hortolândia', 'vitoriaemily@gmail.com', 'Roxo', 'Flamengo', 'S', 'Aquário'),
(5, 'Gleice', 'Gleii', '2006-09-07', 'Hortolândia', 'Hortolândia', 'ribeirogleicielly341@gmail.com', 'Laranja', 'Santos', 'S', 'Virgem'),
(6, 'Ana Clara Martins', 'Ana', '2007-06-06', 'Teófilo-Otoni', 'Hortolândia', 'ana.luz@aluno.ifsp.edu.br', 'Verde Água', 'Corinthians', 'S', 'Gêmeos'),
(7, 'Giovanna', 'Vanna', '2008-04-02', 'Paulínia', 'Paulínia', 'vannadorne@gmail.com', 'Roxo', '-', 'N', 'Áries'),
(8, 'Gabrieli', 'gabs', '2008-04-22', 'Campinas', 'Sumaré', 'gabimsilva7@gmail.com', 'Pretin', 'São Paulo', 'N', 'Touro'),
(9, 'Yuri', 'yuri', '2008-05-22', 'Bom Retiro', 'Hortolândia', 'yuriRL908@gmail.com', 'Azul', 'Nenhum', 'S', 'Gêmos'),
(10, 'Eduarda', 'duda', '2007-08-23', 'Campinas', 'Hortolândia', 'e.verisSo@aluno.ifsp.edu.br', 'Roxo', 'São Paulo', 'S', 'Virgem'),
(11, 'Felipão', 'BONITAO', '2007-03-08', 'BOLIVIA', 'Sumaré', 'felipe.vqz@live.com', 'Purpura', 'Deus', 'N', 'Peixes'),
(12, 'Sabrina', 'Sab', '2007-08-22', 'Campinas', 'Hortolândia', 'faustinosab@gmail.com', 'Preto', '-', 'S', 'Leão'),
(13, 'Yago', 'lowlow', '2007-04-20', 'Campinas', 'Hortolândia', 'yagozague@gmail.com', 'Verde', 'Palmeiras', 'N', 'Áries'),
(14, 'Lais', 'lalalinda', '2007-12-29', 'Hortolandia', 'Sumaré', 'bonvicinelais@gmail.com', 'Preto', 'São Paulo', 'N', 'capricornio'),
(15, 'Matheus', 'Math', '2007-11-09', 'Socorro', 'Hortolândia', 'mpaes6537@gmail.com', 'Preto', 'Brasil', 'N', 'Escorpião'),
(16, 'Kevin', 'k3v1n', '2007-08-16', 'São Paulo', 'Sumaré', 'kreis0070@gmail.com', 'vermelho', 'Corinthians', 'N', 'Leão'),
(17, 'Raphael', 'RJ', '0000-00-00', 'São Gonçalo', 'Nova Odessa', 'raphadefa144@gmail.com', 'Azul', 'Vasco da Gama', 'N', 'Gêmeos'),
(18, 'Sthefany', 'Thety', '2007-07-15', 'Sumaré', 'Hortolândia', 'sthefanyrochalobo@gmail.com', 'Verde oliva', 'Santos', 'S', 'Câncer'),
(19, 'Isabelle', 'Isa', '2008-02-28', 'Campinas', 'Sumaré', 'isavorodrigues@gmail.com', 'Rosa', 'Palmeiras', 'S', 'Peixes'),
(20, 'Lorena', 'Lore', '2008-02-27', 'Campinas', 'Hortolândia', 'lorena.carl19@gmail.com', 'Verde', '-', 'N', 'Peixes');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pwbb`
--
ALTER TABLE `pwbb`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
