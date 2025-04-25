# SafeBank API - WebAPI em Java

## Sobre o Projeto
Este projeto é uma WebAPI desenvolvida em Java com Spring Boot para gerenciamento de contas bancárias. Ele implementa um CRUD utilizando banco de dados Oracle e segue boas práticas de arquitetura como DDD, MappingConfig, Migrations e Scaffolding. A documentação da API é gerada automaticamente com Swagger.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Oracle Database
- Swagger
- Lombok
- Docker

## Funcionalidades
- Criar, consultar, atualizar e excluir contas bancárias
- Operações de depósito e saque
- Autenticação e autorização

## Estrutura do Projeto
```plaintext
📂 BankAPI
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/com/bankapi
 ┃ ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┣ 📂 entity
 ┃ ┃ ┃ ┣ 📂 config
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📜 application.yml
 ┣ 📜 pom.xml
 ┣ 📜 README.md
```

## Como Executar
1. Clone o repositório:
   ```sh
   git clone <https://github.com/SouzaEu/SafeBank-API>
   ```
2. Configure a string de conexão com o Oracle no `application.yml`
3. Compile o projeto:
   ```sh
   mvn clean install
   ```
4. Rode a aplicação:
   ```sh
   mvn spring-boot:run
   ```
5. Acesse o Swagger para testar a API:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Endpoints
- `GET /api/contas` - Lista todas as contas
- `GET /api/contas/{id}` - Obtém uma conta pelo ID
- `POST /api/contas` - Cria uma nova conta
- `PUT /api/contas/{id}` - Atualiza uma conta existente
- `DELETE /api/contas/{id}` - Remove uma conta

## Contribuição
Sinta-se à vontade para abrir issues e enviar pull requests.

## Licença
Este projeto está sob a licença MIT.
