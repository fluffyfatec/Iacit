from leituraDfs import LeituraDfs
from automacao import Automacao
import glob


class RunFunctions:

    @staticmethod
    def dados_inicial():

        ldfs = LeituraDfs()

        print("Iniciando script de download automático...\n")
        Automacao.auto_run()

        print("Iniciando povoamento tabela estação...\n")
        ldfs.leitura_cabecalho(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2020\*.csv", recursive=True))
        ldfs.leitura_cabecalho(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2021\*.csv", recursive=True))
        ldfs.leitura_cabecalho(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True))

        print("\nIniciando povoamento das demais tabelas...\n")
        ldfs.leitura_dfs(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2020\*.csv", recursive=True))
        ldfs.leitura_dfs(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2021\*.csv", recursive=True))
        ldfs.leitura_dfs(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True))

    @staticmethod
    def dados_atualizacao():

        ldfs = LeituraDfs()

        print("Iniciando script de download automático...\n")
        #Automacao.auto_run()

        print("\nIniciando povoamento tabela estação...\n")
        ldfs.leitura_cabecalho(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True))

        print("\nIniciando povoamento das demais tabelas...\n")
        ldfs.leitura_dfs(glob.glob(r"C:\Users\**\Iacit\CSVs\DF\2022\*.csv", recursive=True))


#RunFunctions.dados_inicial()

RunFunctions.dados_atualizacao()

