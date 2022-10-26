import sqlalchemy
from sqlalchemy import create_engine
import logging
from pandas.core.frame import DataFrame
import psycopg2


class ConexaoBD:

    __db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

    def __int__(self, db):
        self.__db = db

    def getDb(self):
        return self.__db

    def povoar_banco(self, df: DataFrame):

        try:

            conexaoBD = ConexaoBD()

            # Tabela radiacao_global
            rad = df[['CODIGO (WMO)', 'RADIACAO GLOBAL (Kj/m²)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM radiacao_global WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                rad = rad[~(rad['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            rad = rad.rename({'CODIGO (WMO)': 'cod_wmo', 'RADIACAO GLOBAL (Kj/m²)': 'radiacao_global',
                             'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not rad.empty:
                rad.to_sql('radiacao_global', conexaoBD.getDb(), if_exists='append', index=False)


            # Tabela precipitacao
            precip = df[['CODIGO (WMO)', 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM precipitacao WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                precip = precip[~(precip['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            precip = precip.rename({'CODIGO (WMO)': 'cod_wmo', 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)': 'precipitacaototal',
                                    'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not precip.empty:
                precip.to_sql('precipitacao', conexaoBD.getDb(), if_exists='append', index=False)


            # Tabela vento
            vento = df[['CODIGO (WMO)', 'VENTO, VELOCIDADE HORARIA (m/s)', 'VENTO, RAJADA MAXIMA (m/s)',
                        'VENTO, DIREÇÃO HORARIA (gr) (° (gr))', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM vento WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                vento = vento[~(vento['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            vento = vento.rename({'CODIGO (WMO)': 'cod_wmo', 'VENTO, VELOCIDADE HORARIA (m/s)': 'vento_velocidade',
                                  'VENTO, RAJADA MAXIMA (m/s)': 'vento_rajada_max',
                                  'VENTO, DIREÇÃO HORARIA (gr) (° (gr))': 'vento_direcao_horario',
                                  'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not vento.empty:
                vento.to_sql('vento', conexaoBD.getDb(), if_exists='append', index=False)


            # Tabela pressao_atmosferica
            atm = df[['CODIGO (WMO)', 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)',
                      'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)',
                      'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM pressao_atmosferica WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                atm = atm[~(atm['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            atm = atm.rename({'CODIGO (WMO)': 'cod_wmo',
                              'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)': 'pressao_atm_estacao',
                              'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)': 'pressao_atm_min',
                              'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)': 'pressao_atm_max',
                              'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not atm.empty:
                atm.to_sql('pressao_atmosferica', conexaoBD.getDb(), if_exists='append', index=False)


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
                temp = temp[~(temp['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
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
                temp.to_sql('temperatura', conexaoBD.getDb(), if_exists='append', index=False)


            # Tabela umidade
            umi = df[['CODIGO (WMO)', 'UMIDADE RELATIVA DO AR, HORARIA (%)',
                      'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)',
                      'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)', 'DATAHORA DE CAPTAÇÃO']]

            sql = f"SELECT datahora_captacao FROM umidade WHERE cod_wmo='{df.loc[0][0]}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                umi = umi[~(umi['DATAHORA DE CAPTAÇÃO'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            umi = umi.rename({'CODIGO (WMO)': 'cod_wmo',
                              'UMIDADE RELATIVA DO AR, HORARIA (%)': 'umidade_relativa_ar',
                              'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)': 'umidade_relativa_min',
                              'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)': 'umidade_relativa_max',
                              'DATAHORA DE CAPTAÇÃO': 'datahora_captacao'}, axis=1)

            if not umi.empty:
                umi.to_sql('umidade', conexaoBD.getDb(), if_exists='append', index=False)

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.debug("- ERRO: falha na tentativa de povoar o banco com os dados dos CSVs (CSVs/conexaoBD.py)")
            raise

    def estacao_banco(self, df: DataFrame):

        try:

            conexaoBD = ConexaoBD()

            # Tabela estacao
            estacao = df[['CODIGO (WMO)', 'ESTACAO', 'REGIAO', 'UF', 'LONGITUDE', 'LATITUDE',
                          'ALTITUDE', 'DATA DE FUNDACAO']]

            estacao = estacao.rename({'CODIGO (WMO)': 'cod_wmo', 'ESTACAO': 'estacao_nome',
                                      'REGIAO': 'estacao_regiao', 'UF': 'estacao_estado',
                                      'LONGITUDE': 'estacao_longitude',
                                      'LATITUDE': 'estacao_latitude', 'ALTITUDE': 'estacao_altitude',
                                      'DATA DE FUNDACAO': 'estacao_datafundacao'}, axis=1)
            try:
                estacao.to_sql('estacao', conexaoBD.getDb(), if_exists='append', index=False)
            except sqlalchemy.exc.IntegrityError:
                print('Erro de integridade, esse código_wmo já existe no banco')
                pass

        except:
            logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                format="%(asctime)s %(message)s", filemode="a")
            logging.debug("- ERRO: falha na tentativa de atualizar as estações cadastradas no banco (CSVs/conexaoBD.py)")
            raise
