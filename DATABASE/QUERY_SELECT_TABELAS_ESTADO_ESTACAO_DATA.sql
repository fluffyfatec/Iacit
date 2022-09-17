-- SELECT DE PRECIPTACAO TOTAL POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT p.precipitacaototal, p.cod_wmo
FROM precipitacao AS p
INNER JOIN estacao AS e ON e.cod_wmo = p.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND p.datahora_captacao = '2020-01-01 00:00:00';

-- SELECT DE PRESSAO ATMOSFERICA POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT pa.pressao_atm_estacao,pa.pressao_atm_max,pa.pressao_atm_min,pa.cod_wmo
FROM pressao_atmosferica AS pa
INNER JOIN estacao AS e ON e.cod_wmo = pa.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND pa.datahora_captacao = '2020-01-01 00:00:00';

-- SELECT DE RADIAÇAO GLOBAL POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT rg.radiacao_global,rg.cod_wmo
FROM radiacao_global AS rg
INNER JOIN estacao AS e ON e.cod_wmo = rg.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND rg.datahora_captacao = '2020-01-01 00:00:00';

-- SELECT DE TEMPERATURA POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT t.temperatura_ar,t.temperatura_max,t.temperatura_min,t.temperatura_orvalho_max,t.temperatura_orvalho_min,t.temperatura_ponto_orvalho
FROM temperatura AS t
INNER JOIN estacao AS e ON e.cod_wmo = t.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND t.datahora_captacao = '2020-01-01 00:00:00';

-- SELECT DE UMIDADE POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT u.umidade_relativa_ar,u.umidade_relativa_max,u.umidade_relativa_min
FROM umidade AS u
INNER JOIN estacao AS e ON e.cod_wmo = u.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND u.datahora_captacao = '2020-01-01 00:00:00';

-- SELECT DE VENTO POR ESTADO, ESTACAO, COD_WMO, DATA HORA
SELECT v.vento_direcao_horario,v.vento_rajada_max,v.vento_velocidade,v.datahora_captacao,v.cod_wmo
FROM vento AS v
INNER JOIN estacao AS e ON e.cod_wmo = v.cod_wmo
WHERE e.estacao_estado = 'DF'
AND e.estacao_nome = 'BRASILIA'
AND e.cod_wmo = 'A001'
AND v.datahora_captacao = '2020-01-01 00:00:00';
