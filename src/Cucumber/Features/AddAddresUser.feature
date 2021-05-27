Feature: Add user address
  Scenario: Add user new address, city and zip/postal code
    Given User is logged in to CodersLab shop
    When User goes to UserAddressesPage
    And Add address
    And Add City
    And  Complete Zip/Postal Code
    Then User see "Address successfully updated."
