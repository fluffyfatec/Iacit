import pandas as pd
from conexaoBD import ConexaoBD
from cleaningData import CleaningData
from cabeçalho import Cabecalho
import logging


class LeituraDfs:

    def leitura_dfs(self, files):

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        cbd = ConexaoBD()

        cbd.conectar_banco()

        try:

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip')
                df1 = pd.read_csv(f, sep=';', encoding='latin-1', skiprows=[0, 1, 2, 3, 4, 5, 6, 7], on_bad_lines='skip')

                # Criando colunas do cabeçalho vertical
                df['CODIGO (WMO)'] = df.loc[2][1]

                # Dando merge nos dataframes
                df = df1.assign(key=1).merge(df[['CODIGO (WMO)']].assign(key=1), on='key').drop('key', axis=1)
                del df1

                # Tratamento dos dados e povoamento do banco de dados
                cleaningData = CleaningData()

                cleaningData.tratamento_dfs(df)

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DOS DADOS DE 2022 CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs não realizada (CSVs/leituraDfs.py)")
            raise

    def leitura_cabecalho(self, files):

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        cbd = ConexaoBD()

        cbd.conectar_banco()

        try:

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip', header=None)

                # Tratamento dos dados e povoamento do banco de dados
                cabecalho = Cabecalho()

                cabecalho.tratamento_cabecalho(df)

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DAS ESTAÇÕES CADASTRADAS CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs não realizada (CSVs/leituraDfs.py)")
            raise



