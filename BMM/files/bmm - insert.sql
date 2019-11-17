use bmm;

insert into tipo_usuario values("admin", "admin");
insert into tipo_usuario values("bmm-comum2019", "comum");

insert into usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) values("admin", "admin", "admin", curdate(), "admin");
insert into usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) values("comum", "comum", "comum", curdate(), "bmm-comum2019");

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


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "BA", 2120, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "MT", 3450, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "GO", 3456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "MA", 2340, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "MG", 5678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "MS", 3456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "PI", 4568, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "PR", 2345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "TO", 1256, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2000, "SP", 3450, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "BA", 2288, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "MT", 5346, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "GO", 6612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "MA", 2302, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "MG", 6466, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "MS", 2827, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "PI", 3456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "PR", 3156, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "TO", 4315, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2001, "SP", 3678, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "BA", 2155, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "MT", 5346, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "GO", 6612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "MA", 2302, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "MG", 6466, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "MS", 2827, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "PI", 2113, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "PR", 2456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "TO", 4211, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2002, "SP", 3690, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "BA", 2713, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "MT", 5975, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "GO", 6217, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "MA", 2406, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "MG", 4777, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "MS", 2367, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "PI", 5142, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "PR", 5612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "TO", 6512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2003, "SP", 7612, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "BA", 2713, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "MT", 5975, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "GO", 6217, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "MA", 2406, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "MG", 4777, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "MS", 2367, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "PI", 1235, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "PR", 6123, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "TO", 6512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2004, "SP", 2451, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "BA", 1806, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "MT", 2769, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "GO", 2465, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "MA", 2315, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "MG", 2807, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "MS", 1593, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "PI", 1456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "PR", 1781, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "TO", 1672, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2005, "SP", 2413, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "BA", 1806, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "MT", 2769, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "GO", 2465, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "MA", 2315, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "MG", 2807, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "MS", 1593, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "PI", 2671, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "PR", 3211, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "TO", 2341, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2006, "SP", 5412, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "BA", 2019, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "MT", 2135, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "GO", 1498, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "MA", 3813, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "MG", 2159, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "MS", 790, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "PI", 1002, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "PR", 2105, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "TO", 3211, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2007, "SP", 1200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "BA", 2019, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "MT", 2135, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "GO", 1498, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "MA", 3813, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "MG", 2159, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "MS", 790, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "PI", 2341, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "PR", 1222, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "TO", 1443, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2008, "SP", 1233, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "BA", 1211, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "MT", 1002, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "GO", 1415, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "MA", 1756, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "MG", 1358, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "MS", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "PI", 1234, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "PR", 1345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "TO", 3456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2009, "SP", 2312, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "BA", 1211, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "MT", 1002, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "GO", 1415, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "MA", 1756, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "MG", 1358, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "MS", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "PI", 1367, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "PR", 1390, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "TO", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2010, "SP", 1567, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "BA", 1519, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "MT", 1028, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "GO", 957, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "MA", 1427, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "MG", 1465, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "MS", 392, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "PI", 1278, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "PR", 1389, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "TO", 1345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2011, "SP", 1156, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "BA", 1519, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "MT", 1028, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "GO", 957, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "MA", 1427, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "MG", 1465, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "MS", 392, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "PI", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "PR", 998, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "TO", 986, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2012, "SP", 1003, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "BA", 1649, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "MT", 1891, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "GO", 1923, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "MA", 1648, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "MG", 2232, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "MS", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "PI", 1034, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "PR", 1246, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "TO", 1006, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2013, "SP", 1290, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "BA", 1071, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "MT", 1007, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "GO", 1185, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "MA", 1840, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "MG", 1966, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "MS", 281, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "PI", 1087, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "PR", 1034, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "TO", 1023, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2014, "SP", 1032, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "BA", 1343, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "MT", 1745, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "GO", 1240, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "MA", 1750, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "MG", 1240, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "MS", 632, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "PI", 1231, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "PR", 1247, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "TO", 1345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2015, "SP", 1290, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "BA", 781, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "MT", 1176, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "GO", 647, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "MA", 1209, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "MG", 329, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "MS", 337, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "PI", 1290, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "PR", 1267, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "TO", 1007, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2016, "SP", 1200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "BA", 783, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "MT", 1252, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "GO", 842, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "MA", 1486, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "MG", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "MS", 285, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "PI", 599, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "PR", 2500, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "TO", 1699, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2017, "SP", 200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "BA", 697, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "MT", 1001, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "GO", 713, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "MA", 1472, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "MG", 473, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "MS", 258, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "PI", 483, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "PR", 600, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "TO", 1533, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Cerrado", 2018, "SP", 146, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "AL", 600, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "BA", 1985, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "ES", 1000, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "GO", 289, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "MG", 3379, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "MS", 140, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "PB", 330, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "PE", 900, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "PR", 2049, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "RJ", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "RN", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "RS", 1003, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "SC", 1006, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "SE", 988, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2000, "SP", 765, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "AL", 650, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "BA", 1885, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "ES", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "GO", 299, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "MG", 3579, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "MS", 170, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "PB", 380, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "PE", 980, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "PR", 2149, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "RJ", 590, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "RN", 830, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "RS", 1303, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "SC", 1106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "SE", 978, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2001, "SP", 795, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "AL", 589, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "BA", 1988, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "ES", 1012, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "GO", 267, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "MG", 3345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "MS", 178, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "PB", 312, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "PE", 989, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "PR", 2129, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "RJ", 589, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "RN", 865, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "RS", 1123, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "SC", 1456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "SE", 999, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2002, "SP", 721, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "AL", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "BA", 1125, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "ES", 1120, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "GO", 265, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "MG", 2239, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "MS", 200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "PB", 290, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "PE", 876, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "PR", 1999, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "RJ", 821, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "RN", 900, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "RS", 1343, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "SC", 1216, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "SE", 966, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2003, "SP", 711, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "AL", 603, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "BA", 1975, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "ES", 1010, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "GO", 280, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "MG", 3329, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "MS", 146, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "PB", 331, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "PE", 905, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "PR", 2039, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "RJ", 568, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "RN", 871, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "RS", 1083, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "SC", 1096, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "SE", 980, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2004, "SP", 762, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "AL", 609, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "BA", 1125, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "ES", 1060, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "GO", 267, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "MG", 3129, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "MS", 178, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "PB", 332, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "PE", 989, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "PR", 2239, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "RJ", 576, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "RN", 854, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "RS", 1003, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "SC", 1046, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "SE", 934, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2005, "SP", 723, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "AL", 612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "BA", 1455, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "ES", 1780, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "GO", 299, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "MG", 3219, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "MS", 140, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "PB", 339, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "PE", 909, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "PR", 2089, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "RJ", 566, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "RN", 874, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "RS", 1033, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "SC", 1026, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "SE", 981, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2006, "SP", 762, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "AL", 620, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "BA", 1785, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "ES", 1100, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "GO", 229, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "MG", 3379, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "MS", 140, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "PB", 350, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "PE", 960, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "PR", 2749, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "RJ", 580, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "RN", 879, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "RS", 1093, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "SC", 1096, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "SE", 938, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2007, "SP", 785, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "AL", 500, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "BA", 2185, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "ES", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "GO", 309, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "MG", 2979, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "MS", 150, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "PB", 290, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "PE", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "PR", 1949, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "RJ", 490, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "RN", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "RS", 1203, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "SC", 1106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "SE", 968, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2008, "SP", 715, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "AL", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "BA", 1885, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "ES", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "GO", 269, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "MG", 3779, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "MS", 150, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "PB", 330, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "PE", 920, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "PR", 2149, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "RJ", 590, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "RN", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "RS", 1303, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "SC", 1206, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "SE", 998, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2009, "SP", 705, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "AL", 605, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "BA", 1125, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "ES", 1560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "GO", 221, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "MG", 2569, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "MS", 230, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "PB", 289, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "PE", 867, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "PR", 1999, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "RJ", 578, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "RN", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "RS", 1103, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "SC", 1206, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "SE", 990, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2010, "SP", 678, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "AL", 670, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "BA", 1285, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "ES", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "GO", 239, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "MG", 3879, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "MS", 190, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "PB", 310, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "PE", 910, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "PR", 2149, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "RJ", 570, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "RN", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "RS", 1203, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "SC", 1206, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "SE", 948, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2011, "SP", 715, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "AL", 790, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "BA", 1285, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "ES", 1300, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "GO", 179, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "MG", 2979, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "MS", 160, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "PB", 210, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "PE", 890, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "PR", 1249, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "RJ", 340, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "RN", 760, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "RS", 1203, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "SC", 1106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "SE", 768, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2012, "SP", 895, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "AL", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "BA", 1285, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "ES", 1300, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "GO", 329, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "MG", 2179, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "MS", 230, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "PB", 450, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "PE", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "PR", 1949, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "RJ", 670, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "RN", 980, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "RS", 2703, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "SC", 1006, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "SE", 1008, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2013, "SP", 565, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "AL", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "BA", 1965, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "ES", 1200, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "GO", 269, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "MG", 3679, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "MS", 160, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "PB", 320, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "PE", 910, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "PR", 2249, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "RJ", 520, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "RN", 820, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "RS", 1103, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "SC", 1106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "SE", 948, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2014, "SP", 785, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "AL", 600, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "BA", 1985, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "ES", 1000, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "GO", 289, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "MG", 3379, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "MS", 140, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "PB", 330, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "PE", 900, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "PR", 2049, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "RJ", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "RN", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "RS", 1003, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "SC", 1006, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "SE", 988, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2015, "SP", 765, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "AL", 600, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "BA", 4050, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "ES", 1000, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "GO", 165, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "MG", 3128, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "MS", 116, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "PB", 330, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "PE", 900, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "PR", 1643, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "RJ", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "RN", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "RS", 951, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "SC", 595, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "SE", 340, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2016, "SP", 763, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "AL", 800, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "BA", 1985, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "ES", 1000, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "GO", 289, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "MG", 3379, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "MS", 140, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "PB", 330, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "PE", 900, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "PR", 2049, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "RJ", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "RN", 870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "RS", 1003, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "SC", 1006, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "SE", 988, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2017, "SP", 765, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "AL", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "BA", 1885, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "ES", 1100, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "GO", 299, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "MG", 3279, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "MS", 150, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "PB", 340, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "PE", 910, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "PR", 2149, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "RJ", 550, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "RN", 860, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "RS", 1103, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "SC", 1106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "SE", 978, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Mata Atlântica", 2018, "SP", 725, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "AL", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "BA", 567, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "CE", 654, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "MG", 638, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "PE", 614, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "PI", 648, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "RN", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2000, "SE", 694, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "AL", 578, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "BA", 467, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "CE", 454, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "MG", 738, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "PB", 317, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "PE", 914, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "PI", 948, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "RN", 717, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2001, "SE", 794, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "AL", 568, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "BA", 577, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "CE", 644, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "MG", 628, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "PB", 527, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "PE", 624, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "PI", 768, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "RN", 547, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2002, "SE", 784, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "AL", 674, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "BA", 561, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "CE", 651, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "MG", 632, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "PB", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "PE", 617, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "PI", 647, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "RN", 510, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2003, "SE", 690, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "AL", 612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "BA", 523, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "CE", 634, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "MG", 645, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "PE", 614, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "PI", 642, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "RN", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2004, "SE", 613, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "AL", 765, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "BA", 654, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "CE", 764, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "MG", 654, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "PB", 523, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "PE", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "PI", 612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "RN", 589, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2005, "SE", 623, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "AL", 541, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "BA", 761, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "CE", 981, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "MG", 761, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "PB", 821, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "PE", 812, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "PI", 431, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "RN", 456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2006, "SE", 651, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "AL", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "BA", 567, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "CE", 754, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "MG", 738, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "PB", 617, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "PE", 514, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "PI", 748, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "RN", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2007, "SE", 594, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "AL", 548, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "BA", 567, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "CE", 614, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "MG", 618, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "PB", 717, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "PE", 514, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "PI", 548, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "RN", 657, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2008, "SE", 764, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "AL", 550, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "BA", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "CE", 543, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "MG", 765, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "PE", 560, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "PI", 432, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "RN", 812, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2009, "SE", 987, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "AL", 679, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "BA", 567, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "CE", 659, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "MG", 639, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "PB", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "PE", 611, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "PI", 641, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "RN", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2010, "SE", 692, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "AL", 612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "BA", 521, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "CE", 634, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "MG", 643, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "PE", 667, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "PI", 621, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "RN", 589, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2011, "SE", 664, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "AL", 778, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "BA", 767, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "CE", 554, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "MG", 538, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "PE", 414, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "PI", 448, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "RN", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2012, "SE", 994, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "AL", 612, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "BA", 578, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "CE", 643, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "MG", 621, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "PB", 512, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "PE", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "PI", 643, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "RN", 556, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2013, "SE", 690, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "AL", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "BA", 567, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "CE", 654, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "MG", 638, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "PB", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "PE", 614, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "PI", 648, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "RN", 517, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2014, "SE", 694, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "AL", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "BA", 577, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "CE", 614, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "MG", 628, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "PB", 537, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "PE", 654, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "PI", 688, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "RN", 587, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2015, "SE", 634, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "AL", 432, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "BA", 438, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "CE", 589, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "MG", 670, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "PB", 621, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "PE", 760, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "PI", 543, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "RN", 678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2016, "SE", 911, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "AL", 720, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "BA", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "CE", 604, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "MG", 590, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "PB", 598, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "PE", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "PI", 599, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "RN", 600, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2017, "SE", 687, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "AL", 578, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "BA", 467, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "CE", 554, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "MG", 438, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "PB", 417, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "PE", 514, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "PI", 548, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "RN", 617, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Caatinga", 2018, "SE", 494, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2000, "RS", 1100, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2001, "RS", 1101, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2002, "RS", 890, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2003, "RS", 1200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2004, "RS", 1120, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2005, "RS", 980, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2006, "RS", 789, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2007, "RS", 1500, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2008, "RS", 2345, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2009, "RS", 2300, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2010, "RS", 1899, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2011, "RS", 567, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2012, "RS", 1290, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2013, "RS", 1234, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2014, "RS", 1456, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2015, "RS", 1345, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2016, "RS", 1200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2017, "RS", 2347, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pampa", 2018, "RS", 1156, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2000, "MT", 345, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2000, "MS", 368, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2001, "MT", 456, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2001, "MS", 224, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2002, "MT", 234, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2002, "MS", 329, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2003, "MT", 238, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2003, "MS", 542, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2004, "MT", 148, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2004, "MS", 308, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2005, "MT", 390, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2005, "MS", 280, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2006, "MT", 321, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2006, "MS", 368, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2007, "MT", 478, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2007, "MS", 412, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2008, "MT", 319, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2008, "MS", 356, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2009, "MT", 124, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2009, "MS", 443, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2010, "MT", 578, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2010, "MS", 211, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2011, "MT", 256, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2011, "MS", 200, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2012, "MT", 657, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2012, "MS", 112, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2013, "MT", 650, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2013, "MS", 550, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2014, "MT", 534, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2014, "MS", 245, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2015, "MT", 245, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2015, "MS", 889, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2016, "MT", 214, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2016, "MS", 766, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2017, "MT", 325, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2017, "MS", 1275, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2018, "MT", 441, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Pantanal", 2018, "MS", 539, curdate(), "admin");




INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "AC", 117, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "AM", 125, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "AP", 125, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "MA", 363, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "MT", 106, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "PA", 245, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "RO", 296, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "RR", 197, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2000, "TO", 349, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "AC", 137, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "AM", 155, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "AP", 185, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "MA", 423, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "MT", 136, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "PA", 275, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "RO", 346, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "RR", 218, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2001, "TO", 378, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "AC", 153, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "AM", 175, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "AP", 215, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "MA", 450, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "MT", 158, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "PA", 325, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "RO", 365, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "RR", 235, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2002, "TO", 389, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "AC", 175, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "AM", 156, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "AP", 258, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "MA", 480, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "MT", 176, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "PA", 315, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "RO", 250, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "RR", 226, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2003, "TO", 369, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "AC", 728, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "AM", 1232, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "AP", 46, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "MA", 755, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "MT", 11814, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "PA", 8870, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "RO", 3858, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "RR", 311, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2004, "TO", 158, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "AC", 592, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "AM", 775, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "AP", 33, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "MA", 922, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "MT", 7145, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "PA", 5899, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "RO", 3244, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "RR", 133, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2005, "TO", 271, curdate(), "admin");

INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "AC", 398, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "AM", 788, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "AP", 30, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "MA", 674, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "MT", 4333, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "PA", 5659, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "RO", 2049, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "RR", 231, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2006, "TO", 124, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "AC", 184, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "AM", 610, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "AP", 39, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "MA", 631, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "MT", 2678, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "PA", 5526, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "RO", 1611, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "RR", 309, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2007, "TO", 63, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "AC", 254, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "AM", 604, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "AP", 100, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "MA", 1271, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "MT", 3258, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "PA", 5607, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "RO", 1136, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "RR", 574, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2008, "TO", 107, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "AC", 167, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "AM", 405, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "AP", 70, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "MA", 828, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "MT", 1049, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "PA", 4281, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "RO", 482, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "RR", 121, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2009, "TO", 61, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "AC", 259, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "AM", 595, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "AP", 53, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "MA", 712, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "MT", 871, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "PA", 3770, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "RO", 435, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "RR", 256, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2010, "TO", 49, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "AC", 280, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "AM", 502, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "AP", 66, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "MA", 396, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "MT", 1120, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "PA", 3008, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "RO", 865, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "RR", 141, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2011, "TO", 40, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "AC", 305, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "AM", 523, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "AP", 27, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "MA", 269, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "MT", 757, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "PA", 1741, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "RO", 773, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "RR", 124, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2012, "TO", 52, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "AC", 221, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "AM", 583, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "AP", 23, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "MA", 403, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "MT", 1139, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "PA", 2346, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "RO", 932, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "RR", 170, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2013, "TO", 74, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "AC", 309, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "AM", 500, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "AP", 31, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "MA", 257, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "MT", 1075, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "PA", 1887, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "RO", 684, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "RR", 219, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2014, "TO", 50, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "AC", 264, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "AM", 712, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "AP", 25, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "MA", 209, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "MT", 1601, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "PA", 2153, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "RO", 1030, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "RR", 156, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2015, "TO", 57, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "AC", 372, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "AM", 1129, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "AP", 17, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "MA", 258, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "MT", 1489, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "PA", 2992, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "RO", 1376, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "RR", 202, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2016, "TO", 58, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "AC", 257, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "AM", 1001, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "AP", 24, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "MA", 265, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "MT", 1561, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "PA", 2433, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "RO", 1243, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "RR", 132, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2017, "TO", 31, curdate(), "admin");


INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "AC", 444, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "AM", 1045, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "AP", 24, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "MA", 253, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "MT", 1490, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "PA", 2744, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "RO", 1316, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "RR", 195, curdate(), "admin");
INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES("Amazônia", 2018, "TO", 25, curdate(), "admin");

