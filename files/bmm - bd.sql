create database bmm;
use bmm;

create table tipo_usuario(
cod_t_user varchar(15) primary key,
nome_t_user varchar(30) not null unique
);

create table usuario(
id_user int primary key auto_increment,
nome_user varchar(50) not null,
login_user varchar(25) not null unique,
senha_user varchar(8) not null,
ultima_modificacao datetime not null, 
cod_t_user varchar(15) not null,

constraint fk_cod_t_user foreign key (cod_t_user)
references tipo_usuario(cod_t_user)
);


create table ano (
ano smallint primary key
);

create table estado (
sigla_estado char(2) primary key,
nome_estado varchar(20) not null,
regiao_estado varchar(15) not null
);

create table bioma (
id_bioma tinyint primary key auto_increment, 
nome_bioma varchar(20) not null,
sigla_estado char(2) not null,

constraint fk_sigla_estado foreign key (sigla_estado)
references estado(sigla_estado)
);

create table desmatamento (
id_des smallint primary key auto_increment,
bioma_des varchar(20) not null,
ano_des smallint not null,
sigla_estado char(2) not null,
area_desmatada int not null,
ultima_modificacao date not null,
user_des varchar(50) not null,

constraint fk_sigla_estado_des foreign key (sigla_estado)
references estado(sigla_estado),

constraint fk_ano_des foreign key (ano_des)
references ano(ano)
);


