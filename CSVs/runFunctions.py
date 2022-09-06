from leituraDfs import LeituraDfs


class RunFunctions:

    @staticmethod
    def dados_inicial():

        print("Iniciando povoamento tabela estação...")
        LeituraDfs.leitura_cabecalho2022()
        LeituraDfs.leitura_cabecalho2021()
        LeituraDfs.leitura_cabecalho2020()

        print("Iniciando povoamento das demais tabelas...")
        LeituraDfs.leitura_dfs2020()
        LeituraDfs.leitura_dfs2021()
        LeituraDfs.leitura_dfs2022()

    @staticmethod
    def dados_atualizacao():

        print("Iniciando povoamento tabela estação...")
        LeituraDfs.leitura_cabecalho2022()

        print("Iniciando povoamento das demais tabelas...")
        LeituraDfs.leitura_dfs2022()


#RunFunctions.dados_inicial()

#RunFunctions.dados_atualizacao()

