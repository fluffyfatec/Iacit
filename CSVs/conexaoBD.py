import sqlalchemy
from sqlalchemy import create_engine
import logging
from pandas.core.frame import DataFrame
import sys


class ConexaoBD:

    __db = create_engine('postgresql://postgres:123@[localhost]/db_iacit_api')

    logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                        format="%(asctime)s %(message)s", filemode="a")

    def __int__(self, db):
        self.__db = db

    def getDb(self):
        return self.__db

    def conectar_banco(self):

        conexaoBD = ConexaoBD()

        if conexaoBD.getDb().execute(
                "select * from pg_stat_activity WHERE state='active' and datname='db_iacit_api';").scalar() is not None:
            logging.debug("- BANCO CONECTADO COM SUCESSO")
        else:
            logging.debug("- ERRO NA CONEXÃO DO BANCO: verifique se o banco está conectado e tente novamente")
            sys.exit(0)

    def povoar_banco(self, df: DataFrame, tabela: str):

        try:

            conexaoBD = ConexaoBD()

            cod_wmo = df.loc[0][0]

            # Povoamento das tabelas
            sql = f"SELECT datahora_captacao FROM {tabela} WHERE cod_wmo='{cod_wmo}' ORDER BY " \
                  f"datahora_captacao DESC LIMIT 1"

            try:
                df = df[~(df['datahora_captacao'] <= conexaoBD.getDb().execute(sql).scalar())]
            except TypeError:
                pass

            if not df.empty:
                df.to_sql(tabela, conexaoBD.getDb(), if_exists='append', index=False)
                print(f"Há atualizações nos dados da Estação {cod_wmo} em {tabela}")
            else:
                print(f"Não há atualizações nos dados da Estação {cod_wmo} em {tabela}")

        except:
            logging.debug("- ERRO: falha na tentativa de povoar o banco com os dados dos CSVs (CSVs/conexaoBD.py)")
            raise

    def estacao_banco(self, df: DataFrame):

        try:

            conexaoBD = ConexaoBD()

            try:
                df.to_sql('estacao', conexaoBD.getDb(), if_exists='append', index=False)
            except sqlalchemy.exc.IntegrityError:
                print('Erro de integridade, esse código_wmo já existe no banco')
                pass

        except:
            logging.debug("- ERRO: falha na tentativa de atualizar as estações cadastradas no banco (CSVs/conexaoBD.py)")
            raise
