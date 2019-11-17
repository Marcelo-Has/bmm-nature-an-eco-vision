CREATE DATABASE `bmm`;
USE bmm;

CREATE TABLE `ano` (
  `ano` smallint(6) NOT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `bioma` (
  `id_bioma` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome_bioma` varchar(20) NOT NULL,
  `sigla_estado` char(2) NOT NULL,
  PRIMARY KEY (`id_bioma`),
  KEY `fk_sigla_estado` (`sigla_estado`),
  CONSTRAINT `fk_sigla_estado` FOREIGN KEY (`sigla_estado`) REFERENCES `estado` (`sigla_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

CREATE TABLE `desmatamento` (
  `id_des` smallint(6) NOT NULL AUTO_INCREMENT,
  `bioma_des` varchar(20) NOT NULL,
  `ano_des` smallint(6) NOT NULL,
  `sigla_estado` char(2) NOT NULL,
  `area_desmatada` int(11) NOT NULL,
  `ultima_modificacao` date NOT NULL,
  `user_des` varchar(50) NOT NULL,
  PRIMARY KEY (`id_des`),
  KEY `fk_sigla_estado_des` (`sigla_estado`),
  KEY `fk_ano_des` (`ano_des`),
  CONSTRAINT `fk_ano_des` FOREIGN KEY (`ano_des`) REFERENCES `ano` (`ano`),
  CONSTRAINT `fk_sigla_estado_des` FOREIGN KEY (`sigla_estado`) REFERENCES `estado` (`sigla_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=latin1;

CREATE TABLE `estado` (
  `sigla_estado` char(2) NOT NULL,
  `nome_estado` varchar(20) NOT NULL,
  `regiao_estado` varchar(15) NOT NULL,
  PRIMARY KEY (`sigla_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tipo_usuario` (
  `cod_t_user` varchar(15) NOT NULL,
  `nome_t_user` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_t_user`),
  UNIQUE KEY `nome_t_user` (`nome_t_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nome_user` varchar(50) NOT NULL,
  `login_user` varchar(25) NOT NULL,
  `senha_user` varchar(8) NOT NULL,
  `ultima_modificacao` datetime NOT NULL,
  `cod_t_user` varchar(15) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_user` (`login_user`),
  KEY `fk_cod_t_user` (`cod_t_user`),
  CONSTRAINT `fk_cod_t_user` FOREIGN KEY (`cod_t_user`) REFERENCES `tipo_usuario` (`cod_t_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

