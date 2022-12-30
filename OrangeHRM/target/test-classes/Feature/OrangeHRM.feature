Feature: to test the functionalities of OrangeHRM page

  @smokeTest @regressionTest
  Scenario: check login functionality with valid credentials
    Given browser is open
    And user is on login page "loginPage_url"
    When user enters username "username" in "username_locator" in "username_duration" duration
    And user enters password "password" in "password_locator" in "password_duration" duration
    And clicks on "login_button_locator" in "login_duration" duration
    Then User should be navigated to the Home Page with "homePageTitle"

  @smokeTest
  Scenario: to add employee information
    Given navigate to "PIM_url"
    And enters Employee name "employee_name" in "employeeName_locator" in "employeeName_duration" duration
    And assert the text in "dropdown_locator" as "no_rocord_found" in "dropdown_text_locator" in "dropdown_locator_duration"
    And click on "add_locator" in "add_locator_duration" duration
    And enter first name "firstName" in "firstName_locator" in "firstName_duration" duration
    And enter middle name "middleName" in "middleName_locator" in "middleName_duration" duration
    And enter last name "lastName" in "lastName_locator" in "lastName_duration" duration
    And enter employee id in "employeeId" in "employeeId_locator" in "employeeId_duration" duration
    And click on save "save_button" in "saveButton_duration" duration
    And assert the text in "success_message_locator" as "success_message" in "success_message_duration"

  @regressionTest
  Scenario: to aplly leave
    Given navigate to "leave_url"
    And select the option "option_locator" in the leave type dropdown "leave_dropdown_locator" in "dropdown_duration"
    And select from date "from_date_locator" as "from_date" in "from_date_duration"
    And select to date "to_date_locator" as "to_date" in "to_date_duration"
    And Assert the text in "balance_not_sufficient_locator" as "balance_not_sufficient" in "balance_not_sufficient_duration"
