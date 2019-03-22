@ProductPage
Feature: Add Item to Cart

  The puprose of this feature, is to check the product page of an item and that if the item is added to the cart it updates correctly

  @ViewProduct
  Scenario: View Product Item

    This scenario opens the items product page, checks the current instock value and ensures the Add button is pressent

    Given I am interested in the iPad 4 Mini
    When I select the product link
    Then the product page should display
    And have an in stock value of 2
    And have an Add to cart button

  @AddProduct
  Scenario: Add Item to cart

    This scenario adds a single item to the cart, check that the cart has been updated and the instock value has also been updated

    Given I want to purchase the iPad 4 Mini
    When I add the item to the cart
    Then the cart should contain 1 new item
    And the instock value should display 1