

Feature: Login Functionality
  @login
  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter <username> and <password>
    And I click the login button
    Then I should see the welcome message
    Examples:
      | username | password |
      | 8942012908 | 8.PST#z9eQ.5%w/ |

  @login
  Scenario: SearchBar
    When user is on the homepage search bar should be visible
    And I'll pass the keys to search the "nike shoes for men"
    And I'll parse the suggestion and store them in a list
    And I'll press the search button
    Then I'll parse the suggestions and assert them with the search "nike"
    Then I'll parse the results and assert them with the search "nike"

  @login
  Scenario: Check Add to cart functionality
    When  I'll search the product "apple iphone 15"
    And  Add that product to the cart
    Then Go to Cart
    Then Check the product you added is present in Cart or not
    Then Check the products prices and match with the subtotal