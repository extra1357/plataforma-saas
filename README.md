Plataforma SaaS Multi-tenant
Esta é uma aplicação SaaS multi-tenant desenvolvida com Spring Boot no back-end e Angular no front-end. O projeto demonstra uma arquitetura escalável e segura para gerenciar dados de múltiplos clientes de forma isolada.

Funcionalidades Principais
Arquitetura Multi-tenant: Demonstra a separação e o gerenciamento de dados de cada cliente (tenant) utilizando schemas de banco de dados distintos.

API RESTful: O back-end expõe uma API robusta para gerenciamento de tenants, usuários e outros recursos.

Front-end com Angular: Uma interface moderna e responsiva para interagir com a aplicação.

Segurança com JWT: Autenticação e autorização para proteger as rotas da API.

Documentação da API com Swagger: A API é totalmente documentada e pode ser testada interativamente.

Tecnologias Utilizadas
Back-end: Java 17, Spring Boot, Spring Security, Maven, JWT, PostgreSQL.

Front-end: Angular, TypeScript.

Como Rodar a Aplicação
Siga os passos abaixo para iniciar o back-end e o front-end.

1. Back-end
Certifique-se de que sua aplicação Spring Boot está configurada com um banco de dados PostgreSQL.

Navegue até a pasta do back-end:

cd backend
Inicie a aplicação:

mvn spring-boot:run
A API estará disponível em http://localhost:8080.

2. Front-end
Navegue até a pasta do front-end:

cd front-end
Instale as dependências do Node.js:

npm install
Inicie a aplicação Angular:

ng serve
O front-end estará disponível em http://localhost:4200.

Documentação da API
Para acessar a documentação interativa da API, abra seu navegador e vá para:

http://localhost:8080/swagger-ui.html


