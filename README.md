# Projeto de Testes Automatizados em Aplicação Web

Este projeto contém uma série de Testes Automatizados desenvolvidos para validar funcionalidades de Criação de conta, Login e Busca por pacotes de viagens no site Hurb, mais conhecido como Hotel Urbano.

## Funcionalidades Testadas

- **Criação de Conta:** Realização do processo para se criar uma conta de um novo usuário.
- **Login:** Validações do login com credenciais válidas e inválidas.
- **Logout:** Validamos se o usuário consegue se desconectar corretamente da aplicação.
- **Busca de Pacotes existentes:** Velidamos a busca por pacotes de viagem existentes.
- **Busca de Pacotes inexistentes ou indisponíveis:** Velidamos a busca por pacotes de viagem inexistentes ou indisponíveis.

## Estrutura do Projeto

- **`BaseTest.java`**: Contém métodos que podem ser reutilizáveis para configurações e ações comuns, como abrir o navegador, realizar login e criar contas.
- **`Login.java`**: Onde temos os nossos testes para as funcionalidades mencionadas, utilizando os métodos da classe `BaseTest`.

## Requisitos

- **IDE de sua preferência** (aqui usei o Intellij)
- **Java 8+** (aqui usei o 11)
- **Maven e suas dependências** (algumas utilizadas aqui foram JUnit, Cucumber e Selenium presentes lá no pom.xml)
- **ChromeDriver** (importante que ele seja compatível com a versão do seu Chrome instalado)
- **JUnit 4+**
- **Selenium WebDriver**

## Configuração do Ambiente

1. Clone este repositório:
   ```bash
   git clone https://github.com/username/repository.git

2. Navegue até o diretório do projeto:
   ```bash
   cd repository

3. Instale as dependências do Maven:
   ```bash
   mvn clean install

## Executando os Testes
Para executar os testes, você pode de forma simples abrir e executar, após baixar, diretamente em em sua IDE (Eclipse, VScode ou IntelliJ, etc.)
Ou você pode também, utilizar o Maven com o seguinte comando:
  ```bash
   mvn test
