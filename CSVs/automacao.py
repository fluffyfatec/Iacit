import os
import requests
from datetime import date
import zipfile
import shutil
import logging


class Automacao:

    @staticmethod
    def download_df(ano):
        url = "https://portal.inmet.gov.br/uploads/dadoshistoricos/{}.zip".format(ano)
        endereco = os.path.join("DF","{}.zip".format(ano))
        try:
            os.mkdir("DF/{}".format(ano))   
        except:
            shutil.rmtree(f"DF/{ano}", ignore_errors=False, onerror=None)
            os.mkdir("DF/{}".format(ano))

        status = requests.get(url)

        if status.status_code == requests.codes.OK:
            with open(endereco, "wb") as novo_arquivo:
                novo_arquivo.write(status.content) 
        else:
            status.raise_for_status()
        return

    @staticmethod
    def extract(ano):
        zip_ref = zipfile.ZipFile("DF/{}.zip".format(ano), "r")
        reference = ("DF/{}".format(ano))
        zip_ref.extractall(reference)
        zip_ref.close()
        os.remove("DF/{}.zip".format(ano))
        print("{} Extraido".format(ano))
        return

    @staticmethod
    def auto_run():
    
        # Criando a variavel do ano atual 
        date_td = date.today()
        year_td = date_td.year

        # Para cada ano de 2020 até o ano atual executar o codigo
        for i in range(2020, year_td + 1):
            try:
                Automacao.download_df(i)
            
            except:
                logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                    format="%(asctime)s %(message)s", filemode="a")
                logging.debug("- ERRO: o download dos CSVs não foi realizado (CSVs/automacao.py)")
                raise


            try:    
                Automacao.extract(i)

            except:
                logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                    format="%(asctime)s %(message)s", filemode="a")
                logging.debug("- ERRO: a extração dos CSVs não foi realizada (CSVs/automacao.py")
                raise
        return

