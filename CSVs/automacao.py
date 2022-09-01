import os
import requests
from datetime import date
# Função para baixar os csv's
def download_df(url, endereco):
    status = requests.get(url)
    if status.status_code == requests.codes.OK:
        with open(endereco, 'wb') as novo_arquivo:
            novo_arquivo.write(status.content)
        print("Donwload finalizado. Salvo em: {}".format(endereco))
    else:
        status.raise_for_status()

if __name__ == "__main__":
    
    # Criando a variavel do ano atual para o url
    date_td = date.today()
    year_td = date_td.year
    
    BASE_URL = 'https://portal.inmet.gov.br/uploads/dadoshistoricos/{}.zip'
    nome_arquivo = os.path.join("DF", '{}.zip'.format(year_td))
    download_df(BASE_URL.format(year_td), nome_arquivo)














