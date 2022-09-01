import sqlalchemy
from sqlalchemy import create_engine
import psycopg2


def povoar_banco(df):

    # Conectando ao banco de dados
    db = create_engine('postgresql://postgres:123456@[localhost]/db_iacit_api')

    # Inserindo os dados no banco de dados
    for index, row in df.iterrows():
        if db.execute(f"select exists(select 1 from radiacao_global where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO radiacao_global (cod_wmo, radiacao_global, datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', {row['RADIACAO GLOBAL (Kj/m²)']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass
        if db.execute(f"select exists(select 1 from preciptacao where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO preciptacao (cod_wmo, preciptacaototal, datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', {row['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass
        if db.execute(f"select exists(select 1 from vento where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO vento (cod_wmo, vento_velocidade, vento_rajada_max, vento_direcao_horario, "
                       f"datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', {row['VENTO, VELOCIDADE HORARIA (m/s)']}, "
                       f"{row['VENTO, RAJADA MAXIMA (m/s)']}, {row['VENTO, DIREÇÃO HORARIA (gr) (° (gr))']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass
        if db.execute(f"select exists(select 1 from pressao_atmosferica where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO pressao_atmosferica (cod_wmo, pressao_atm_estacao, pressao_atm_min, "
                       f"pressao_atm_max, datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', "
                       f"{row['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)']}, "
                       f"{row['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)']}, "
                       f"{row['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass
        if db.execute(f"select exists(select 1 from temperatura where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO temperatura (cod_wmo, temperatura_ar, temperatura_min, temperatura_max, "
                       f"temperatura_ponto_orvalho, temperatura_orvalho_min, temperatura_orvalho_max, "
                       f"datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', {row['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)']}, "
                       f"{row['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)']}, "
                       f"{row['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)']}, "
                       f"{row['TEMPERATURA DO PONTO DE ORVALHO (°C)']}, "
                       f"{row['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)']}, "
                       f"{row['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass
        if db.execute(f"select exists(select 1 from umidade where cod_wmo='{row['CODIGO (WMO)']}' "
                      f"and datahora_captacao='{row['DATAHORA DE CAPTAÇÃO']}')").scalar() == False:
            db.execute(f"INSERT INTO umidade (cod_wmo, umidade_relativa_ar, umidade_relativa_min, "
                       f"umidade_relativa_max, datahora_captacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', {row['UMIDADE RELATIVA DO AR, HORARIA (%)']}, "
                       f"{row['UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)']}, "
                       f"{row['UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)']}, "
                       f"'{row['DATAHORA DE CAPTAÇÃO']}')")
        else:
            print("Essa linha já existe")
            pass



def estacao_banco(df):

    # Conectando ao banco de dados
    db = create_engine('postgresql://postgres:123456@[localhost]/db_iacit_api')

    for index, row in df.iterrows():
        try:
            db.execute(f"INSERT INTO estacao (cod_wmo, estacao_nome, estacao_regiao, estacao_estado, "
                       f"estacao_longitude, estacao_latitude, estacao_altitude, estacao_datafundacao) VALUES "
                       f"('{row['CODIGO (WMO)']}', '{row['ESTACAO']}', "
                       f"'{row['REGIAO']}', '{row['UF']}', "
                       f"{row['LONGITUDE']}, {row['LATITUDE']}, {row['ALTITUDE']}, "
                       f"'{row['DATA DE FUNDACAO']}')")
        except sqlalchemy.exc.IntegrityError:
            print('Erro de integridade')
            pass
