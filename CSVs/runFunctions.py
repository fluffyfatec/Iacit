from leituraDfs import LeituraDfs
from automacao import Automacao


class RunFunctions:

    if __name__ == '__main__':

        ldfs = LeituraDfs()

        print("Iniciando script de download automático...\n")
        Automacao.auto_run()

        print("\nIniciando povoamento tabela estação...\n")
        ldfs.leitura_cabecalho('2022')

        print("\nIniciando povoamento das demais tabelas...\n")
        ldfs.leitura_dfs('2022')







