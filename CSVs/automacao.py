def auto_run():   
    import os
    import requests
    from datetime import date
    import zipfile
     # Criando a variavel do ano atual para o url
    date_td = date.today()
    year_td = date_td.year
    
    # Função para baixar os csv's
    def download_df(url, endereco):
        # try - except para criar um novo diretorio para os arquivos do ano
        try:
                os.mkdir('DF/{}'.format(year_td))
                print("Diretorio {} criado".format(year_td))
        except:
            print("O diretorio {} já existe".format(year_td))
        status = requests.get(url)
        if status.status_code == requests.codes.OK:
            with open(endereco, 'wb') as novo_arquivo:
                novo_arquivo.write(status.content)
            print("Donwload finalizado. Salvo em: {}".format(endereco))
           
            
        else:
            status.raise_for_status()

    if __name__ == "__main__":
        
        BASE_URL = 'https://portal.inmet.gov.br/uploads/dadoshistoricos/{}.zip'
        nome_arquivo = os.path.join("DF","{}".format(year_td),'{}.zip'.format(year_td))
        
        download_df(BASE_URL.format(year_td), nome_arquivo)
        

        # Função para extrair os arquivos
        def extract ():

                zip_ref = zipfile.ZipFile(f'DF/{year_td}/{year_td}.zip', 'r')
                reference = ("DF/{}".format(year_td))
                zip_ref.extractall(reference)
                zip_ref.close()
                print(f"Arquivos extraidos em {reference}")

        extract()

auto_run()












