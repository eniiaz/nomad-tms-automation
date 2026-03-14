Feature: Validations between API data and UI data

  @apiAndUI
  Scenario Outline: Validation for companies list between UI and API

    Given user makes an API call to get companies list at "<endpoint>"
    Then user launches the application
    And user logs in to the application using admin credentials
    Then user navigates to settings page
    And user validates all the companies with companies list from API request

    Examples:
      | endpoint                                      |
      | https://nomadtms.up.railway.app/api/companies |