--CRIAÇÃO DE INDEX PARA OTIMIZAÇÃO DAS BUSCAS

CREATE INDEX idx_estacao ON estacao (cod_wmo);
CREATE INDEX idx_preciptacao ON preciptacao (cod_preciptacao);
CREATE INDEX idx_pressao_atmosferica ON pressao_atmosferica (cod_pressao_atm);
CREATE INDEX idx_radiacao_global ON radiacao_global (cod_radiacao);
CREATE INDEX idx_temperatura ON temperatura (cod_temperatura);
CREATE INDEX idx_umidade ON umidade (cod_umidade);
CREATE INDEX idx_vento ON vento (cod_vento);

SELECT * FROM radiacao_global;