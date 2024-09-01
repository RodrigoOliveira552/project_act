# Projeto de Testes Automatizados utilizando Intellij, Maven, Selenium WebDriver, Selenium IDE, Linguagem de Programação Java e JUnit

Este projeto contém uma série de testes automatizados desenvolvidos para validar funcionalidades de login, criação de conta e busca de pacotes de viagem no site Hurb.

## Funcionalidades Testadas

- **Criação de Conta:** Verifica se um novo usuário pode se registrar com sucesso.
- **Login:** Valida o login com credenciais válidas e inválidas.
- **Logout:** Testa se o usuário consegue se desconectar corretamente.
- **Busca de Pacotes:** Verifica a busca por pacotes de viagem existentes e inexistentes.

## Estrutura do Projeto

- **`BaseTest.java`**: Contém métodos reutilizáveis para configuração e ações comuns, como abrir o navegador, realizar login e criar contas.
- **`Login.java`**: Define os testes para as funcionalidades mencionadas, utilizando os métodos da classe `BaseTest`.

## Requisitos

- **Java 8+**
- **Maven**
- **ChromeDriver** (compatível com a versão do Chrome instalada)
- **JUnit 4+**
- **Selenium WebDriver**

## Configuração do Ambiente

1. Clone este repositório:
   ```bash
   git clone https://github.com/username/repository.git
