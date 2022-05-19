Feature: create user in the service

  Scenario Outline: create user with information
    Given user automation service for create register
    When user want create user to service
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    Then user valid the status code 200
    And valid in response code 200

    Examples:
      | id | username | firstName | lastName | email             | password  | phone   | userStatus |
      | 1  | amontalv | Alejandro | Montalvo | prueba@prueba.com | 123445789 | 2312312 | 0          |

