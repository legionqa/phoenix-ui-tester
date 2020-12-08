Feature: Overview page test

  Background:
    Given User navigates to overview page
    And User clicks on button Change language


#    Visibility of the elements of Overview page in all languages
  Scenario Outline: Verify have elements changed in all languages

    When User chooses "<language>" language
    Then Text info massage changed to "<changed_infoMassage>"
    And Logo Phoenix Team changed to "<changed_logo>"
    And Element Quick Start changed to "<changed_Qstart>"
    And Button Create... changed to "<changed_create>"
    And Button Edit Profile changed to "<changed_editProfile>"
    And Video Screen is visible
    And Log out

    Examples:
      | language   | changed_infoMassage | changed_logo    | changed_Qstart | changed_create | changed_editProfile   |
      | English    | Hello               | Phoenix team    | Quick start    | Create         | Edit profile          |
      | Русский    | Здравствуйте        | Команда Phoenix | Быстрый старт  | Создать        | Редактировать профиль |
      | Українська | Доброго дня         | Команда Phoenix | Швидкий старт  | Створити       | Редагувати профіль    |
      | Portuguesa | Olá                 | time Phoenix    | Início rápido  | Criar          | Editar perfil         |



#  Functionality in all languages

#  Button Create / Droplist button Site
  Scenario Outline: Verify button Create/Droplist button Site in all languages
    When User chooses "<language>" language
    And User clicks on "<create_button>"
    And User chooses from drop down list "<drop_button>"
    Then "<page_name>" of the Site page is visible
    And Log out

    Examples:
      | language   | create_button | drop_button | page_name       |
      | English    | Create        | Site        | Create the site |
      | Русский    | Создать       | Сайт        | Создать сайт    |
      | Українська | Створити      | Сайт        | Створити сайт   |
      | Portuguesa | Criar         | Site        | Crie o site     |


#  Button Create / Droplist button Campaign
  Scenario Outline: Verify button Create/Droplist button Campaign in all languages
    When User chooses "<language>" language
    And User clicks on "<create_button>"
    And User chooses from drop downlist "<drop_button>"
    Then "<page_name>" of the Campaign page is visible
    And Log out

    Examples:
      | language   | create_button | drop_button       | page_name |
      | English    | Create        | Campaign          | Campaigns |
      | Русский    | Создать       | Рекламный кампейн | Кампейны  |
      | Українська | Створити      | Рекламний Кампейн | Кампейни  |
      | Portuguesa | Criar         | Campanha          | Campanhas |


#  Edit profile

  Scenario Outline: Verify  button Edit profile in all languages
    When User chooses "<language>" language
    And User clicks on the "<edit_button>"
    Then "<page_name>" of the Profile page is visible
    And Log out

    Examples:
      | language   | edit_button           | page_name             |
      | English    | Edit profile          | Edit profile          |
      | Русский    | Редактировать профиль | Редактировать профиль |
      | Українська | Редагувати профіль    | Редагувати профіль    |
      | Portuguesa | Editar perfil         | Editar perfil         |



#  Email link in all languages
  Scenario Outline: Verify Email link in all languages
    When User chooses "<language>" language
    And User hovers over Phoenix email link
    Then Email link is highlighted
    And Log out

    Examples:
      | language   |
      | English    |
      | Русский    |
      | Українська |
      | Portuguesa |



  #  Video player in all languages
  Scenario Outline: Verify video player in all languages
    When User chooses "<language>" language
    And User clicks on video button in "<language>"
    Then User verifys video is working
    And Log out

    Examples:
      | language   |
      | English    |
      | Русский    |
      | Українська |
      | Portuguesa |