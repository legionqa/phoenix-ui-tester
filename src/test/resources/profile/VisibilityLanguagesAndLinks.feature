@login
Feature: Visibility, languages and links - Profile page

  Background:
    Given User navigates to Profile page

  Scenario: Verify elements visibility - Profile page
    Then E-mail field is visible
    And Skype field is visible - Profile page
    And Currency field is visible


  Scenario Outline: Navigation bar - links on Profile page
    When User clicks "<link>" link of the Navigation bar
    Then "<page>" page opens - My sites

    Examples:
      | link      | page                            |
      | Dashboard | /overview                       |
      | Legion QA | /users/5fa1d8ffc903de27cc069de4 |

  Scenario Outline: Navigation bar language - Profile page
    When User clicks on Change language button
    And User chooses "<language>" language

    Then The navigation bar text in 3 sections is "<text>"

    Examples:
      | language | text |
      | English | DASHBOARD  LEGION QA  EDIT PROFILE |
      | Русский | DASHBOARD  LEGION QA  РЕДАКТИРОВАТЬ ПРОФИЛЬ |
      | Українська | DASHBOARD  LEGION QA  РЕДАГУВАТИ ПРОФІЛЬ |
      | Portuguesa | DASHBOARD  LEGION QA  EDITAR PERFIL |


  Scenario: Main menu highlighting - Profile page
    Then Profile in the main menu is highlighted

  Scenario: Drop-down menu of the user panel highlighting
    When Click on Drop-down menu the user panel
    Then My Profile option is highlighted in the drop-down menu of the user panel

  Scenario Outline: Language switch - Profile page
    When User clicks on Change language button
    And User chooses "<language>" language
    And Editing of the profile block text is "<editing_profile_block>"
    And Name field placeholders text is "<placeholders_name_field>"
    And Phone field placeholders text is "<placeholders-phone_field>"
    And Changing the password block is "<changing_the_password_block>"
    When User clicks expand or collapse button of the Changing the password block
    Then Current password placeholder is "<current_password>"
    And New password placeholder is "<new_password>"
    And Password confirmation placeholder is "<password_confirmation>"
    And Save button text is "<save_button>" - Profile page
    When User sends string " " in the name field
    Then Cancel button text is "<cancel_button>"
    And Change button text is "<change_button>"


    Examples:
      | language   | editing_profile_block  | placeholders_name_field | placeholders-phone_field      | changing_the_password_block | current_password | new_password | password_confirmation | save_button | change_button | cancel_button |
      | English    | Editing of the profile | Ivan Ivanov             | Enter your phone number       | Changing the password       | Current password | New password | Password confirmation | Save        | Change        | Cancel        |
      | Русский    | Редактирование профиля | Иван Иванов             | Введите номер телефона        | Смена пароля                | Текущий пароль   | Новый пароль | Подтверждение пароля  | Сохранить   | Изменить      | Отмена        |
      | Українська | Редагування профілю    | Іван Іванов             | Введіть номер телефону        | Зміна пароля                | Поточний пароль  | Новий пароль | Підтвердження пароля  | Зберегти    | Змінити       | Скасувати     |
      | Portuguesa | Edição do perfil       | Ivan Ivanov             | Digite seu número de telefone | Alterando a senha           | Senha atual      | Nova senha   | Confirmação de senha  | Salvar      | Alterar       | Cancelar      |


