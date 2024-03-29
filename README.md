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
 
 - Subir o docker do MongoDB
   - entrar na pasta do MongoDB dentro do projeto. Caminho: ``${PROJETO}/docker/mongodb/``
   - editar o arquivo docker-compose.yml para trocar o volume onde será salvo os dados no host, caso necessário.
    ```
      ...
      volumes: 
        - /tmp/mongodb:/data/db
    ```
   - executar o comando ``docker-compose up -f ${PROJETO}/docker/mongodb/docker-compose.yml``
 - Fazer a carga de produtos.
   - ainda na pasta do MongoDB, editar o arquivo load_dataset.sh e informar o PATH do volume.
   - executar o shell com o comando: ``./load_dataset.sh``

#### SWAGGER - Documentação da API

- Importar o projeto como maven project na IDE.
- Adicionar o servidor de aplicação, preferência WildFly.
- Subir o servidor.
- Acessar a ulr http://localhost:8080/desafio-luizalabs/swagger/#/

#### API's
- Importar o projeto como maven projeto na IDE.
- Adicionar o servidor de aplicação, preferência WildFly.
- Subir o servidor.
- Importar os arquivos para o Postman. Os arquivos podem ser encontrados no caminho ``${PROJETO}/postman``
  - loging-postman
  - client-postman
  - product-postam
- Executar o script a desejar.

***OBS: Antes de chamar as API's, é preciso gerar um token no login. Com o token gerado, é necesário adicionar o header Authorization com o token nas requisições.***

#### SEGURANÇA

Foi implementado uma segurança básica, baseado no JWT (Json Web Token). A classe JWTFilter fica responsável por interceptar os requests e verificar se o token passado no Header Authorization é válido, conferindo as credenciais.

Não foi implementado a parte de armazenamento de senha do usuario. Por isso o usuário **admin** e senha **admin** estão hardcoded.

#### TESTES

Foram testadas apenas as classes de serviço, no pacote service, isso porque toda a regra negocial fica nessa camada. Segue abaixo o relatório do **JACOCO**.

***OBS: Para extrair o relatório basta executar o comando ``mvn test site -P jacoco``***

![Alt Relatório Jacoco](./assets/testes.png)

