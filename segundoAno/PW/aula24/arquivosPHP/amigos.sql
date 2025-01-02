-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Set-2024 às 20:06
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
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `USUARIO` varchar(10) NOT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `SENHA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pwba`
--

CREATE TABLE `pwba` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `NICK` varchar(20) DEFAULT NULL,
  `DATA_NASCIMENTO` varchar(20) DEFAULT NULL,
  `CIDADE_NASCIMENTO` varchar(20) DEFAULT NULL,
  `CIDADE_MORA` varchar(20) DEFAULT NULL,
  `E_MAIL` varchar(50) DEFAULT NULL,
  `COR_PREFERIDA` varchar(20) DEFAULT NULL,
  `TIME` varchar(20) DEFAULT NULL,
  `USA_OCULOS (S/N)` varchar(1) DEFAULT NULL,
  `SIGNO` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pwba`
--

INSERT INTO `pwba` (`ID`, `NOME`, `NICK`, `DATA_NASCIMENTO`, `CIDADE_NASCIMENTO`, `CIDADE_MORA`, `E_MAIL`, `COR_PREFERIDA`, `TIME`, `USA_OCULOS (S/N)`, `SIGNO`) VALUES
(1, 'matheus', 'matt', '19/12/2006', 'hortolandia', 'Hortolândia', 'msbastos006', 'preto', 'vasco', 'n', 'Sagitário'),
(2, 'Ana Clara S.', 'Nana', '01/10/2007', 'Campinas', 'Hortolândia', 'a.soaresabrantes@gmail.com', 'verde', 'São Paulo', 's', 'libra'),
(3, 'Daniel Meira da SIlva', 'Bom Dia', '12/12/2008', 'Campinas', 'Monte Mor', 'meiradaniel132@gmail.com', 'Laranja', 'Palmeiras', 's', 'Sagitário'),
(4, 'Leticia D', 'leh', '24/08/2007', 'São paulo', 'Hortolândia', 'le.delpino@gmail.com', 'Azul', 'Palmeiras', 'n', 'Virgem'),
(5, 'Gabriel Passarela Silva', 'passarela', '05/06/2007', 'Sao jorge do patroci', 'Hortolandia', 'gabrielpassarela7@gmail.com', 'vermelho', 'Santos', 'n', 'gemeos'),
(6, 'Eduarda M', 'duda', '09/05/2007', 'Nova lima-MG', 'Hortolandia', NULL, 'Lilas', 'Cruzeiro', 's', 'Touro'),
(7, 'Natanael M.', 'tael', '05/04/2005', 'Campinas', 'Hortolandia', 'natanaelfail@gmail.com', 'preto', 'Cruzeiro', 'n', 'corno'),
(8, 'Kauan Guerra', 'Kauan', '07/11/2007', 'Campinas', 'Hortolandia', 'kauanguerra@gmail.com', 'branco', 'Corinthians', 's', 'escorpiao'),
(9, 'Hiran Martins', 'h.matt', '17/01/2007', 'Campinas', 'Sumaré', 'hiran.m@aluno.ifsp.edu.br', 'vermelho', 'São Paulo', 'n', 'capricornio'),
(10, 'Ana Luiza', 'ana.alvezzz', '13/11/2007', 'Campinas', 'Hortolândia', 'annylumartins@gmail.com', 'rosa', 'Corinthians', 'S', 'escorpiao'),
(11, 'Larissa Lorayne', 'Luka', '26/10/2007', 'Campinas', 'Sumaré', 'llorayne@gmail.com', 'Roxo', 'Palmeiras', 's', NULL),
(12, 'Ana Clara V', 'ana', '20/03/2008', 'Campinas', 'Hortolândia', 'anaclaravalentin.ilv@gmail.com', 'Roxo', 'Corinthians', 'n', NULL),
(13, 'Pedro Luiz', 'Pedro Lima', '03/05/2008', 'Aguaí', 'Hortolândia', 'plmvfilho@gmail.com', 'roxo', 'vasco', 's', NULL),
(14, 'Victor hugo Ribeiro de Oliveira', 'vh', '29/04/2008', 'campinas', 'Hortolandia', 'vhugoribeirodeoliveira@gmail.com', 'azul', 'Palmeiras', 's', 'Escorpião'),
(15, 'João pedro rodrigues', 'Makonha', '04/10/2007', 'campinas', 'campinas', 'joao.rodrigay@gmail.com', 'roxo', 'santos', 's', 'Peixes');

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
  `SIGNO` varchar(30) DEFAULT NULL,
  `foto` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pwbb`
--

