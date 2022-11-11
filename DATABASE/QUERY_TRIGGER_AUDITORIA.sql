-- TRIGGER FUNCTION LOG_USUARIO
CREATE OR REPLACE FUNCTION process_tr_tb_usuario() RETURNS TRIGGER AS $tr_tb_usuario$
DECLARE
 VS_IN_TIPO_OPERACAO  CHAR(1)  := NULL;
BEGIN
  	IF (TG_OP = 'INSERT') THEN
    	VS_IN_TIPO_OPERACAO  := 'I';
  	ELSIF (TG_OP = 'UPDATE') THEN
    	VS_IN_TIPO_OPERACAO  := 'U';
  	ELSIF (TG_OP = 'DELETE') THEN
    	VS_IN_TIPO_OPERACAO  := 'D';
  	END IF;
	IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
	BEGIN
	INSERT INTO log_usuario(
		log_cod_usuario,
		log_usuario_nome,
		log_usuario_senha,
		log_usuario_username,
		log_cod_permissao,
		log_usuario_alterou,
		log_usuario_operacao
	)
	VALUES(
		NEW.cod_usuario,
		NEW.usuario_nome,
		NEW.usuario_senha,
		NEW.usuario_username,
		NEW.cod_permissao,
		NEW.usuario_alterou,
		VS_IN_TIPO_OPERACAO);
	RETURN NULL; -- result is ignored since this is an AFTER trigger
	END;
	ELSIF (TG_OP = 'DELETE') THEN
    BEGIN
      INSERT INTO log_usuario(
		log_cod_usuario,
		log_usuario_nome,
		log_usuario_senha,
		log_usuario_username,
		log_cod_permissao,
		log_usuario_alterou,
		log_usuario_operacao
	)
	VALUES(
		OLD.cod_usuario,
		OLD.usuario_nome,
		OLD.usuario_senha,
		OLD.usuario_username,
		OLD.cod_permissao,
		OLD.usuario_alterou,
		VS_IN_TIPO_OPERACAO);
	RETURN NULL; -- result is ignored since this is an AFTER trigger
	END;
END IF;
RETURN NULL; -- result is ignored since this is an AFTER trigger
END;
$tr_tb_usuario$ LANGUAGE plpgsql;

CREATE TRIGGER tr_tb_usuario
AFTER INSERT OR UPDATE OR DELETE ON usuario
FOR EACH ROW EXECUTE FUNCTION process_tr_tb_usuario();


-- DROPAR TRIGGER FUNCITION LOG_USUARIO
DROP FUNCTION process_tr_tb_usuario CASCADE;



-- SCRIPTS DE TESTES
SELECT * FROM log_usuario;
SELECT * FROM usuario;
SELECT * FROM permissao;

INSERT INTO usuario (usuario_username,usuario_nome,usuario_senha,usuario_cadastrante,cod_permissao,usuario_alterou)
VALUES ('patrick', 'Patrick', 'patrick123', 1,2,1);


UPDATE usuario SET usuario_alterou = 7 WHERE usuario_username = 'patrick';
DELETE FROM usuario WHERE usuario_username = 'aldrik';


------------------------------------------------------------------------------------


-- TRIGGER FUNCTION LOG_ESTACAO
CREATE OR REPLACE FUNCTION process_tr_tb_estacao() RETURNS TRIGGER AS $tr_tb_estacao$
DECLARE
 VS_IN_TIPO_OPERACAO  CHAR(1)  := NULL;
BEGIN
  	IF (TG_OP = 'INSERT') THEN
    	VS_IN_TIPO_OPERACAO  := 'I';
  	ELSIF (TG_OP = 'UPDATE') THEN
    	VS_IN_TIPO_OPERACAO  := 'U';
  	END IF;
	IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
	BEGIN
	INSERT INTO log_estacao(
		log_cod_wmo,
		log_estacao_nome,
		log_estacao_regiao,
		log_estacao_estado,
		log_estacao_status,
		log_estacao_alterou,
		log_estacao_operacao
	)
	VALUES(
		NEW.cod_wmo,
		NEW.estacao_nome,
		NEW.estacao_regiao,
		NEW.estacao_estado,
		NEW.estacao_status,
		NEW.usuario_alterou,
		VS_IN_TIPO_OPERACAO);
	RETURN NULL; -- result is ignored since this is an AFTER trigger
	END;
	END IF;
RETURN NULL; -- result is ignored since this is an AFTER trigger
END;
$tr_tb_estacao$ LANGUAGE plpgsql;


CREATE TRIGGER tr_tb_estacao
AFTER INSERT OR UPDATE OR DELETE ON estacao
FOR EACH ROW EXECUTE FUNCTION process_tr_tb_estacao();

DELETE FROM estacao WHERE cod_wmo = '9999'
SELECT * FROM usuario
SELECT * FROM log_estacao;
INSERT INTO estacao VALUES ('9999','teste','teste','tt',111,222,333,'13/11/1998','A',1);
UPDATE estacao SET estacao_status = 'I' WHERE cod_wmo = '9999';