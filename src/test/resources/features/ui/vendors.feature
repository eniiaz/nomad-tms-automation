Feature: Vendor in NomadTMS for API and UI tests

  Scenario: Vendor creation on UI

    Given user launches the application
    Then user logs in to the application using admin credentials
    And user navigates to the vendors page
    And user clicks on vendor creation

