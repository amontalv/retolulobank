Feature: update user in the service

  Scenario Outline: update user with information
    Given user automation service for create register
    And user want create user to service
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    When user want update information of user
      | <username> |<phoneModify>|
    Then user valid the status code 200
    And valid in response code 200

    Examples:
      | id | username | firstName | lastName | email             | password  | phone   | userStatus | phoneModify |
      | 1  | dguaman  | alexis    | Monsalve | prueba@prueba.com | 123445789 | 2312312 | 0          | 5678909     |

