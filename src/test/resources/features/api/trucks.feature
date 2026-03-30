Feature: Truck API automation tests

  @truckAPI @smoke @regression
  Scenario Outline: Create a truck and verify it exists in the system
    Given user creates a truck with "<name>" "<model>" "<unitNumber>" "<plateNumber>" "<vin>" "<year>" "<state>"
    Then user verifies the truck is created successfully with name "<name>"
    And user verifies the created truck appears in the trucks list

    Examples:
      | name         | model    | unitNumber | plateNumber | vin                | year | state |
      | Freightliner | Cascadia | UN-3001    | PLT-30001   | 1FUJGLD55CLAB1234 | 2020 | CA    |
      | Peterbilt    | 579      | UN-3002    | PLT-30002   | 2HSFGBR76DL567890 | 2022 | TX    |
      | Kenworth     | T680     | UN-3003    | PLT-30003   | 3AKJGLD77EMCD4567 | 2019 | IL    |
      | Volvo        | VNL860   | UN-3004    | PLT-30004   | 4V4NC9EH5FN890123 | 2023 | NY    |
      | International| LT625    | UN-3005    | PLT-30005   | 5INTDKE88FNOP6789 | 2021 | OH    |

  @truckAPI @regression
  Scenario Outline: Create a truck then delete it and verify removal
    Given user creates a truck with "<name>" "<model>" "<unitNumber>" "<plateNumber>" "<vin>" "<year>" "<state>"
    Then user verifies the truck is created successfully with name "<name>"
    And user deletes the created truck
    Then user verifies the response status code is <expectedStatus>
    And user verifies the deleted truck no longer appears in the trucks list

    Examples:
      | name      | model  | unitNumber | plateNumber | vin                | year | state | expectedStatus |
      | MackDel   | Anthem | UN-4001    | PLT-40001   | 5MKJAHD88GNA12345 | 2021 | OH    | 204            |
      | IntlDel   | LT     | UN-4002    | PLT-40002   | 6INKBHE99HOB56789 | 2018 | FL    | 204            |
      | WesternSt | 5700XE | UN-4003    | PLT-40003   | 7WSLCIF00IPC90123 | 2024 | WA    | 204            |
      | HinoDel   | L7     | UN-4004    | PLT-40004   | 8HNDDJG11JQD34567 | 2020 | GA    | 204            |

  @truckAPI @negative @regression
  Scenario Outline: Delete a truck with non-existent or invalid ID
    Given user attempts to delete a truck with ID "<truckId>"
    Then user verifies the response status code is not <unexpectedStatus>

    Examples:
      | truckId                              | unexpectedStatus |
      | 00000000-0000-0000-0000-000000000000 | 200              |
      | invalid-id-format-not-uuid           | 200              |
      | 99999999-aaaa-bbbb-cccc-dddddddddddd | 200              |
      | aaaaaaaa-1111-2222-3333-bbbbbbbbbbbb | 200              |

  @truckAPI @negative @regression
  Scenario Outline: Create a truck with missing or invalid data
    Given user creates a truck with "<name>" "<model>" "<unitNumber>" "<plateNumber>" "<vin>" "<year>" "<state>"
    Then user verifies the truck creation failed

    Examples:
      | name | model | unitNumber | plateNumber | vin | year | state |
      |      | X15   | UN-5001    | PLT-50001   | VIN | 2020 | CA    |
      | Test |       |            |             |     | 0    |       |
      |      |       |            |             |     | 0    |       |
      | Solo |       | UN-5004    |             |     | -1   | ZZ    |
