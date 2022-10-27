-- VIEW DE ESTADO, ESTACAO, COD_WMO, ESTADO, NOME
CREATE VIEW view_filtro_estacao AS
SELECT cod_wmo, estacao_estado, estacao_nome FROM estacao e;

-- SELECT VIEW ESTADO
SELECT * FROM view_filtro_estacao v 
WHERE estacao_estado = 'DF'
AND estacao_nome = 'BRAZLANDIA'


-- VIEW DE PRECIPITACAO TOTAL POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_precipitacao_dados AS
SELECT p.precipitacaototal, e.cod_wmo, e.estacao_estado, e.estacao_nome, p.datahora_captacao
FROM precipitacao AS p
INNER JOIN estacao AS e ON e.cod_wmo = p.cod_wmo

-- SELECT VIEW PRECIPITACAO
SELECT * FROM view_precipitacao_dados vp
WHERE vp.estacao_estado = 'DF'
AND vp.estacao_nome = 'BRASILIA'
AND vp.cod_wmo = 'A001'
AND vp.datahora_captacao = '2020-01-01 00:00:00';


-- VIEW DE PRESSAO ATMOSFERICA POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_pressaoatmosferica_dados AS
SELECT pa.pressao_atm_estacao,pa.pressao_atm_max,pa.pressao_atm_min, e.cod_wmo, e.estacao_estado, e.estacao_nome, pa.datahora_captacao
FROM pressao_atmosferica AS pa
INNER JOIN estacao AS e ON e.cod_wmo = pa.cod_wmo

-- SELECT VIEW PRESSAO ATMOSFERICA
SELECT * FROM view_pressaoatmosferica_dados pa
WHERE pa.estacao_estado = 'DF'
AND pa.estacao_nome = 'BRASILIA'
AND pa.cod_wmo = 'A001'
AND pa.datahora_captacao = '2020-01-01 00:00:00';


-- VIEW DE RADIAÇAO GLOBAL POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_radiacaoglobal_dados AS
SELECT rg.radiacao_global,e.cod_wmo, e.estacao_estado, e.estacao_nome, rg.datahora_captacao
FROM radiacao_global AS rg
INNER JOIN estacao AS e ON e.cod_wmo = rg.cod_wmo

-- SELECT VIEW RADIACAO
SELECT * FROM view_radiacaoglobal_dados rg
WHERE rg.estacao_estado = 'DF'
AND rg.estacao_nome = 'BRASILIA'
AND rg.cod_wmo = 'A001'
AND rg.datahora_captacao = '2020-01-01 00:00:00';


-- VIEW DE TEMPERATURA POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_temperatura_dados AS
SELECT t.temperatura_ar,t.temperatura_max,t.temperatura_min,t.temperatura_orvalho_max,t.temperatura_orvalho_min,t.temperatura_ponto_orvalho,
e.cod_wmo, e.estacao_estado, e.estacao_nome, t.datahora_captacao
FROM temperatura AS t
INNER JOIN estacao AS e ON e.cod_wmo = t.cod_wmo

-- SELECT VIEW TEMPERATURA
SELECT * FROM view_temperatura_dados t
WHERE t.estacao_estado = 'DF'
AND t.estacao_nome = 'BRASILIA'
AND t.cod_wmo = 'A001'
AND t.datahora_captacao = '2020-01-01 00:00:00';


-- VIEW DE UMIDADE POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_umidade_dados AS
SELECT u.umidade_relativa_ar,u.umidade_relativa_max,u.umidade_relativa_min,e.cod_wmo, e.estacao_estado, e.estacao_nome, u.datahora_captacao
FROM umidade AS u
INNER JOIN estacao AS e ON e.cod_wmo = u.cod_wmo


-- SELECT VIEW UMIDADE
SELECT * FROM view_umidade_dados u
WHERE u.estacao_estado = 'DF'
AND u.estacao_nome = 'BRASILIA'
AND u.cod_wmo = 'A001'
AND u.datahora_captacao = '2020-01-01 00:00:00';


-- VIEW DE VENTO POR ESTADO, ESTACAO, COD_WMO, DATA HORA
CREATE VIEW view_vento_dados AS
SELECT v.vento_direcao_horario,v.vento_rajada_max,v.vento_velocidade, e.cod_wmo, e.estacao_estado, e.estacao_nome, v.datahora_captacao
FROM vento AS v
INNER JOIN estacao AS e ON e.cod_wmo = v.cod_wmo

-- SELECT VIEW VENTO
SELECT * FROM view_vento_dados v
WHERE v.estacao_estado = 'DF'
AND v.estacao_nome = 'BRASILIA'
AND v.cod_wmo = 'A001'
AND v.datahora_captacao = '2020-01-01 00:00:00';

--VIEW REGIAO
CREATE VIEW view_filtro_regiao AS
SELECT DISTINCT est.estacao_estado, est.estacao_regiao FROM estacao est

--DROP VIEWS
DROP VIEW view_precipitacao_dados;
DROP VIEW view_filtro_estacao;
DROP VIEW view_pressaoatmosferica_dados;
DROP VIEW view_radiacaoglobal_dados;
DROP VIEW view_temperatura_dados;
DROP VIEW view_umidade_dados;
DROP VIEW view_vento_dados;


