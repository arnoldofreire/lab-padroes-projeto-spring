# Lab Padrões de Projeto com Spring Boot

## O que o projeto faz
Uma API REST para cadastro de clientes que utiliza a API pública do ViaCEP para preencher automaticamente o endereço do cliente a partir do CEP informado. O projeto demonstra a aplicação prática de Padrões de Projeto (Design Patterns) com Spring Boot.

## Tecnologias Usadas
- Java 17
- Spring Boot 4.x
- Spring Data JPA
- Banco de Dados H2 (em memória)
- RestClient (Spring Web) para consumo da API ViaCEP

## Padrões de Projeto Aplicados
- **Singleton:** Todos os `@Service` e `@Repository` são gerenciados como instâncias únicas pelo contêiner do Spring.
- **Strategy:** O `ClienteRepository` e o `ViaCepService` são interfaces que definem contratos. A implementação concreta (`ViaCepServiceImpl`) pode ser trocada sem afetar o resto do sistema.
- **Facade:** A classe `ClienteServiceImpl` atua como uma fachada. Ela esconde a complexidade de buscar o CEP, salvar o endereço e salvar o cliente atrás de um único método `inserir()`.
- **Builder (Evolução):** Adicionado no `Cliente` e no `Endereco` para facilitar a criação de objetos complexos de forma fluida e legível.

## Como executar
1. Clone o repositório.
2. Na raiz do projeto, execute: `.\mvnw spring-boot:run`
3. A API estará disponível em `http://localhost:8080`.

## Como testar o fluxo principal
Com a aplicação rodando, abra outro terminal e envie uma requisição POST:

```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Arnoldo","endereco":{"cep":"01001000"}}'

  