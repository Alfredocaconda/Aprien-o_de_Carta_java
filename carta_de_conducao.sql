-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Mar-2023 às 10:45
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `carta_de_conducao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agente_regulador`
--

CREATE TABLE `agente_regulador` (
  `id_agente` int(11) NOT NULL,
  `id_policia` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `nip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `agente_regulador`
--

INSERT INTO `agente_regulador` (`id_agente`, `id_policia`, `nome`, `nip`) VALUES
(1, 1, 'PROGRAMADORA', 1234),
(2, 1, 'TIAGO', 7895634);

-- --------------------------------------------------------

--
-- Estrutura da tabela `automobilista`
--

CREATE TABLE `automobilista` (
  `id_automobilista` int(11) NOT NULL,
  `idpolicia` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone_gmail` varchar(100) NOT NULL,
  `n_carta` varchar(100) NOT NULL,
  `data_emissao` date NOT NULL,
  `data_caducidade` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `automobilista`
--

INSERT INTO `automobilista` (`id_automobilista`, `idpolicia`, `nome`, `endereco`, `telefone_gmail`, `n_carta`, `data_emissao`, `data_caducidade`) VALUES
(1, 1, 'PROGRAMADOR', 'BENGUELA', 'PROGRAMADOR@GMAIL.COM', 'BA12211', '2022-12-12', '2024-12-12'),
(3, 1, 'TIAGO DOMIGAS', 'SACADURA CABRAL', '98764578', '465312978', '2022-02-02', '2028-02-02'),
(4, 1, 'ALFREDO PABLO', 'SACADURA CABRAL', '95485265', '9638527', '2022-03-21', '2029-01-01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `infracao`
--

CREATE TABLE `infracao` (
  `idin` int(11) NOT NULL,
  `idpolicia` int(11) NOT NULL,
  `id_automobilista` int(11) NOT NULL,
  `idagente` int(11) NOT NULL,
  `infracao` varchar(100) NOT NULL,
  `data_da_atuacao` date NOT NULL,
  `disciplina_rodoviaria` varchar(100) NOT NULL,
  `local_de_atuacao` varchar(100) NOT NULL,
  `estado_de_pagamento` enum('pago','não pago') DEFAULT NULL,
  `multa` varchar(200) DEFAULT '0',
  `data_do_pagamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `infracao`
--

INSERT INTO `infracao` (`idin`, `idpolicia`, `id_automobilista`, `idagente`, `infracao`, `data_da_atuacao`, `disciplina_rodoviaria`, `local_de_atuacao`, `estado_de_pagamento`, `multa`, `data_do_pagamento`) VALUES
(1, 1, 1, 1, 'CARTA EXPIRADA', '2022-12-16', 'EXCESSO DE VELOCIDADE', 'BENGUELA', 'pago', '1', '2023-03-24'),
(2, 1, 1, 1, 'cartaaas', '2022-12-16', 'VELOCIDADE', 'BENGUELA', 'pago', '3540', '2023-03-25'),
(7, 1, 3, 1, 'teste', '2023-03-03', 'asdfas', 'BENGUELA', 'pago', '20', '2023-03-25'),
(8, 1, 3, 1, 'her adl adlfa açszldfk asdzlfk.vsa dzfçvialskfd vas xgavsçxlfkgvj szxdlfv sdzfxlgkv f', '2023-02-03', 'er esdrxfg.lv. wesrx-ldtfg vewsdxfkg vesdxfgpçesrldf', 'BOCOIO', 'pago', '1000', '2023-03-25'),
(15, 1, 1, 1, 'CARTA EXPIRADA', '2022-12-16', 'EXCESSO DE VELOCIDADE', 'BENGUELA', 'pago', '1000', '2023-03-23'),
(17, 1, 4, 2, 'NAO SEI', '2023-03-08', 'NEIM ', 'BOCOIO', 'pago', '3000', '2023-03-25'),
(18, 1, 4, 1, 'ESCD LK', '2023-03-22', 'GWERFDGEREDF', 'BENGUELA', 'não pago', '5000', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `policia`
--

CREATE TABLE `policia` (
  `idpolicia` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `genero` enum('masculino','femenino') NOT NULL,
  `nip` int(11) NOT NULL,
  `nome_do_pai` varchar(100) NOT NULL,
  `nome_da_mae` varchar(100) NOT NULL,
  `bi` varchar(100) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `categoria` enum('comandante','agente') NOT NULL,
  `telefone_email` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `policia`
--

INSERT INTO `policia` (`idpolicia`, `nome`, `genero`, `nip`, `nome_do_pai`, `nome_da_mae`, `bi`, `municipio`, `provincia`, `categoria`, `telefone_email`, `usuario`, `senha`) VALUES
(1, 'programador', 'masculino', 12345, 'programador', 'programadora', '12345432344412', 'BENGUELA', 'BENGUELA', 'comandante', '12345432343', 'PROGRAMADOR', 'PROGRAMADOR');

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vinfracao`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `vinfracao` (
`idin` int(11)
,`automobilista` varchar(100)
,`endereco` varchar(100)
,`n_carta` varchar(100)
,`telefone_gmail` varchar(100)
,`data_caducidade` date
,`agente` varchar(100)
,`nip` int(11)
,`infracao` varchar(100)
,`data_da_atuacao` date
,`disciplina_rodoviaria` varchar(100)
,`local_de_atuacao` varchar(100)
,`estado_de_pagamento` enum('pago','não pago')
,`multa` varchar(200)
,`data_do_pagamento` date
,`policia` varchar(100)
);

-- --------------------------------------------------------

--
-- Estrutura para vista `vinfracao`
--
DROP TABLE IF EXISTS `vinfracao`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vinfracao`  AS SELECT `i`.`idin` AS `idin`, `a`.`nome` AS `automobilista`, `a`.`endereco` AS `endereco`, `a`.`n_carta` AS `n_carta`, `a`.`telefone_gmail` AS `telefone_gmail`, `a`.`data_caducidade` AS `data_caducidade`, `ag`.`nome` AS `agente`, `ag`.`nip` AS `nip`, `i`.`infracao` AS `infracao`, `i`.`data_da_atuacao` AS `data_da_atuacao`, `i`.`disciplina_rodoviaria` AS `disciplina_rodoviaria`, `i`.`local_de_atuacao` AS `local_de_atuacao`, `i`.`estado_de_pagamento` AS `estado_de_pagamento`, `i`.`multa` AS `multa`, `i`.`data_do_pagamento` AS `data_do_pagamento`, `p`.`nome` AS `policia` FROM (((`infracao` `i` join `automobilista` `a` on(`a`.`id_automobilista` = `i`.`id_automobilista`)) join `agente_regulador` `ag` on(`ag`.`id_agente` = `i`.`idagente`)) join `policia` `p` on(`p`.`idpolicia` = `i`.`idpolicia`))  ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agente_regulador`
--
ALTER TABLE `agente_regulador`
  ADD PRIMARY KEY (`id_agente`),
  ADD KEY `id_policia` (`id_policia`);

--
-- Índices para tabela `automobilista`
--
ALTER TABLE `automobilista`
  ADD PRIMARY KEY (`id_automobilista`),
  ADD KEY `idpolicia` (`idpolicia`);

--
-- Índices para tabela `infracao`
--
ALTER TABLE `infracao`
  ADD PRIMARY KEY (`idin`),
  ADD KEY `idpolicia` (`idpolicia`),
  ADD KEY `id_automobilista` (`id_automobilista`),
  ADD KEY `idagente` (`idagente`);

--
-- Índices para tabela `policia`
--
ALTER TABLE `policia`
  ADD PRIMARY KEY (`idpolicia`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agente_regulador`
--
ALTER TABLE `agente_regulador`
  MODIFY `id_agente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `automobilista`
--
ALTER TABLE `automobilista`
  MODIFY `id_automobilista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `infracao`
--
ALTER TABLE `infracao`
  MODIFY `idin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de tabela `policia`
--
ALTER TABLE `policia`
  MODIFY `idpolicia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `agente_regulador`
--
ALTER TABLE `agente_regulador`
  ADD CONSTRAINT `agente_regulador_ibfk_1` FOREIGN KEY (`id_policia`) REFERENCES `policia` (`idpolicia`);

--
-- Limitadores para a tabela `automobilista`
--
ALTER TABLE `automobilista`
  ADD CONSTRAINT `automobilista_ibfk_1` FOREIGN KEY (`idpolicia`) REFERENCES `policia` (`idpolicia`);

--
-- Limitadores para a tabela `infracao`
--
ALTER TABLE `infracao`
  ADD CONSTRAINT `infracao_ibfk_1` FOREIGN KEY (`idpolicia`) REFERENCES `policia` (`idpolicia`),
  ADD CONSTRAINT `infracao_ibfk_2` FOREIGN KEY (`id_automobilista`) REFERENCES `automobilista` (`id_automobilista`),
  ADD CONSTRAINT `infracao_ibfk_3` FOREIGN KEY (`idagente`) REFERENCES `agente_regulador` (`id_agente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
