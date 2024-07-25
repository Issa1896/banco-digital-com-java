# Banco Digital com Spring Boot

Este projeto é uma aplicação web simples para um banco digital, implementada utilizando Spring Boot, Spring Security e Thymeleaf. Ele oferece funcionalidades básicas como login, logout, e operações de conta bancária, com o objetivo de demonstrar o uso de tecnologias populares em Java para a construção de uma aplicação web segura e funcional.

## Funcionalidades

- **Autenticação e Autorização**: Sistema de login e logout com Spring Security.
- **Gerenciamento de Contas**: Criação de contas bancárias e operações básicas como depósito e saque.
- **Interface Web**: Páginas de login, dashboard e home construídas com Thymeleaf.
- **Segurança**: Controle de acesso às páginas e funcionalidades, permitindo apenas usuários autenticados.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.0**
- **Spring Security**
- **Thymeleaf**
- **Maven** (para gerenciamento de dependências)
- **H2 Database** (para persistência de dados em memória)

## Estrutura do Projeto

- **src/main/java/com/example/banco**: Contém os arquivos de código-fonte da aplicação.
  - **config**: Configurações de segurança.
  - **controller**: Controladores que lidam com as requisições HTTP.
  - **model**: Entidades do domínio do banco.
  - **repository**: Interfaces de repositório para acesso ao banco de dados.
  - **service**: Contém a lógica de negócios.
  
- **src/main/resources/templates**: Páginas HTML Thymeleaf para renderizar a interface do usuário.
- **src/main/resources/static/css**: Arquivos CSS para estilização das páginas.

## Pré-requisitos

- **Java 11** ou superior
- **Maven** (para gerenciamento de dependências e execução da aplicação)

## Como Executar o Projeto

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/Issa1896/banco-digital-com-java.git
   cd banco-digital
   ```

2. **Compile o projeto:**

   ```sh
   mvn clean install
   ```

3. **Execute a aplicação:**

   ```sh
   mvn spring-boot:run
   ```

4. **Acesse a aplicação:**

   Abra o navegador e vá para `http://localhost:8080`.

5. **Credenciais de Acesso:**

   - **Usuário**: `user`
   - **Senha**: `password`

## Endpoints Disponíveis

- **GET /home**: Página inicial pública.
- **GET /login**: Página de login.
- **GET /dashboard**: Página de dashboard após login.

## Segurança

Este projeto utiliza autenticação em memória para simplicidade. Para uma aplicação de produção, é recomendável usar autenticação baseada em banco de dados ou outro serviço de autenticação seguro.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias e correções.



## Contato

Para dúvidas ou sugestões, entre em contato em [marcelinoissacunha@gmail.com](mailto:marcelinoissacunha@gmail.com).