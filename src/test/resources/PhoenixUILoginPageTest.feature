Feature: Login page test

  Background:
    Given User navigates to login page


#    Verify elements and languages

  Scenario: Verify elements visibility - Login page
    Then Phoenix logo is visible
    And Login form is visible
    And Change language button is visible
    And Trade Up logo is visible

  Scenario Outline: Verify links - Login page
    And User clicks Change language button
    And User select English
    When User clicks "<link>" link
    Then "<page>" page opens

    Examples:
      | link                 | page        |
      | Forgot your password | /forgotpass |
      | Create an account    | /register   |

  Scenario Outline: Verify language switch
    When User clicks Change language button
    And User select "<language>" language
    Then Greeting message "<greeting_text>" is visible
    And Login button text is "<login_button>"
    And Create an account button text is "<create_account_link>"
    And Forgot your password text is "<forgot_password_link>"

    Examples:
      | language   | greeting_text       | login_button | create_account_link      | forgot_password_link  |
      | English    | Welcome to          | Log in       | Create an account        | Forgot your password? |
      | Русский    | Добро пожаловать на | Вход         | Создать аккаунт          | Забыли пароль?        |
      | Українська | Ласкаво просимо на  | Вхід         | Створити обліковий запис | Забули пароль?        |
      | Portuguesa | Bem-vindo a         | Entrar       | Crie uma conta           | Esqueceu sua senha?   |


#   Positive tests

  Scenario: Verify successful login and username
    When User types valid email in the Email field
    And User types valid password in the Password field
    And User clicks Login button
    Then Main page with correct username opens
    Given Click Log Out button

#   Negative tests

  Scenario Outline: Verify incorrect user password and email
    And User clicks Change language button
    And User select English
    When User types "<email>" in the Email field
    And User types "<pass>" in the Password field
    And User clicks Login button
    Then Error massage is visible

    Examples:
      | email                                                                                                                                                              | pass                                                                     |
      | legion.qaservices@gmail.com                                                                                                                                        | incorret123456789                                                        |
      | legion.qaservices@gmail.com                                                                                                                                        |                                                                          |
      | legion.qaservices@gmail.com                                                                                                                                        | 0                                                                        |
      | legion.qaservices@gmail.com                                                                                                                                        | null                                                                     |
      | legion.qaservices@gmail.com                                                                                                                                        | @#$%^&*(                                                                 |
#      | legion.qaservices@gmail.com                                                                                                                                        | """""""""                                                                |
      | incorrect@gmail.com                                                                                                                                                | legion777                                                                |
      |                                                                                                                                                                    | legion777                                                                |
      | 0                                                                                                                                                                  | legion777                                                                |
      | null                                                                                                                                                               | legion777                                                                |
      | #$%^&*(                                                                                                                                                            | legion777                                                                |
#      | """""""""""""                                                                                                                                                      | legion777                                                                |
      |                                                                                                                                                                    |                                                                          |
      | legion777                                                                                                                                                          | legion.qaservices@gmail.com                                              |
      | legion.qaservices@gmail.comlegion.qaservices@gmail.comlegion.qaservices@gmail.comlegion.qaservices@gmail.comlegion.qaservices@gmail.comlegion.qaservices@gmail.com | legion777                                                                |
      | legion.qaservices@gmail.com                                                                                                                                        | legion777legion777legion777legion777legion777legion777legion777legion777 |

  Scenario Outline: Verify error message in all languages
    And User clicks Change language button
    And User select "<language>" language
    When User types "<email>" in the Email field
    And User types "<pass>" in the Password field
    And User clicks Login button
    Then Error message "<message>" is visible

    Examples:
      | language   | email | pass | message            |
      | English    |       |      | ?????              |
      | Русский    |       |      | Ошибка авторизации |
      | Українська |       |      | ?????              |
      | Portuguesa |       |      | ?????              |

#    Forgot Password page tests

  Scenario Outline: Verify language switch - Forgot password page
    When User clicks Change language button
    And User select "<language>" language
    And User clicks Forgot password link
    Then Apply button text is "<apply_button>"
    And Notification message is "<notification>"
    And Sign in button text is "<sign_in>"

    Examples:
      | language   | apply_button | notification                           | sign_in           |
      | English    | Apply        | Enter an e-mail of your account        | Sign in           |
      | Русский    | Применить    | Введите email вашего аккаунта          | Войти в систему   |
      | Українська | Застосувати  | Введіть email вашого облікового запису | Увійти до системи |
      | Portuguesa | Aplicar      | Digite um e-mail da sua conta          | Fazer login       |

  Scenario: Verify links - Forgot password page
    And User clicks Change language button
    And User select English
    And User clicks Forgot password link
    When User clicks Sign in link
    Then Login page opens

  Scenario Outline: Verify error message language
    When User clicks Change language button
    And User select "<language>" language
    And User clicks Forgot password link
    And User clicks Apply button
    Then Error message "<message>" is visible - Forgot password page

    Examples:
      | language   | message          |
      | English    | ????????         |
      | Русский    | Произошла ошибка |
      | Українська | ????????????     |
      | Portuguesa | ??????????       |
