# Desafio LuizaLabs

## Requisitos
Os requisitos abaixo será ser instalados addos no en

+ maven3
+ docker
+ docker-compose
+ IDE (Eclipse, Intellij)
+ Postman
 
## Passo a passo

##### MONGODB
 
 1. Subir o docker do MongoDB
 - entrar na pasta do MongoDB dentro do projeto. Caminho: ${PROJETO}/docker/mongodb/
 - editar o arquivo docker-compose.yml para trocar o volume onde será salvo os dados no host, caso necessário.
    ```
      ...
      volumes: 
        - /tmp/mongodb:/data/db
    ```
 - executar o comando ``docker-compose up -f ${PROJETO}/docker/mongodb/docker-compose.yml``
 2. Fazer a carga de produtos.
 - ainda na pasta do MongoDB, editar o arquivo load_dataset.sh e informar o PATH do volume.
 - executar o shell com o comando: ``./load_dataset.sh``

#### SWAGGER - Documentação da API

1. Importar o projeto como maven projeto na IDE.
2. Adicionar o servidor de aplicação, preferência WildFly.
3. Subir o servidor.
4. Acessar a ulr http://localhost:8080/desafio-luizalabs/swagger/#/

#### API's
1. Importar o projeto como maven projeto na IDE.
2. Adicionar o servidor de aplicação, preferência WildFly.
3. Subir o servidor.
4. Importar os arquivos para p Postman:
  - loging-postman
  - client-postman
  - product-postam
5. Executar o script a desejar.

**OBS: Antes de chamar as API's, deve gerar um token no login. Com o token gerado, é necesário adicionar o header Authorization com o token nas requisições.**
