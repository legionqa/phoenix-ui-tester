Feature: Registration page tests

  Background:
    Given User navigates to Registration page

#    Verify elements and languages

  Scenario Outline: Verify language change
    When User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    Then Greeting message "<greeting_text>" is visible - Registration page
    And Name field placeholder is "<name_field>"
    And Currency field placeholder is "<currency>"
    And Phone field placeholder is "<phone_field>"
    And Password field placeholder is "<pass_field>"
    And Password Confirmation field placeholder is "<pass_conf_field>"
    And Registration button text is "<login_button>"
    And Sign in button text is "<signin_button>" - Registration page

    Examples:
      | language   | greeting_text                      | name_field  | currency            | phone_field                   | pass_field | pass_conf_field       | login_button | signin_button     |
      | English    | Welcome to Phoenix Widget          | Ivan Ivanov | Account currency    | Enter your phone number       | Password   | Password confirmation | Registration | Sign in           |
      | Русский    | Добро пожаловать на Phoenix Widget | Иван Иванов | Валюта пользователя | Введите номер телефона        | Пароль     | Подтверждение пароля  | Регистрация  | Войти в систему   |
      | Українська | Ласкаво просимо на Phoenix Widget  | Іван Іванов | Валюта користувача  | Введіть номер телефону        | Пароль     | Підтвердження пароля  | Реєстрація   | Увійти до системи |
      | Portuguesa | Bem-vindo a Phoenix Widget         | Ivan Ivanov | Moeda da conta      | Digite seu número de telefone | Senha      | Confirmação de senha  | Registro     | Fazer login       |

  Scenario: Verify elements visibility - Create account page
    Then Phoenix logo is visible - Registration page
    And Registration form is visible
    And Email field is visible
    And Skype field is visible
    And Change language button is visible - Registration page
    And Trade Up logo is visible - Registration page

  Scenario: Verify links - Create account page
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User clicks Sign in button - Registration page
    Then Login page opens - Registration page

#    Negative tests

  Scenario: Empty E-mail field
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User sets E-mail field empty
    And User clicks Registration button
    Then Error message This field can't be blank is visible
    And Invalid sign in the E-mail field is visible

  Scenario Outline: Incorrect E-mail
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User types "<email>" in Email field
    And User clicks Registration button
    Then Error massage This field must be a valid email address is visible
    And Invalid sign in the E-mail field is visible

    Examples:
      | email                                            |
      | qwerty123456gmail.com                            |
      | @qwertygmail.com                                 |
      | 123                                              |
      | @#$%^&                                           |
#      | Q@"""""""                                        |
#      | 1234@"gmail.com                                  |
      | $$@gmail.                                        |
      | qwerty@gmail.comqwerty@gmail.comqwerty@gmail.com |

  Scenario Outline: Incorrect name
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User types "<name>" in Name field
    And User clicks Registration button
    Then Error massage This field is too short is visible
    And Invalid sign in the Name field is visible

    Examples:
      | name |
      | Iva  |
      | 123  |
      | @#$  |
      | 000  |
#      | ""   |
      |      |

  Scenario: Currency is not selected
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects Account currency in the Currency menu
    And User clicks Registration button
    Then Currency not selected error massage is visible
    And Valid sign in the E-mail field is visible
    And Valid sign in the Name field is visible

  Scenario: Both Password fields are empty
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects USD in the Currency menu
    And User sets Password field empty
    And User sets Password confirmation field empty
    And User clicks Registration button
    Then Check your data error massage is visible
    And Valid sign in the E-mail field is visible
    And Valid sign in the Name field is visible

  Scenario Outline: Passwords don't match
    And User clicks Change language button - Registration page
    And User select English - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects USD in the Currency menu
    And User enters "<password>" into the Password field
    And User enters "<password_confirmation>" into the Password confirmation field
    And User clicks Registration button
    Then Passwords don't match error massage is visible
    And Valid sign in the E-mail field is visible
    And Valid sign in the Name field is visible

    Examples:
      | password | password_confirmation |
      | qwerty   |                       |
      |          | qwerty                |
      | qwerty   | werty                 |
      | !@#$%    | ^&*()                 |

#Messages languages test

  Scenario Outline: Empty E-mail field - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    And The page is reloaded
    When User sets E-mail field empty
    And User clicks Registration button
    Then Blank field error massage "<message>" is visible

    Examples:
      | language   | message                             |
      | English    | This field can't be blank           |
      | Русский    | ?????                               |
      | Українська | ?????                               |
      | Portuguesa | Este campo não pode ficar em branco |

  Scenario Outline: Incorrect E-mail - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    And The page is reloaded
    When User types qwerty in the E-mail field
    And User clicks Registration button
    Then Invalid E-mail message "<message>" is visible

    Examples:
      | language   | message                                         |
      | English    | This field must be a valid email address        |
      | Русский    | ?????                                           |
      | Українська | ?????                                           |
      | Portuguesa | Este campo deve ser um endereço de email válido |

  Scenario Outline: Incorrect name - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    And The page is reloaded
    When User sets Name field empty
    And User clicks Registration button
    Then Short name error message "<message>" is visible

    Examples:
      | language   | message                                            |
      | English    | This field is too short (minimum is 4 characters)  |
      | Русский    | ?????                                              |
      | Українська | ?????                                              |
      | Portuguesa | Este campo é muito curto (o mínimo é 4 caracteres) |

  Scenario Outline: Currency is not selected - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects "<currency>" in the Currency menu
    And User clicks Registration button
    Then Currency not selected message "<message>" is visible

    Examples:
      | language   | currency            | message                                              |
      | English    | Account currency    | ????                                                 |
      | Русский    | Валюта пользователя | ОшибкаДля создания аккаунта нужно установить валюту. |
      | Українська | Валюта користувача  | ?????                                                |
      | Portuguesa | Moeda da conta      | ?????                                                |

  Scenario Outline: Both Password fields are empty - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects USD in the Currency menu
    And User sets Password field empty
    And User sets Password confirmation field empty
    And User clicks Registration button
    Then Check data message "<message>" is visible

    Examples:
      | language   | message                                                        |
      | English    | ????????                                                       |
      | Русский    | Проверьте введенные вами данныеПри регистрации возникла ошибка |
      | Українська | ?????                                                          |
      | Portuguesa | ?????????                                                      |

  Scenario Outline: Passwords don't match - languages
    And User clicks Change language button - Registration page
    And User chooses "<language>" language - Registration page
    When User types qwerty@qwerty.com in the E-mail field
    And User types qwerty in the Name field
    And User selects USD in the Currency menu
    And User enters qwerty into the Password field
    And User sets Password confirmation field empty
    And User clicks Registration button
    Then Passwords don't match error massage "<message>" is visible

    Examples:
      | language   | message             |
      | English    | ????????            |
      | Русский    | Пароли не совпадают |
      | Українська | ?????               |
      | Portuguesa | ?????????           |