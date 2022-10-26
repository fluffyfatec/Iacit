import sys
import pandas as pd
import glob
import sqlalchemy
from sqlalchemy import create_engine
from conexaoBD import ConexaoBD
from cleaningData import CleaningData
from cabeçalho import Cabecalho
import logging


class LeituraDfs:

    def __int__(self, db):
        self.db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        df = LeituraDfs()

    @staticmethod
    def leitura_dfs2020():

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2020\*.csv", recursive=True)

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip')
                df1 = pd.read_csv(f, sep=';', encoding='latin-1', skiprows=[0, 1, 2, 3, 4, 5, 6, 7],
                                  on_bad_lines='skip')

                # Criando colunas do cabeçalho vertical
                df['CODIGO (WMO)'] = df.loc[2][1]

                # Dando merge nos dataframes
                df = df1.assign(key=1).merge(df[['CODIGO (WMO)']].assign(key=1), on='key').drop('key', axis=1)
                del df1

                # Tratamento dos dados e povoamento do banco de dados
                ConexaoBD.povoar_banco(CleaningData.tratamento_dfs(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DOS DADOS DE 2020 CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2020 não realizada (CSVs/leituraDfs.py)")
            raise


    @staticmethod
    def leitura_dfs2021():

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2021\*.csv", recursive=True)

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
                ConexaoBD.povoar_banco(CleaningData.tratamento_dfs(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DOS DADOS DE 2021 CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2021 não realizada (CSVs/leituraDfs.py)")
            raise

    @staticmethod
    def leitura_dfs2022():

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True)

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
                ConexaoBD.povoar_banco(CleaningData.tratamento_dfs(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DOS DADOS DE 2022 CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2022 não realizada (CSVs/leituraDfs.py)")
            raise

    @staticmethod
    def leitura_cabecalho2020():

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2020\*.csv", recursive=True)

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip', header=None)

                # Tratamento dos dados e povoamento do banco de dados
                ConexaoBD.estacao_banco(Cabecalho.tratamento_cabecalho(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DAS ESTAÇÕES CADASTRADAS CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2020 não realizada (CSVs/leituraDfs.py)")
            raise

    @staticmethod
    def leitura_cabecalho2021():

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2021\*.csv", recursive=True)

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip', header=None)

                # Tratamento dos dados e povoamento do banco de dados
                ConexaoBD.estacao_banco(Cabecalho.tratamento_cabecalho(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DAS ESTAÇÕES CADASTRADAS CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2021 não realizada (CSVs/leituraDfs.py)")
            raise

    def leitura_cabecalho2022(self):

        logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                            format="%(asctime)s %(message)s", filemode="a")

        # Conectando ao banco de dados
        db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

        if db.execute("select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

        try:
            # Path dos dataframes
            files = glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True)

            i = 1
            for f in files:
                df = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip', header=None)

                # Tratamento dos dados e povoamento do banco de dados
                CBD = ConexaoBD()
                CBD.estacao_banco(Cabecalho.tratamento_cabecalho(df))

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DAS ESTAÇÕES CADASTRADAS CONCLUÍDA COM SUCESSO")
        except:
            logging.debug("- ERRO: leitura dos CSVs de 2022 não realizada (CSVs/leituraDfs.py)")
            raise



