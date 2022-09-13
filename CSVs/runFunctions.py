from leituraDfs import LeituraDfs
from automacao import Automacao


class RunFunctions:

    @staticmethod
    def dados_inicial():

        print("Iniciando povoamento tabela estação...\n")
        LeituraDfs.leitura_cabecalho2022()
        LeituraDfs.leitura_cabecalho2021()
        LeituraDfs.leitura_cabecalho2020()

        print("\nIniciando povoamento das demais tabelas...\n")
        LeituraDfs.leitura_dfs2020()
        LeituraDfs.leitura_dfs2021()
        LeituraDfs.leitura_dfs2022()

    @staticmethod
    def dados_atualizacao():

        print("Iniciando script de download automático...\n")
        Automacao.auto_run()

        print("\nIniciando povoamento tabela estação...\n")
        LeituraDfs.leitura_cabecalho2022()

        print("\nIniciando povoamento das demais tabelas...\n")
        LeituraDfs.leitura_dfs2022()


#RunFunctions.dados_inicial()

RunFunctions.dados_atualizacao()

