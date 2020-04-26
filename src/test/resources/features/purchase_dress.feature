Feature: Purchase Dress

  Scenario: Add Summer dress to cart
    Given I am on the home page
    When I add a summer dress "Printed Chiffon Dress" to the cart
    Then I get the success message
    And I can see the detail of the product added in the cart

  Scenario: Proceed to Checkout
    Given I have summer dress added to the cart
    When I proceed to checkout without sign in
    Then I can see the option to Sign in