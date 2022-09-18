## Primeiro Passo

#### É necessário baixar e instalar as seguintes dependências

[Python 3.10.7](https://www.python.org/downloads/release/python-3107/)

[Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

[Pycharm](https://www.jetbrains.com/pt-br/pycharm/download/#section=windows)

[Postgresql](https://www.postgresql.org/download/)

[PgAdmin4 v6.13](https://www.pgadmin.org/download/pgadmin-4-windows/)

[Maven 3.8.6](https://maven.apache.org/download.cgi)

[Eclipse](https://www.eclipse.org/downloads/)

[Backup de dados](https://drive.google.com/drive/u/1/folders/13slRhWn9fGm5K1iX7diME-HEfcZbHMt0)


## Segundo Passo

#### Postgresql


1- No diretório "C:" da maquina criar uma pasta "sql" e adicionar o backup dentro da pasta

2- Ir até em variavéis de ambientes, duplo click no ir "path", adicionar um novo, selecionar a opção "browser" no lado direito, ir até o diretório C>Arquivos de Programa>Postgreesql>bin e adicionar.

3- Subir a pioridade do bin dentro do path com o botão mover pra cima 

4- Caso seja de interesse ir até o arquivo DB_IACIT.bat na pasta "DATABASE" do projeto e editar dentro do arquivo o password do usuário "postgress"
5- Por fim rodar o bat que foi instalado e adicionado na pasta "sql" no diretório "C:"


#### Python 
Adicionar a pasta "CSV" do projeto no diretório "C:" depois abrir o projeto no Pycharm e rodar a classe  "RunFunctions"

#### Eclipse 

Instale o [Lombok](https://projectlombok.org/setup/eclipse) e siga o tutorial, depois importe o projeto maven "Iacit" e mude o seu acesso postgre no arquivo application.properties, após isso rode a classe main.
