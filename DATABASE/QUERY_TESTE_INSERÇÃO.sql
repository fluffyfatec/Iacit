--INSERT ESTACAO
INSERT INTO estacao VALUES ('A701','Campos do Jordão','SE','SP',-15.93527777,-48.13749999,990,'2020-08-29');
INSERT INTO estacao VALUES ('A702','São Paulo','SE','SP',-15.93527888,-48.13749222,990,'2020-08-29');

--INSERT RADIACAO GLOBAL
INSERT INTO radiacao_global (cod_wmo, datahora_captacao, radiacao_global) VALUES ('A701','28-08-2022 20:00:00', 5);
INSERT INTO radiacao_global (cod_wmo, datahora_captacao, radiacao_global) VALUES ('A701','29-08-2022 21:00:00', 2);
INSERT INTO radiacao_global (cod_wmo, datahora_captacao, radiacao_global) VALUES ('A702','30-08-2022 22:00:00', 1);
INSERT INTO radiacao_global (cod_wmo, datahora_captacao, radiacao_global) VALUES ('A702','31-08-2022 23:00:00', 6);

--INSERT PRECIPTAÇÃO
INSERT INTO precipitacao (cod_wmo, datahora_captacao, precipitacaototal) VALUES ('A701','28-08-2022 20:00:00', 9);
INSERT INTO precipitacao (cod_wmo, datahora_captacao, precipitacaototal) VALUES ('A701','29-08-2022 21:00:00', 1);
INSERT INTO precipitacao (cod_wmo, datahora_captacao, precipitacaototal) VALUES ('A702','30-08-2022 22:00:00', 7);
INSERT INTO precipitacao (cod_wmo, datahora_captacao, precipitacaototal) VALUES ('A702','31-08-2022 23:00:00', 3);

--INSERT VENTO
INSERT INTO vento (cod_wmo,datahora_captacao,vento_direcao_horario,vento_rajada_max,vento_velocidade) 
VALUES ('A701','28-08-2022 20:00:00',15,25,5);
INSERT INTO vento (cod_wmo,datahora_captacao,vento_direcao_horario,vento_rajada_max,vento_velocidade) 
VALUES ('A701','29-08-2022 21:00:00',20,30,8);
INSERT INTO vento (cod_wmo,datahora_captacao,vento_direcao_horario,vento_rajada_max,vento_velocidade) 
VALUES ('A702','30-08-2022 22:00:00',25,45,15);
INSERT INTO vento (cod_wmo,datahora_captacao,vento_direcao_horario,vento_rajada_max,vento_velocidade) 
VALUES ('A702','31-08-2022 23:00:00',5,10,2);

--INSERT PRESSAO ATMOSFERICA
INSERT INTO pressao_atmosferica (cod_wmo,datahora_captacao,pressao_atm_estacao,pressao_atm_max,pressao_atm_min)
VALUES ('A701','28-08-2022 20:00:00',5,15,10);
INSERT INTO pressao_atmosferica (cod_wmo,datahora_captacao,pressao_atm_estacao,pressao_atm_max,pressao_atm_min)
VALUES ('A701','29-08-2022 21:00:00',10,25,20);
INSERT INTO pressao_atmosferica (cod_wmo,datahora_captacao,pressao_atm_estacao,pressao_atm_max,pressao_atm_min)
VALUES ('A702','30-08-2022 22:00:00',4,8,6);
INSERT INTO pressao_atmosferica (cod_wmo,datahora_captacao,pressao_atm_estacao,pressao_atm_max,pressao_atm_min)
VALUES ('A702','31-08-2022 23:00:00',12,22,14);

--INSERT TEMPERATURA
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A701','28-08-2022 20:00:00',10.5,20,25.55,19.80,30,155.2);
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A701','29-08-2022 21:00:00',20,30,35.80,15,25,100.3);
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A702','30-08-2022 22:00:00',15,25,32.5,19,37,110);
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A702','31-08-2022 23:00:00',5,15,22,10,17,80);

--INSERT UMIDADE
INSERT INTO umidade (cod_wmo,datahora_captacao,umidade_relativa_ar,umidade_relativa_max,umidade_relativa_min)
VALUES ('A701','28-08-2022 20:00:00',26,35,15);
INSERT INTO umidade (cod_wmo,datahora_captacao,umidade_relativa_ar,umidade_relativa_max,umidade_relativa_min)
VALUES ('A701','29-08-2022 21:00:00',15,20,5);
INSERT INTO umidade (cod_wmo,datahora_captacao,umidade_relativa_ar,umidade_relativa_max,umidade_relativa_min)
VALUES ('A702','30-08-2022 22:00:00',20,30,20);
INSERT INTO umidade (cod_wmo,datahora_captacao,umidade_relativa_ar,umidade_relativa_max,umidade_relativa_min)
VALUES ('A702','31-08-2022 23:00:00',30,40,30);



SELECT * FROM temperatura;
SELECT * FROM estacao;
SELECT * FROM radiacao_global;
SELECT * FROM umidade;
SELECT * FROM vento;
SELECT * FROM preciptacao;
SELECT * FROM pressao_atmosferica;

SELECT datahora_captacao FROM temperatura ORDER BY datahora_captacao DESC LIMIT 1;