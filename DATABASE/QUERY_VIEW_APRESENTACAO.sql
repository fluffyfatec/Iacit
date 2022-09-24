-- SELECT VIEW ESTACAO
SELECT * FROM view_filtro_estacao v 
ORDER BY v.cod_wmo;

-- SELECT VIEW TEMPERATURA
SELECT * FROM view_temperatura_dados t
WHERE t.estacao_estado = 'SP'
AND t.estacao_nome = 'TAUBATE'
AND t.datahora_captacao = '01-06-2022 19:00:00';

-- SELECT VIEW UMIDADE
SELECT * FROM view_umidade_dados u
WHERE u.estacao_estado = 'SP'
AND u.estacao_nome = 'TAUBATE'
AND u.datahora_captacao = '01-06-2022 19:00:00';

-- SELECT VIEW VENTO
SELECT * FROM view_vento_dados v
WHERE v.estacao_estado = 'SP'
AND v.estacao_nome = 'TAUBATE'
AND v.datahora_captacao = '01-06-2022 19:00:00';