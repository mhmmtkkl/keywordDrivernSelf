Feature: Login to website
  @SmokeTest
  Scenario: Login

    Given "Open" Browser
    And I am as a user entering field in "login" page
    |Username|makoklu32@gmail.com|
    |Password|China1949.         |

    And I click on element in "login" page
    |LogIn|

    And I click on element in "login" page
    |ServiceDropdown|
    |buttonTickets  |

