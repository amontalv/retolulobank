Feature: consult user in the service

  Scenario Outline: consult user in the application
    Given user automation service for create register
    And user want create user to service
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    When user consult information for
      |<username>|
    Then user valid the status code 200
    And valid in response information in firstname and lastname
   |<firstName>|<lastName>|

    Examples:
      | id | username | firstName | lastName | email               | password  | phone   | userStatus |
      | 2  | dprueba25  | dana      | Montalvo | prueba25@prueba.com | 123445789 | 2312312 | 1         |

