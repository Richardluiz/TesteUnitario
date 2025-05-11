# 🧩 Projeto Spring Boot - CRUD de Usuários e Endereços

Este é um projeto desenvolvido como parte de uma avaliação prática da disciplina de **Desenvolvimento Web com Spring Boot**. A aplicação implementa um sistema completo de gerenciamento de **Usuários** e seus respectivos **Endereços**, utilizando a arquitetura REST, com persistência de dados em **MariaDB**.

---

## 📚 Objetivos da Atividade

- Desenvolver uma aplicação Spring Boot com duas entidades diferentes relacionadas entre si.
- Implementar um CRUD completo para ambas as entidades.
- Utilizar Spring Data JPA para persistência de dados.
- Documentar a API com Swagger.
- Utilizar boas práticas de organização em pacotes (MVC).
- Realizar testes locais com banco MariaDB.

---

## 🛠️ Tecnologias e Ferramentas

- Java 17+
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- MariaDB
- Maven
- Lombok
- Swagger/OpenAPI
- Docker & Docker Compose (opcional)

---

## 🗃️ Estrutura do Projeto

src/
└── main/
├── java/
│ └── com.user.users/
│ ├── UsersApplication.java
│ ├── model/
│ │ ├── User.java
│ │ └── Endereco.java
│ ├── repository/
│ │ ├── UserRepository.java
│ │ └── EnderecoRepository.java
│ └── controller/
│ ├── UserController.java
│ └── EnderecoController.java
└── resources/
└── application.properties

yaml
Copiar
Editar

---

## 🔄 Relacionamento das Entidades

- Um **usuário** pode ter **um ou mais endereços**.
- Relacionamento do tipo **@OneToMany** entre `User` e `Endereco`.

---

## 📦 Funcionalidades Implementadas

### Usuários
- `GET /users` – Listar todos os usuários
- `GET /users/{id}` – Buscar um usuário por ID
- `POST /users` – Criar um novo usuário
- `PUT /users/{id}` – Atualizar um usuário
- `DELETE /users/{id}` – Remover um usuário

### Endereços
- `GET /enderecos` – Listar todos os endereços
- `GET /enderecos/{id}` – Buscar um endereço por ID
- `POST /enderecos` – Criar novo endereço (vinculado a um usuário)
- `PUT /enderecos/{id}` – Atualizar um endereço
- `DELETE /enderecos/{id}` – Remover um endereço

---

## ⚙️ Configuração do Banco de Dados

### `application.properties`

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect









### 🚀 Swagger

Para documentar e testar a API de forma interativa, utilizamos o **Swagger** através da biblioteca `springdoc-openapi`.

Adicione as seguintes configurações no `application.properties`:

```properties
# Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
🐳 Docker (opcional)
Se desejar subir o banco de dados MariaDB via Docker, crie o arquivo docker-compose.yml com o seguinte conteúdo:

yaml
Copiar
Editar
version: '3.8'
services:
  mariadb:
    image: mariadb:10.6
    container_name: mariadb
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: userdb
    ports:
      - "3306:3306"
    volumes:
      - mariadb_data:/var/lib/mysql

volumes:
  mariadb_data:
🔼 Suba o container com:
bash
Copiar
Editar
docker-compose up -d
▶️ Como Executar
Certifique-se de que o banco MariaDB está rodando localmente ou via Docker.

Compile o projeto com Maven:

bash
Copiar
Editar
mvn clean package
Execute a aplicação:

bash
Copiar
Editar
java -jar target/users-0.0.1-SNAPSHOT.jar
📘 Acessando o Swagger
Após a aplicação estar rodando, acesse a documentação interativa da API via navegador:

Swagger UI: http://localhost:8080/swagger-ui.html

API Docs: http://localhost:8080/api-docs

🔍 Exemplo de Requisições JSON
POST /users
json
Copiar
Editar
{
  "nome": "Maria Oliveira",
  "email": "maria@example.com"
}
POST /enderecos
json
Copiar
Editar
{
  "rua": "Rua das Palmeiras",
  "numero": "123",
  "cidade": "São Paulo",
  "estado": "SP",
  "userId": 1
}
🧪 Testes
A aplicação pode ser facilmente estendida com testes utilizando:

JUnit 5

Mockito

Testcontainers (para testes com banco em container Docker)

✅ Conclusão
Esta aplicação atendeu aos requisitos propostos da avaliação, implementando um CRUD completo com duas entidades relacionadas, seguindo boas práticas de organização de código, persistência em banco de dados relacional, e documentação da API REST com Swagger.

👤 Autor
Desenvolvido por [Seu Nome Aqui]
Atividade prática da disciplina: Desenvolvimento Web com Spring Boot

📄 Licença
Projeto de uso educacional e acadêmico.

yaml
Copiar
Editar
