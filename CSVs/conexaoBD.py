import sqlalchemy
from sqlalchemy import create_engine
import logging
import psycopg2


class ConexaoBD:
    @staticmethod
    def povoar_banco(df):

        try:
            # Conectando ao banco de dados
            db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

            # Tabela radiacao_global
            rad = df[['CODIGO (WMO)', 'RADIACAO GLOBAL (Kj/m²)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM radiacao_global WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                rad = rad[~(rad['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            rad = rad.rename({'CODIGO (WMO)': 'cod_wmo', 'RADIACAO GLOBAL (Kj/m²)': 'radiacao_global',
                             'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not rad.empty:
                rad.to_sql('radiacao_global', db, if_exists='append', index=False)


            # Tabela precipitacao
            precip = df[['CODIGO (WMO)', 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM precipitacao WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                precip = precip[~(precip['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            precip = precip.rename({'CODIGO (WMO)': 'cod_wmo', 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)': 'precipitacaototal',
                                    'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not precip.empty:
                precip.to_sql('precipitacao', db, if_exists='append', index=False)


            # Tabela vento
            vento = df[['CODIGO (WMO)', 'VENTO, VELOCIDADE HORARIA (m/s)', 'VENTO, RAJADA MAXIMA (m/s)',
                        'VENTO, DIREÇÃO HORARIA (gr) (° (gr))', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM vento WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                vento = vento[~(vento['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            vento = vento.rename({'CODIGO (WMO)': 'cod_wmo', 'VENTO, VELOCIDADE HORARIA (m/s)': 'vento_velocidade',
                                  'VENTO, RAJADA MAXIMA (m/s)': 'vento_rajada_max',
                                  'VENTO, DIREÇÃO HORARIA (gr) (° (gr))': 'vento_direcao_horario',
                                  'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not vento.empty:
                vento.to_sql('vento', db, if_exists='append', index=False)


            # Tabela pressao_atmosferica
            atm = df[['CODIGO (WMO)', 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)',
                      'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)',
                      'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM pressao_atmosferica WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                atm = atm[~(atm['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            atm = atm.rename({'CODIGO (WMO)': 'cod_wmo',
                              'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)': 'pressao_atm_estacao',
                              'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)': 'pressao_atm_min',
                              'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)': 'pressao_atm_max',
                              'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not atm.empty:
                atm.to_sql('pressao_atmosferica', db, if_exists='append', index=False)


            # Tabela temperatura
            temp = df[['CODIGO (WMO)', 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)',
                      'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)',
                      'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)',
                      'TEMPERATURA DO PONTO DE ORVALHO (°C)',
                      'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)',
                      'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM temperatura WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                temp = temp[~(temp['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            temp = temp.rename({'CODIGO (WMO)': 'cod_wmo',
                              'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)': 'temperatura_ar',
                              'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)': 'temperatura_min',
                              'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)': 'temperatura_max',
                              'TEMPERATURA DO PONTO DE ORVALHO (°C)': 'temperatura_ponto_orvalho',
                              'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)': 'temperatura_orvalho_min',
                              'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)': 'temperatura_orvalho_max',
                              'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not temp.empty:
                temp.to_sql('temperatura', db, if_exists='append', index=False)


            # Tabela umidade
            umi = df[['CODIGO (WMO)', 'UMIDADE RELATIVA DO AR, HORARIA (%)',
                      'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)',
                      'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM umidade WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                umi = umi[~(umi['DATAHORA DE CAPTAÇÃO'] <= db.execute(sql).scalar())]
            except TypeError:
                pass

            umi = umi.rename({'CODIGO (WMO)': 'cod_wmo',
                              'UMIDADE RELATIVA DO AR, HORARIA (%)': 'umidade_relativa_ar',
                              'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)': 'umidade_relativa_min',
                              'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)': 'umidade_relativa_max',
                              'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not umi.empty:
                umi.to_sql('umidade', db, if_exists='append', index=False)

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.exception("- ERRO")
            raise

    @staticmethod
    def povoar_banco_sqlquery(df):

        try:
            # Conectando ao banco de dados
            db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

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

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.exception("- ERRO")
            raise

    @staticmethod
    def estacao_banco(df):

        try:
            # Conectando ao banco de dados
            db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

            # Tabela estacao
            estacao = df[['CODIGO (WMO)', 'ESTACAO', 'REGIAO', 'UF', 'LONGITUDE', 'LATITUDE',
                          'ALTITUDE', 'DATA DE FUNDACAO']]

            estacao = estacao.rename({'CODIGO (WMO)': 'cod_wmo', 'ESTACAO': 'estacao_nome',
                                      'REGIAO': 'estacao_regiao', 'UF': 'estacao_estado',
                                      'LONGITUDE': 'estacao_longitude',
                                      'LATITUDE': 'estacao_latitude', 'ALTITUDE': 'estacao_altitude',
                                      'DATA DE FUNDACAO': 'estacao_datafundacao'}, axis=1)
            try:
                estacao.to_sql('estacao', db, if_exists='append', index=False)
            except sqlalchemy.exc.IntegrityError:
                print('Erro de integridade, esse código_wmo já existe no banco')
                pass

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.exception("- ERRO")
            raise

    @staticmethod
    def estacao_banco_sqlquery(df):

        try:
            # Conectando ao banco de dados
            db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

            for index, row in df.iterrows():
                try:
                    db.execute(f"INSERT INTO estacao (cod_wmo, estacao_nome, estacao_regiao, estacao_estado, "
                               f"estacao_longitude, estacao_latitude, estacao_altitude, estacao_datafundacao) VALUES "
                               f"('{row['CODIGO (WMO)']}', '{row['ESTACAO']}', "
                               f"'{row['REGIAO']}', '{row['UF']}', "
                               f"{row['LONGITUDE']}, {row['LATITUDE']}, {row['ALTITUDE']}, "
                               f"'{row['DATA DE FUNDACAO']}')")
                except sqlalchemy.exc.IntegrityError:
                    print('Erro de integridade, esse código_wmo já existe no banco')
                    pass

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.exception("- ERRO")
            raise
