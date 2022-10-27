from leituraDfs import LeituraDfs
from automacao import Automacao


class RunFunctions:

    @staticmethod
    def dados_inicial():

        ldfs = LeituraDfs()

        print("Iniciando script de download automático...\n")
        Automacao.auto_run()

        print("Iniciando povoamento tabela estação...\n")
        ldfs.leitura_cabecalho('2020')
        ldfs.leitura_cabecalho('2021')
        ldfs.leitura_cabecalho('2022')

        print("\nIniciando povoamento das demais tabelas...\n")
        ldfs.leitura_dfs('2020')
        ldfs.leitura_dfs('2021')
        ldfs.leitura_dfs('2022')

    @staticmethod
    def dados_atualizacao():

        ldfs = LeituraDfs()

        print("Iniciando script de download automático...\n")
        #Automacao.auto_run()

        print("\nIniciando povoamento tabela estação...\n")
        ldfs.leitura_cabecalho('2022')

        print("\nIniciando povoamento das demais tabelas...\n")
        #ldfs.leitura_dfs('2022')


#RunFunctions.dados_inicial()

RunFunctions.dados_atualizacao()

