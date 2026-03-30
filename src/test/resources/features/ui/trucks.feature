Feature: Truck and Trailer automations

  @trailer @regression
  Scenario Outline: Trailer creation and validation
    Given user launches the application
    Then user logs in to the application using admin credentials
    Then user navigates to Trailers page
    And user clicks on Add Trailer button
    Then user fills out trailer with "<make>" "<type>" "<vin>" "<unitNumber>"
    And user saves the trailer
    Then user validates the trailer is displayed with "<type>" "<vin>" "<unitNumber>"

    Examples:
      | make       | type              | vin               | unitNumber |
      | Great Dane | Dry Van           | 1GRAA06211234ABCD | TR-5001    |
#      | Wabash     | Reefer            | 2HGFB2F59EH123456 | TR-5002    |
#      | Utility    | Flatbed           | 3C6TR5HT7LG234567 | TR-5003    |
#      | Hyundai    | Lowboy            | 5NPD84LF2JH345678 | TR-5004    |
#      | Stoughton  | Container Chassis | JM1BK32F781456789 | TR-5005    |
