# TesteUnitario

# Projeto Spring Boot - Gerenciamento de Usuários

Este projeto é uma aplicação simples construída com **Spring Boot**, utilizando **JPA/Hibernate** para persistência e **MariaDB** como banco de dados relacional. A aplicação faz parte de uma atividade prática e tem como objetivo implementar operações básicas de CRUD para a entidade `User`.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.4.5
- Spring Data JPA
- Hibernate
- MariaDB 10.4+
- Maven
- HikariCP (Gerenciador de Conexões)

---

## 📁 Estrutura do Projeto

src/
└── main/
├── java/
│ └── com.user.users/
│ ├── UsersApplication.java
│ └── model/
│ └── repository/
│ └── controller/
└── resources/
├── application.properties
└── schema.sql (opcional)

yaml
Copiar
Editar

---

## ⚙️ Configuração

### Banco de Dados

Antes de rodar a aplicação, **crie o banco de dados no MariaDB com o nome correto**. Exemplo:

```sql
CREATE DATABASE user;
⚠️ O erro abaixo ocorre se o banco de dados user não existir:

pgsql
Copiar
Editar
SQL Error: 1049, SQLState: 42000
Unknown database 'user'
application.properties
properties
Copiar
Editar
spring.datasource.url=jdbc:mariadb://localhost:3306/user
spring.datasource.username=root
spring.datasource.password=senha
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
▶️ Executando a Aplicação
No terminal ou IDE (VS Code, IntelliJ, etc.):

bash
Copiar
Editar
./mvnw spring-boot:run
Ou compile e execute:

bash
Copiar
Editar
./mvnw clean package
java -jar target/users-0.0.1-SNAPSHOT.jar
❗ Possíveis Erros
❌ Unknown database 'user'
Esse erro indica que o banco de dados especificado não foi encontrado. Solução:

Verifique se o banco existe com SHOW DATABASES;

Crie-o se necessário: CREATE DATABASE user;

🧪 Testes
Os testes ainda não foram implementados, mas poderão ser adicionados com:

JUnit

Spring Boot Test

👨‍💻 Autor
Desenvolvido como parte de uma avaliação prática da disciplina de Desenvolvimento Web com Spring Boot.

📄 Licença
Este projeto é apenas para fins educacionais.
