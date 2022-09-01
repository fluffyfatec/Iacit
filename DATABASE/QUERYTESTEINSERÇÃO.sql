--INSERT ESTACAO
INSERT INTO estacao VALUES ('A701','Campos do Jordão','SE','SP',-15.93527777,-48.13749999,990,'2020-08-29');
INSERT INTO estacao VALUES ('$','$','$','$',$,$,'$');

--INSERT TEMPERATURA
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A701','28-08-2022 20:00:00',10.5,20,25.55,19.80,30,155.2);
INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('$','$',$,$,$,$,$,$);

INSERT INTO temperatura (cod_wmo,datahora_captacao,temperatura_ar,temperatura_max,temperatura_min,temperatura_orvalho_max,temperatura_orvalho_min,temperatura_ponto_orvalho)
VALUES ('A701','31-08-2022 22:00:00',10.5,20,25.55,19.80,30,155.2);


SELECT * FROM temperatura;
SELECT * FROM estacao;

SELECT datahora_captacao FROM temperatura ORDER BY datahora_captacao DESC LIMIT 1;