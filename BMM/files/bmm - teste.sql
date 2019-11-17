use bmm;
select * from desmatamento;
insert into usuario (nome_user, login_user, senha_user, cod_t_user) values ("user", "user", "user", 111);

select * from tipo_usuario;
insert into tipo_usuario values(111, "user");



create table ano (
ano smallint primary key
);

create table estado (
sigla_estado char(2) primary key,
nome_estado varchar(20) not null,
regiao_estado varchar(15) not null
);

drop table estado;

drop table tipo_usuario;

create table bioma (
id_bioma tinyint primary key auto_increment, 
nome_bioma varchar(20) not null,
sigla_estado char(2) not null,

constraint fk_sigla_estado foreign key (sigla_estado)
references estado(sigla_estado)
);

drop table bioma;

insert into ano values(2000);
insert into ano values(2001);
insert into ano values(2002);
insert into ano values(2003);
insert into ano values(2004);
insert into ano values(2005);
insert into ano values(2006);
insert into ano values(2007);
insert into ano values(2008);
insert into ano values(2009);
insert into ano values(2010);
insert into ano values(2011);
insert into ano values(2012);
insert into ano values(2013);
insert into ano values(2014);
insert into ano values(2015);
insert into ano values(2016);
insert into ano values(2017);
insert into ano values(2018);
insert into ano values(2019);
insert into ano values(2020);
insert into ano values(2021);
insert into ano values(2022);
insert into ano values(2023);
insert into ano values(2024);
insert into ano values(2025);
insert into ano values(2026);
insert into ano values(2027);
insert into ano values(2028);
insert into ano values(2029);
insert into ano values(2030);

use bmm;
select * from estado;

insert into bioma(nome_bioma, sigla_estado) values("Amazônia","AC");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","AM");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","AP");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","MA");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","MT");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","PA");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","RO");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","RR");
insert into bioma(nome_bioma, sigla_estado) values("Amazônia","TO");

insert into bioma(nome_bioma, sigla_estado) values("Caatinga","AL");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","BA");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","CE");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","MG");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","PB");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","PE");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","PI");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","RN");
insert into bioma(nome_bioma, sigla_estado) values("Caatinga","SE");

insert into bioma(nome_bioma, sigla_estado) values("Cerrado","BA");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","GO");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","MA");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","MG");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","MS");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","MT");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","PI");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","PR");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","SP");
insert into bioma(nome_bioma, sigla_estado) values("Cerrado","TO");

insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","AL");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","BA");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","ES");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","GO");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","MG");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","MS");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","PB");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","PE");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","PR");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","RJ");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","RN");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","RS");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","SC");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","SE");
insert into bioma(nome_bioma, sigla_estado) values("Mata Atlântica","SP");

insert into bioma(nome_bioma, sigla_estado) values("Pampa","RS");

insert into bioma(nome_bioma, sigla_estado) values("Pantanal","MT");
insert into bioma(nome_bioma, sigla_estado) values("Pantanal","MS");


insert into estado values("AC", "Acre", "Norte");
insert into estado values("AL", "Alagoas", "Nordeste");
insert into estado values("AP", "Amapá", "Norte");
insert into estado values("AM", "Amazonas", "Norte");
insert into estado values("BA", "Bahia", "Nordeste");
insert into estado values("CE", "Ceará", "Nordeste");
insert into estado values("ES", "Espírito Santo", "Sudeste");
insert into estado values("GO", "Goiás", "Centro-Oeste");
insert into estado values("MA", "Maranhão", "Nordeste");
insert into estado values("MT", "Mato Grosso", "Centro-Oeste");
insert into estado values("MS", "Mato Grosso do Sul", "Centro-Oeste");
insert into estado values("MG", "Minas Gerais", "Sudeste");
insert into estado values("PA", "Pará", "Norte");
insert into estado values("PB", "Paraíba", "Nordeste");
insert into estado values("PR", "Paraná", "Sul");
insert into estado values("PE", "Pernambuco", "Nordeste");
insert into estado values("PI", "Piauí", "Nordeste");
insert into estado values("RJ", "Rio de Janeiro", "Sudeste");
insert into estado values("RN", "Rio Grande do Norte", "Nordeste");
insert into estado values("RS", "Rio Grande do Sul", "Sul");
insert into estado values("RO", "Rondônia", "Norte");
insert into estado values("RR", "Roraima", "Norte");
insert into estado values("SC", "Santa Catarina", "Sul");
insert into estado values("SP", "São Paulo", "Sudeste");
insert into estado values("SE", "Sergipe", "Nordeste");
insert into estado values("TO", "Tocantins", "Norte");

select * from bioma;

update estado
set sigla_estado = "AP" where sigla_estado = "Ap";

create table tipo_usuario(
cod_t_user varchar(15) primary key,
nome_t_user varchar(30) not null unique
);

insert into tipo_usuario values("admin", "admin");
insert into tipo_usuario values("bmm-comum2019", "comum");

create table usuario(
id_user int primary key auto_increment,
nome_user varchar(50) not null,
login_user varchar(25) not null unique,
senha_user varchar(25) not null,
ultima_modificacao date not null, 
cod_t_user varchar(15) not null,

constraint fk_cod_t_user foreign key (cod_t_user)
references tipo_usuario(cod_t_user)
);

drop table usuario;

insert into usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) values("Marcelo", "celo", "celo", curdate(), "admin");
insert into usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) values("comum", "comum", "comum", curdate(), "bmm-comum2019");


SELECT * FROM usuario as u INNER JOIN tipo_usuario as tu ON (u.cod_t_user = tu.cod_t_user);

select * from usuario;

SELECT u.id_user, u.nome_user, u.login_user, u.senha_user, tu.cod_t_user, tu.nome_t_user, DATE_FORMAT(ultima_modificacao, '%d/%m/%Y') as data FROM usuario AS u INNER JOIN tipo_usuario AS tu ON (u.cod_t_user = tu.cod_t_user);

create table desmatamento (
id_des smallint primary key auto_increment,
bioma_des varchar(20) not null,
ano_des smallint not null,
sigla_estado char(2) not null,
area_desmatada int not null,
ultima_modificacao date not null, 

constraint fk_sigla_estado_des foreign key (sigla_estado)
references estado(sigla_estado)
);

drop table desmatamento;

SELECT *, DATE_FORMAT(ultima_modificacao, '%d/%m/%Y') as data FROM desmatamento;
insert into usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) values("teste", "celo", "celo", DATE_FORMAT(curdate(), '%d/%m/%Y'), "admin");

SELECT * from bioma;


SELECT *, DATE_FORMAT(ultima_modificacao, '%d/%m/%Y') AS data FROM desmatamento;

SELECT e.sigla_estado, e.nome_estado FROM estado AS e INNER JOIN desmatamento AS d ON (e.sigla_estado = d.sigla_estado) WHERE d.id_des = 1;

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "RR", 4509, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "RR", 15064, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "RR", 14001, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "RR", 266, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "RR", 10025, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "RR", 12398, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "RR", 7649, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "RR", 4855, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "RR", 7363, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "RR", 9724, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "RR", 10867, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "RR", 5771, curdate(), "admin");

SELECT * FROM bioma WHERE nome_bioma = "Cerrado";

SELECT SUM(area_desmatada) area, ano_des FROM desmatamento WHERE sigla_estado = "rr" GROUP BY ano_des;