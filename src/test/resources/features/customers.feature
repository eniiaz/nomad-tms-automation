Feature: Customers of the company in TMS

  # Create as many Scenarios as possible but all should belong to this feature

  @customer @this @smoke
  Scenario Outline: Customer search functionality validation

    Given user launches the application
    Then user logs in to the application using admin credentials
    Then user navigates to Customers page
    And user searches for a keyword "<keyword>"
    Then user validates the result to have keyword "<keyword>"

    Examples:
    | keyword |
    | arr     |
#    | all     |
#    | no      |
#    | one     |

    @customerCreation  @regression
    Scenario: Customer creation
      Given user launches the application
      Then user logs in to the application using admin credentials
      Then user navigates to Customers page
      And user clicks on add customer button
      Then user fill out details
      And user validates for successful creation
