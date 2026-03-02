Feature: Customers of the company in TMS

  # Create as many Scenarios as possible but all should belong to this feature

  @customer @this
  Scenario: Customer search functionality validation

    Given user launches the application
    Then user logs in to the application using admin credentials
    Then user navigates to Customers page
    And user searches for a keyword "all"
    Then user validates the result to have keyword "all"


    Scenario: Customer creation
      Given user launches the application
      Then user logs in to the application using admin credentials
      Then user navigates to Customers page
      And user clicks on add customer button
      Then user fill out details
      And user validates for successful creation
