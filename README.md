# 🧪 Prática: Testes Unitários e Mocking em Spring Boot

## 🎯 Objetivo

O objetivo desta atividade prática foi **implementar e validar testes unitários** para um controlador de usuários em uma aplicação Spring Boot, utilizando os frameworks **JUnit 5** e **Mockito**.

---

## ⚙️ Tecnologias Utilizadas

- Java 11 ou superior  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring DevTools  
- MariaDB  
- JUnit 5  
- Mockito  

---

## ✅ Passos da Atividade

### 1. Configuração do Ambiente

- Projeto previamente configurado com:
  - `Spring Boot`, `Spring Web`, `Spring Data JPA`
  - Banco de dados **MariaDB** conectado corretamente
- Dependências para testes incluídas no `pom.xml`:
  - **JUnit 5**
  - **Mockito**

### 2. Implementação dos Testes

- Foram criados testes unitários para o **controlador de usuários**.
- As dependências externas foram simuladas com o uso de **Mockito**, permitindo a validação isolada da lógica de negócio.
- Métodos testados incluíram: criação, busca, atualização e exclusão de usuários.

### 3. Execução dos Testes

- Os testes foram executados com sucesso utilizando a IDE ou via Maven:
  
```bash
./mvnw test
Todos os testes passaram corretamente ✅

Eventuais falhas durante a execução foram identificadas, corrigidas e revalidadas.

📝 ##Relatório de Alterações
Adição de classes de teste no pacote src/test/java.

Uso de anotações como @Mock, @InjectMocks, @BeforeEach para setup dos testes.

Criação de cenários com retorno simulado (when(...).thenReturn(...)).

Correções pontuais em métodos do controlador, detectadas durante os testes.

📌 ##Exemplo de Teste com Mockito
java
Copiar
Editar
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    void testCriarUsuario() {
        User user = new User("Maria", "maria@example.com");
        when(userRepository.save(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.criarUsuario(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Maria", response.getBody().getNome());
    }
}
##📄 Conclusão
Esta prática foi essencial para consolidar o uso de testes unitários e mocking em aplicações Spring Boot, garantindo qualidade e confiabilidade no código. A abordagem testada permite fácil manutenção e evolução da aplicação ao longo do tempo.

##👤 Autor
Desenvolvido por [Richard Luiz]
Atividade prática de Desenvolvimento Web com Spring Boot

##📚 Licença
Este projeto tem finalidade educacional e acadêmica.
