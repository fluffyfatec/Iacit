import pandas as pd
import logging
from pandas.core.frame import DataFrame
from conexaoBD import ConexaoBD


class Cabecalho:

    logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                        format="%(asctime)s %(message)s", filemode="a")

    def __int__(self, estacao):
        self.__estacao = estacao

    def getEstacao(self):
        return self.__estacao

    def tratamento_cabecalho(self, df: DataFrame):

        try:

            pd.options.mode.chained_assignment = None

            df['REGIAO'] = df.loc[0][1]
            df['UF'] = df.loc[1][1]
            df['ESTACAO'] = df.loc[2][1]
            df['CODIGO (WMO)'] = df.loc[3][1]
            df['LATITUDE'] = df.loc[4][1]
            df['LONGITUDE'] = df.loc[5][1]
            df['ALTITUDE'] = df.loc[6][1]
            df['DATA DE FUNDACAO'] = df.loc[7][1]

            # Apagando duplicadas
            df = df.drop_duplicates(subset=['REGIAO', 'UF'], keep='first')

            # Apagando vírgulas extras
            cols = ["REGIAO", "UF", "ESTACAO", "CODIGO (WMO)", "LATITUDE", "LONGITUDE", "ALTITUDE", "DATA DE FUNDACAO"]
            df[cols] = df[cols].replace({',,,,,,,,,,,,,': ''}, regex=True)
            df[cols] = df[cols].replace({',,,,,,,,,,,,': ''}, regex=True)
            df[cols] = df[cols].replace({',': '.'}, regex=True)

            # Convertendo a datetime
            df['DATA DE FUNDACAO'] = pd.to_datetime(df['DATA DE FUNDACAO'], errors='coerce')

            # Renomeando colunas
            df = df.rename({'CODIGO (WMO)': 'cod_wmo', 'ESTACAO': 'estacao_nome',
                            'REGIAO': 'estacao_regiao', 'UF': 'estacao_estado',
                            'LONGITUDE': 'estacao_longitude',
                            'LATITUDE': 'estacao_latitude', 'ALTITUDE': 'estacao_altitude',
                            'DATA DE FUNDACAO': 'estacao_datafundacao'}, axis=1)

            # Config para visualizar todas as colunas
            pd.set_option('display.max_columns', None)

            # Organizando o dataframe conforme a tabela do banco
            cabecalho = Cabecalho()

            cabecalho.organizar_cabecalho(df)

        except:
            logging.debug("- ERRO: tratamento do cabeçalho não pode ser concluída (CSVs/cabeçalho.py)")
            raise

    def organizar_cabecalho(self, df: DataFrame):

        # Criando objeto e determinando atributos da instância
        df_estacao = Cabecalho()

        df_estacao.__estacao = df[['cod_wmo', 'estacao_nome', 'estacao_regiao', 'estacao_estado',
                                   'estacao_longitude', 'estacao_latitude',
                                   'estacao_altitude', 'estacao_datafundacao']]

        # Populando o banco através do dataframe
        cbd = ConexaoBD()

        cbd.estacao_banco(df_estacao.getEstacao())



