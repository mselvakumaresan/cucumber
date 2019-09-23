Feature: Add customer flow

  Scenario: 
    Given user should be in telecom home page
    And user click on add customer button
    When user enters all the fields with valid data
      | selva | kumaran | selva@gmail.com | rjpm | 9600436132 |
    And user clicks on submit button
    Then user id should be displayed
