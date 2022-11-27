--CRIACAO DE INDEX PARA OTIMIZACAO DAS BUSCAS

CREATE INDEX idx_estacao ON estacao (estacao_nome);
CREATE INDEX idx_precipitacao ON precipitacao (datahora_captacao);
CREATE INDEX idx_pressao_atmosferica ON pressao_atmosferica (datahora_captacao);
CREATE INDEX idx_radiacao_global ON radiacao_global (datahora_captacao);
CREATE INDEX idx_temperatura ON temperatura (datahora_captacao);
CREATE INDEX idx_umidade ON umidade (datahora_captacao);
CREATE INDEX idx_vento ON vento (datahora_captacao);
CREATE INDEX idx_usuario ON usuario (usuario_username);
CREATE INDEX idx_log_usuario ON log_usuario (log_usuario_alterou);
CREATE INDEX idx_log_estacao ON log_estacao (log_estacao_alterou);

SELECT * FROM radiacao_global;

DROP INDEX idx_preciptacao;
DROP INDEX idx_estacao;
DROP INDEX idx_pressao_atmosferica;
DROP INDEX idx_radiacao_global;
DROP INDEX idx_umidade;
DROP INDEX idx_vento;
DROP INDEX idx_usuario;
DROP INDEX idx_log_usuario;
DROP INDEX idx_log_estacao;
