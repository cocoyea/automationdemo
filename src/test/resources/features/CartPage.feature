@ViewStock
Feature: Check Stock Item

  The purpose of this feature, is to check that the expected stock items are present with their correct values and in order.

  @ProductItems
  Scenario: Verify url and items

  This scenario verifies that the correct page has loaded and the items that should be present are there.

    Given I want to go to the url https://skyronic.github.io/vue-spa/#/
    When the page has loaded
    Then I should only see 3 displayed items

  @OrderAndPrices
  Scenario: Verify the display order and item prices

  This scenario verifies that the items are displayed in the required order and respective prices.

    Given I want to check the displayed items
      | item                   | price   |
      | iPad 4 Mini            | $500.01 |
      | H&M T-Shirt White      | $10.99  |
      | Charli XCX - Sucker CD | $19.99  |
    Then they should be displayed in the correct order
    And with the correct prices
