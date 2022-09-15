--CRIACAO DE INDEX PARA OTIMIZACAO DAS BUSCAS

CREATE INDEX idx_estacao ON estacao (estacao_nome);
CREATE INDEX idx_precipitacao ON precipitacao (datahora_captacao);
CREATE INDEX idx_pressao_atmosferica ON pressao_atmosferica (datahora_captacao);
CREATE INDEX idx_radiacao_global ON radiacao_global (datahora_captacao);
CREATE INDEX idx_temperatura ON temperatura (datahora_captacao);
CREATE INDEX idx_umidade ON umidade (datahora_captacao);
CREATE INDEX idx_vento ON vento (datahora_captacao);

SELECT * FROM radiacao_global;

DROP INDEX idx_preciptacao;