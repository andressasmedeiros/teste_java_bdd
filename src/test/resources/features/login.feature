# language: pt
Funcionalidade: Login no sistema

  Cenário: Login com sucesso
    Dado que o usuário acessa a página de login
    Quando ele informa usuário "standard_user" e senha "secret_sauce"
    E clica no botão de login
    Então ele deve ser redirecionado para a página de produtos

  Cenário: Login inválido
    Dado que o usuário acessa a página de login
    Quando ele informa usuário "invalid_user" e senha "secret_invalid"
    E clica no botão de login
    Então deve ver uma mensagem de erro