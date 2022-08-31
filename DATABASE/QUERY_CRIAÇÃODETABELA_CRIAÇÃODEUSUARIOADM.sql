--CRIAÇÃO DA BASE DE DADOS
CREATE DATABASE db_iacit_api;
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE db_iacit_api
    IS 'Banco de dados da API do 3º Semestre - Cliente Iacit';

--CRIAÇÃO DA TABELA ESTACAO
CREATE TABLE estacao (
	cod_wmo VARCHAR(4) NOT NULL,
	estacao_nome VARCHAR(60) UNIQUE NOT NULL,
	estacao_regiao VARCHAR(60) NOT NULL,
	estacao_estado CHAR(2) NOT NULL,
	estacao_longitude DECIMAL NOT NULL,
	estacao_latitude DECIMAL NOT NULL,
	estacao_altitude DECIMAL NOT NULL,
	estacao_datafundacao DATE,
	estacao_status CHAR(1) NOT NULL DEFAULT('A'),
	
	--CHAVE PRIMARIA ESTACAO
	PRIMARY KEY (cod_wmo)
);


--CRIAÇÃO DA TABELA RADICACAO GLOBAL
CREATE TABLE radiacao_global(
	cod_radiacao SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	radiacao_global DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA RADIACAO_GLOBAL
	PRIMARY KEY (cod_radiacao),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
); 


--CRIAÇÃO DA TABELA PRECIPTACAO
CREATE TABLE preciptacao(
	cod_preciptacao SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	preciptacaototal DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA PRECIPTACAO
	PRIMARY KEY (cod_preciptacao),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
);


--CRIAÇÃO DA TABELA VENTO
CREATE TABLE vento(
	cod_vento SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	vento_velocidade DECIMAL,
	vento_rajada_max DECIMAL,
	vento_direcao_horario DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA VENTO
	PRIMARY KEY (cod_vento),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
);


--CRIAÇÃO DA TABELA PRESSAO ATMOSFERICA
CREATE TABLE pressao_atmosferica(
	cod_pressao_atm SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	pressao_atm_estacao DECIMAL,
	pressao_atm_min DECIMAL,
	pressao_atm_max DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA PRESSAO ATMOSFERICA
	PRIMARY KEY (cod_pressao_atm),
	--CHAVE ESTRANGEIRA TABELA PRESSAO ATMOSFERICA(COD_WMO)
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
);


--CRIAÇÃO DA TEMPERATURA
CREATE TABLE temperatura(
	cod_temperatura SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	temperatura_ar DECIMAL,
	temperatura_min DECIMAL,
	temperatura_max DECIMAL,
	temperatura_ponto_orvalho DECIMAL,
	temperatura_orvalho_min DECIMAL,
	temperatura_orvalho_max DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA TEMPERATURA
	PRIMARY KEY (cod_temperatura),
	--CHAVE ESTRANGEIRA TABELA TEMPERATURA
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
);


--CRIAÇÃO DA UMIDADE
CREATE TABLE umidade(
	cod_umidade SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	umidade_relativa_ar DECIMAL,
	umidade_relativa_min DECIMAL,
	umidade_relativa_max DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--CHAVE PRIMARIA TEMPERATURA
	PRIMARY KEY (cod_umidade),
	--CHAVE ESTRANGEIRA TABELA UMIDADE
	FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
);


--CRIAÇÃO DE USUARIO ADMINISTRADOR
CREATE ROLE fluffyapi WITH PASSWORD 'fluaffy123';
	--DAR TODOS PRIVILEGIOS AO ADM
	GRANT ALL PRIVILEGES ON estacao TO fluffyapi; 
	GRANT ALL PRIVILEGES ON temperatura TO fluffyapi; 
	GRANT ALL PRIVILEGES ON preciptacao TO fluffyapi; 
	GRANT ALL PRIVILEGES ON pressao_atmosferica TO fluffyapi; 
	GRANT ALL PRIVILEGES ON radiacao_global TO fluffyapi; 
	GRANT ALL PRIVILEGES ON umidade TO fluffyapi; 
	GRANT ALL PRIVILEGES ON vento TO fluffyapi; 
