@login
Feature: Site settings page test

  Background:
    Given User navigates to My sites page
    And User clicks Settings button of the Test site SearchKey1 line


#  Visibility, languages and links - Settings

  Scenario Outline: Navigation bar language - site settings
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then The navigation bar text in 5 sections is "<text>"

    Examples:
      | language   | text                                                             |
      | English    | DASHBOARD  LEGION QA  SITES  TEST SITE SEARCHKEY1  SETTINGS      |
      | Русский    | DASHBOARD  LEGION QA  САЙТЫ  TEST SITE SEARCHKEY1  НАСТРОЙКИ     |
      | Українська | DASHBOARD  LEGION QA  САЙТИ  TEST SITE SEARCHKEY1  НАЛАШТУВАННЯ  |
      | Portuguesa | DASHBOARD  LEGION QA  SITES  TEST SITE SEARCHKEY1  CONFIGURAÇÕES |


  Scenario Outline: Navigation bar - links - site settings
    And User clicks "<link>" link of the Navigation bar
    Then "<page>" page opens - My sites

    Examples:
      | link                 | page                                                           |
      | Dashboard            | /overview                                                      |
      | Legion QA            | /users/5fa1d8ffc903de27cc069de4                                |
      | Sites                | /users/5fa1d8ffc903de27cc069de4/sites                          |
      | Test site SearchKey1 | /users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4 |


  Scenario: Main menu highlighting - site settings
    Then My sites option in the main menu is highlighted

  Scenario: Elements visibility
    Then URL field is visible
    And utm_source field is visible

  Scenario: Expand/collapse buttons
    And User clicks expand-collapse button of the Settings block
    Then Settings block collapses
    When User clicks expand-collapse button of the Settings block
    Then Settings block expands
    When User clicks expand-collapse button of the Main settings block
    Then Main settings block collapses
    When User clicks expand-collapse button of the Main settings block
    Then Main settings block expands

  Scenario Outline: Language switch - elements
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then Settings block header is "<settings>"
    And Main settings block header is "<main_settings>"
    And Site's name field placeholder is "<name>"
    And Category drop-down list placeholder is "<category>"
    And Country drop-down list placeholder is "<country>"
    And Language list is placeholder is "<language_list>"
    And Black words list field placeholder is "<black_list>"
    And Black words list tooltip is "<tooltip>"
    And Options of Status drop-down menu are "<active>" and "<inactive>"
    And Save button text is "<save>"
    And Back button text is "<back>"

    Examples:
      | language   | settings      | main_settings            | name         | category            | country            | language_list | black_list              | tooltip                                                                        | active   | inactive   | save      | back   |
      | English    | Settings      | Main settings            | Site`s name  | Choose the category | Choose the country | Language      | Black list of words     | Materials that contain words from this list will not be shown in the widget!   | Active   | Inactive   | Save      | Back   |
      | Русский    | Настройки     | Основные настройки       | Имя сайта    | Выберите категорию  | Выберите страну    | Язык          | Черный список слов      | Материалы которые содержать слова из этого списка показаны в виджете не будут! | Активный | Неактивный | Сохранить | Назад  |
      | Українська | Налаштування  | Основні налаштування     | Ім'я сайту   | Оберіть категорію   | Виберіть країну    | Мова          | Чорний список слів      | Матеріали які містити слова з цього списку показані в віджеті НЕ будуть!       | Активний | Неактивні  | Зберегти  | Назад  |
      | Portuguesa | Configurações | Configurações principais | Nome do site | Escolha a categoria | Escolha o país     | Idioma        | Lista negra de palavras | Os materiais que contêm palavras desta lista não serão mostrados no widget!    | Ativo    | inativo    | Salvar    | Voltar |

  Scenario Outline: Category list
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then Category label in the Test site SearchKey1 site line of the Sites table is matching the selected category

    Examples:
      | language   |
      | English    |
      | Русский    |
      | Українська |
      | Portuguesa |

  Scenario Outline: Country list
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then Country label in the Test site SearchKey1 site line of the Sites table is matching the selected country

    Examples:
      | language   |
      | English    |
      | Русский    |
      | Українська |
      | Portuguesa |

#  Negative tests

  Scenario Outline: Site's name field - blank - all languages
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User sets Site's name field blank
    And User clicks Save button
    Then Invalid sign in the Site's name field is visible
    And Error message in the Site's name field with text "<message>" is visible

    Examples:
      | language   | message                             |
      | English    | This field can't be blank           |
      | Русский    | ????????                            |
      | Українська | ?????????                           |
      | Portuguesa | Este campo não pode ficar em branco |

  Scenario Outline: Site's name field - short name - all languages
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User types que in the Site's name field
    And User clicks Save button
    Then Invalid sign in the Site's name field is visible
    And Error message in the Site's name field with text "<message>" is visible

    Examples:
      | language   | message                                            |
      | English    | This field is too short (minimum is 4 characters)  |
      | Русский    | ????????                                           |
      | Українська | ?????????                                          |
      | Portuguesa | Este campo é muito curto (o mínimo é 4 caracteres) |

  Scenario Outline: URL field - blank - all languages
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User sets URL field blank
    And User clicks Save button
    Then Invalid sign in the URL field is visible
    And Error message in the URL field with text "<message>" is visible

    Examples:
      | language   | message                             |
      | English    | This field can't be blank           |
      | Русский    | ????????                            |
      | Українська | ?????????                           |
      | Portuguesa | Este campo não pode ficar em branco |

  Scenario Outline: URL field - invalid URL - all languages
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User types qwerty in the URL field
    And User clicks Save button
    Then Invalid sign in the URL field is visible
    And Error message in the URL field with text "<message>" is visible

    Examples:
      | language   | message                           |
      | English    | This field must be a valid url    |
      | Русский    | ????????                          |
      | Українська | ?????????                         |
      | Portuguesa | Este campo deve ser um URL válido |


  Scenario: URL and Site's name fields - valid signs
    When User types que in the Site's name field
    And User types qwerty in the URL field
    And User clicks Save button
    And User types Test site 4 in the Site's name field
    And User types qwerty.test in the URL field
    Then Valid sign in the Site's name field is visible
    And Valid sign in the URL field is visible
    And No error message is visible

  Scenario: URL field - without http
    When User types qwerty.test in the URL field
    And User clicks Save button
    Then Error message is displayed

  Scenario: URL field - existing URL
    When User types Test site searchkey2 URL in the URL field
    And User clicks Save button
    Then Error message is displayed

#  Positive tests

  Scenario: Exit without saving data
    When User selects News in the Category list
    And User clicks My sites in the Main menu
    Then Data will be lost message is displayed
    When User clicks Go button in the pop-up message
    Then My Sites page opens
    When User clicks Settings button of the Test site SearchKey1 line
    Then No category selected in the Category list

  Scenario: Back button
    When User selects News in the Category list
    And User clicks Back button
    Then My Sites page opens
    When User clicks Settings button of the Test site SearchKey1 line
    Then No category selected in the Category list

  Scenario: Data will be lost message - cancel button
    When User selects News in the Category list
    And User clicks My sites in the Main menu
    Then Data will be lost message is displayed
    When User clicks Cancel button in the pop-up message
    Then Site settings page still open
    And Data will be lost message is closed

  Scenario Outline: Language switch - Data will be lost message
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User types Test site 4 in the Site's name field
    And User clicks My sites in the Main menu
    Then Pop-up message with text "<message>" and buttons "<cancel>" and "<go>" appears

    Examples:
      | language   | message                                                                          | cancel | go         |
      | English    | ?????                                                                            | ?????  | ?????      |
      | Русский    | Не сохраненные данные будут утеряныВы действительно хотите покинуть эту сраницу? | Отмена | Продолжить |
      | Українська | ?????                                                                            | ?????  | ?????      |
      | Portuguesa | ?????                                                                            | ?????  | ?????      |