INSERT INTO `pwbb` (`ID`, `NOME`, `NICK`, `DATA_NASCIMENTO`, `CIDADE_NASCIMENTO`, `CIDADE_MORA`, `E_MAIL`, `COR_PREFERIDA`, `time`, `USA_OCULOS`, `SIGNO`, `foto`) VALUES
(1, 'Abner', 'Mininin', '2007-07-24', 'Campinas', 'Sumaré', 'abner0135@gmail.com', 'Azul', 'Santos', 'S', 'Leão', NULL),
(2, 'Lucas', 'Lucaix', '2007-11-25', 'Campinas', 'Hortolândia', 'lucasresendebg@gmail.com', '-', 'Santos', 'N', 'Sagitário', NULL),
(3, 'Augustus', 'AKR100', '2007-02-13', 'Curitiba', 'Sumaré', 'augutuskrossi@gmail.com', '-', 'Santos', 'N', 'Aquário', NULL),
(4, 'Emilly', 'Emilia', '1992-01-21', 'São Paulo', 'Hortolândia', 'vitoriaemily@gmail.com', 'Roxo', 'Flamengo', 'S', 'Aquário', NULL),
(5, 'Gleice', 'Gleii', '2006-09-07', 'Hortolândia', 'Hortolândia', 'ribeirogleicielly341@gmail.com', 'Laranja', 'Santos', 'S', 'Virgem', NULL),
(6, 'Ana Clara Martins', 'Ana', '2007-06-06', 'Teófilo-Otoni', 'Hortolândia', 'ana.luz@aluno.ifsp.edu.br', 'Verde Água', 'Corinthians', 'S', 'Gêmeos', NULL),
(7, 'Giovanna', 'Vanna', '2008-04-02', 'Paulínia', 'Paulínia', 'vannadorne@gmail.com', 'Roxo', '-', 'N', 'Áries', NULL),
(8, 'Gabrieli', 'gabs', '2008-04-22', 'Campinas', 'Sumaré', 'gabimsilva7@gmail.com', 'Pretin', 'São Paulo', 'N', 'Touro', NULL),
(9, 'Yuri', 'yuri', '2008-05-22', 'Bom Retiro', 'Hortolândia', 'yuriRL908@gmail.com', 'Azul', 'Nenhum', 'S', 'Gêmos', NULL),
(10, 'Eduarda', 'duda', '2007-08-23', 'Campinas', 'Hortolândia', 'e.verisSo@aluno.ifsp.edu.br', 'Roxo', 'São Paulo', 'S', 'Virgem', NULL),
(11, 'Felipão', 'BONITAO', '2007-03-08', 'BOLIVIA', 'Sumaré', 'felipe.vqz@live.com', 'Purpura', 'Deus', 'N', 'Peixes', NULL),
(12, 'Sabrina', 'Sab', '2007-08-22', 'Campinas', 'Hortolândia', 'faustinosab@gmail.com', 'Preto', '-', 'S', 'Leão', NULL),
(13, 'Yago', 'lowlow', '2007-04-20', 'Campinas', 'Hortolândia', 'yagozague@gmail.com', 'Verde', 'Palmeiras', 'N', 'Áries', NULL),
(14, 'Lais', 'lalalinda', '2007-12-29', 'Hortolandia', 'Sumaré', 'bonvicinelais@gmail.com', 'Preto', 'São Paulo', 'N', 'capricornio', NULL),
(15, 'Matheus', 'Math', '2007-11-09', 'Socorro', 'Hortolândia', 'mpaes6537@gmail.com', 'Preto', 'Brasil', 'N', 'Escorpião', NULL),
(16, 'Kevin', 'k3v1n', '2007-08-16', 'São Paulo', 'Sumaré', 'kreis0070@gmail.com', 'vermelho', 'Corinthians', 'N', 'Leão', NULL),
(17, 'Raphael', 'RJ', '0000-00-00', 'São Gonçalo', 'Nova Odessa', 'raphadefa144@gmail.com', 'Azul', 'Vasco da Gama', 'N', 'Gêmeos', NULL),
(18, 'Sthefany', 'Thety', '2007-07-15', 'Sumaré', 'Hortolândia', 'sthefanyrochalobo@gmail.com', 'Verde oliva', 'Santos', 'S', 'Câncer', NULL),
(19, 'Isabelle', 'Isa', '2008-02-28', 'Campinas', 'Sumaré', 'isavorodrigues@gmail.com', 'Rosa', 'Palmeiras', 'S', 'Peixes', NULL),
(20, 'Lorena', 'Lore', '2008-02-27', 'Campinas', 'Hortolândia', 'lorena.carl19@gmail.com', 'Verde', '-', 'N', 'Peixes', NULL),
(23, 'Julio', 'Cocorico', '2015-03-04', 'Indefinido', 'Indefinido', 'julio@gmail.com', 'Azul', 'Corintinhans', 'N', 'Leão', 0x6a756c696f4361726563612e6a666966);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`USUARIO`);

--
-- Índices para tabela `pwba`
--
ALTER TABLE `pwba`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `pwbb`
--
ALTER TABLE `pwbb`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
