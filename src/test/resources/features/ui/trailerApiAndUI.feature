Feature: Trailer creation via API with UI validation and deletion

  @trailerApiUI @regression
  Scenario Outline: Create a trailer via API then validate and delete on UI
    Given user creates a trailer via API with "<make>" "<type>" "<vin>" "<unitNumber>" "<year>"
    Then user launches the application
    And user logs in to the application using admin credentials
    Then user navigates to Trailers page
    Then user validates the trailer is displayed with "<type>" "<vin>" "<unitNumber>"
    And user opens the trailer with unit number "<unitNumber>"
    And user deletes the trailer from the edit page
    Then user navigates to Trailers page
    And user verifies the trailer with unit number "<unitNumber>" is no longer displayed

    Examples:
      | make       | type    | vin               | unitNumber | year |
      | Great Dane | Dry Van | 1GRAA0621APIU0001 | APIU-6001  | 2022 |
      | Wabash     | Reefer  | 2HGFB2F59APIU0002 | APIU-6002  | 2020 |
#      | Utility    | Flatbed | 3C6TR5HT7APIU0003 | APIU-6003  | 2023 |
#      | Hyundai    | Lowboy  | 5NPD84LF2APIU0004 | APIU-6004  | 2019 |
