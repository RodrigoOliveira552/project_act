Feature: Cadastro de usuário
  Como um usuário
  Eu quero criar uma nova conta
  Para que eu possa acessar os serviços do site
  Scenario: Criar uma nova conta
    Given que estou na página inicial
    When eu navego até a opção de login
    And clico em "Criar uma conta"
    And preencho o formulário de criação de conta com dados válidos
    And clico no botão "Criar conta"
    Then eu devo ver a mensagem "Estamos quase lá..."
    And devo ter a opção de "Continuar navegando"