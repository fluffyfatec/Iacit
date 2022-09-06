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
	
	--UNIQUE RADIACAO_GLOBAL
	CONSTRAINT uk_rad_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA RADIACAO_GLOBAL
	CONSTRAINT pk_cod_radiacao PRIMARY KEY (cod_radiacao),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	CONSTRAINT fk_rad_cod_wmo FOREIGN KEY (cod_wmo)
		REFERENCES estacao(cod_wmo)
); 


--CRIAÇÃO DA TABELA PRECIPTACAO
CREATE TABLE preciptacao(
	cod_preciptacao SERIAL,
	cod_wmo VARCHAR(4) NOT NULL,
	preciptacaototal DECIMAL,
	datahora_captacao TIMESTAMP NOT NULL,
	
	--UNIQUE PRECIPTAÇÃO
	CONSTRAINT uk_prec_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA PRECIPTACAO
	CONSTRAINT pk_cod_preciptacao PRIMARY KEY (cod_preciptacao),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	CONSTRAINT fk_prec_cod_wmo FOREIGN KEY (cod_wmo)
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
	
	--UNIQUE VENTO
	CONSTRAINT uk_vento_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA VENTO
	CONSTRAINT pk_cod_vento PRIMARY KEY (cod_vento),
	--CHAVE ESTRANGEIRA TABELA ESTACAO(COD_WMO)
	CONSTRAINT fk_vento_cod_wmo FOREIGN KEY (cod_wmo)
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
	
	--UNIQUE PRESSAO ATMOSFERICA
	CONSTRAINT uk_pressao_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA PRESSAO ATMOSFERICA
	CONSTRAINT pk_cod_pressao_atm PRIMARY KEY (cod_pressao_atm),
	--CHAVE ESTRANGEIRA TABELA PRESSAO ATMOSFERICA(COD_WMO)
	CONSTRAINT fk_pressao_cod_wmo FOREIGN KEY (cod_wmo)
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
	
	--UNIQUE TEMPERATURA
	CONSTRAINT uk_temp_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA TEMPERATURA
	CONSTRAINT pk_cod_temperatura PRIMARY KEY (cod_temperatura),
	--CHAVE ESTRANGEIRA TABELA TEMPERATURA
	CONSTRAINT fk_temp_cod_wmo FOREIGN KEY (cod_wmo)
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
	
	--UNIQUE UMIDADE
	CONSTRAINT uk_umid_wmo_datahora UNIQUE (cod_wmo, datahora_captacao),
	
	--CHAVE PRIMARIA TEMPERATURA
	CONSTRAINT pk_cod_umidade PRIMARY KEY (cod_umidade),
	--CHAVE ESTRANGEIRA TABELA UMIDADE
	CONSTRAINT fk_umid_cod_wmo FOREIGN KEY (cod_wmo)
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
