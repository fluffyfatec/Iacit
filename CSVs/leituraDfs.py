import pandas as pd
from conexaoBD import ConexaoBD
from cleaningData import CleaningData
from cabeçalho import Cabecalho
import logging
import glob


class LeituraDfs:

    logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                        format="%(asctime)s %(message)s", filemode="a")

    def leitura_dfs(self, ano: str):

        cbd = ConexaoBD()

        cbd.conectar_banco()

        try:

            # Path dos dataframes
            files = glob.glob(fr"C:\Users\**\Iacit\CSVs\DF\{ano}\*.csv", recursive=True)

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

                df = cleaningData.tratamento_dfs(df)

                cbd.povoar_banco(df.getRad(), 'radiacao_global')
                cbd.povoar_banco(df.getPrecip(), 'precipitacao')
                cbd.povoar_banco(df.getVento(), 'vento')
                cbd.povoar_banco(df.getAtm(), 'pressao_atmosferica')
                cbd.povoar_banco(df.getTemp(), 'temperatura')
                cbd.povoar_banco(df.getUmi(), 'umidade')

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DOS DADOS DE 2022 CONCLUÍDA COM SUCESSO")

        except:
            logging.debug("- ERRO: leitura dos CSVs não realizada (CSVs/leituraDfs.py)")
            raise

    def leitura_cabecalho(self, ano: str):

        cbd = ConexaoBD()

        cbd.conectar_banco()

        try:

            # Path dos dataframes
            files = glob.glob(fr"C:\Users\**\Iacit\CSVs\DF\{ano}\*.csv", recursive=True)

            i = 1
            for f in files:
                dfEstacao = pd.read_csv(f, sep=';', encoding='latin-1', on_bad_lines='skip', header=None)

                # Tratamento dos dados e povoamento do banco de dados
                cabecalho = Cabecalho()

                dfEstacao = cabecalho.tratamento_cabecalho(dfEstacao)

                cbd.estacao_banco(dfEstacao.getEstacao())

                print(i)
                i += 1

            logging.debug("- ATUALIZAÇÃO DAS ESTAÇÕES CADASTRADAS CONCLUÍDA COM SUCESSO")

        except:
            logging.debug("- ERRO: leitura dos CSVs não realizada (CSVs/leituraDfs.py)")
            raise



