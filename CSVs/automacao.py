class Automacao: 
    def auto_run():   
        import os
        import requests #pip install requests
        from datetime import date
        import zipfile
        import shutil #pip install shutil
        import logging

        # Criando a variavel do ano atual para o url
        date_td = date.today()
        year_td = date_td.year

        # Para cada ano de 2020 até o ano atual executar o codigo
        for i in range(1998, 1999):

            # Função para baixar os csv's
            def download_df(url, endereco):
                try:
                    # try - except para criar um novo diretorio para os arquivos do ano
                    try:
                            os.mkdir("DF/{}".format(i))
                    except:
                        shutil.rmtree(f"DF/{i}", ignore_errors=False, onerror=None)
                        os.mkdir("DF/{}".format(i))
                    status = requests.get(url)
                    if status.status_code == requests.codes.OK:
                        with open(endereco, "wb") as novo_arquivo:
                            novo_arquivo.write(status.content)
                    
                    else:
                        status.raise_for_status()
                
                except:
                    logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                        format="%(asctime)s %(message)s", filemode="a")
                    logging.exception("- ERRO")
                    raise


            try:
                if __name__ == "__main__":
                
                    BASE_URL = "https://portal.inmet.gov.br/uploads/dadoshistoricos/{}.zip"
                    nome_arquivo = os.path.join("DF","{}.zip".format(i))
                    
                    download_df(BASE_URL.format(i), nome_arquivo)
            
            except:
                logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                    format="%(asctime)s %(message)s", filemode="a")
                logging.exception("- ERRO")
                raise

                    
                    

                # Função para extrair os arquivos
            try:    
                def extract ():
            
                    zip_ref = zipfile.ZipFile("DF/{}.zip".format(i), "r")
                    reference = ("DF/{}".format(i))
                    zip_ref.extractall(reference)
                    zip_ref.close()
                    os.remove("DF/{}.zip".format(i))
                    print("{}Extraido".format(i))

                extract()
            
            except:
                logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                                    format="%(asctime)s %(message)s", filemode="a")
                logging.exception("- ERRO")
                raise   


    auto_run()












