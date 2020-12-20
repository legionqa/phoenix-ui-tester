@login
Feature: My sites page

  Background:
    Given User navigates to My sites page

# Visibility, languages and links

  Scenario Outline: Navigation bar language
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then The navigation bar text in 3 sections is "<text>"

    Examples:
      | language | text |
      | English | DASHBOARD  LEGION QA  SITES |
      | Русский | DASHBOARD  LEGION QA  САЙТЫ |
      | Українська | DASHBOARD  LEGION QA  САЙТИ |
      | Portuguesa | DASHBOARD  LEGION QA  SITES |


  Scenario Outline: Navigation bar - links
    When User clicks "<link>" link of the Navigation bar
    Then "<page>" page opens - My sites

    Examples:
      | link | page |
      | Dashboard | /overview |
      | Legion QA | /users/5fa1d8ffc903de27cc069de4 |

  Scenario: All sites counter correctness
    Then The number in All sites counter equals to the number of strings in the Sites table

  Scenario: Main menu highlighting
    Then My sites option in the main menu is highlighted

  Scenario: Add the site link
    When User clicks Add the site button
    Then Create the site page opens

  Scenario Outline: Language switch
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then Sites block header is "<sites>"
    And Update button text is "<update_button>"
    And Search field placeholder is "<search_placeholder>"
    And Search button text is "<search_button>"
    And All sites counter text is "<all_sites>"
    And Add the site button text is "<add_site_button>"

    Examples:
      | language | sites | update_button | search_placeholder | search_button | all_sites | add_site_button |
      | English | Sites | Update | Site`s name | Search | All sites | Add the site |
      | Русский | Сайты | Обновить | Имя сайта | Поиск | Всего сайтов | Добавить сайт |
      | Українська | Сайти | Оновити | Ім'я сайту | Пошук | Всього сайтів | Додати сайт |
      | Portuguesa | Sites | Atualizar | Nome do site | Pesquisa | Todos os sites | Adicionar o site |


#  Sites table

  Scenario: Site line elements visibility
    Then Every site line has activate-inactivate switch
    And Every site line has site name
    And Every site line has URL
    And Every site line has Add the widget button
    And Every site line has Settings button

  Scenario: Site name link test
    When User clicks Site name link of the Test site SearchKey1 line
    Then Site page of the Test site SearchKey1 site opens

  Scenario: Add the widget link test
    When User clicks Add the widget button of the Test site SearchKey1 line
    Then Create the widget page of the Test site SearchKey1 site opens

  Scenario: Site settings link test
    When User clicks Settings button of the Test site SearchKey1 line
    Then Settings page of the Test site SearchKey1 site opens

  Scenario Outline: Site line language - Add widget and Settings
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    Then Add the widget button text in the Test site SearchKey1 line is "<add_widget>"
    And Settings button tooltip in the Test site SearchKey1 line is "<settings>"

    Examples:
      | language | add_widget | settings |
      | English | Add the widget | Settings |
      | Русский | Добавить виджет | Настройки |
      | Українська | Додати віджет | Налаштування |
      | Portuguesa | Adicionar o widget | Configurações |

#   Search test

  Scenario Outline: Search test - valid key
    When User types Searchkey in the Search field
    Then The sites table with two sites Test site SearchKey1 and Test site searchkey2 only is displayed
    And All sites counter number is <number>

    Examples:
      | number |
      | 2 |

  Scenario Outline: Search test - invalid key
    When User types qwerty in the Search field
    Then The sites table with <number> sites is displayed
    And All sites counter number is <number>

    Examples:
      | number |
      | 0 |

  Scenario Outline: Update button test
    When User types Searchkey in the Search field
    When User clicks Update button
    Then The sites table with <number> sites is displayed
    And All sites counter number is <number>

    Examples:
      | number |
      | 4 |