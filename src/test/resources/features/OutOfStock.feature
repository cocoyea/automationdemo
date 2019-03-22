@OutOfStock
Feature: Cannot add more items to the cart than there is stock

  The purpose of this feature is to, test whether an out of stock item can be added to the card

  @AddAll
  Scenario: Add all items to the cart

    This scenario will add all in stock items to the cart

    Given I want to buy the Charli XCX - Sucker CD
    When I add all 5 CDs to the cart
    Then the add button should change to Out Of Stock

  @AddOneMore
  Scenario: Add zero stock item to cart

    This scenario will attempt to add an out of stock item to the cart
    Given there is 0 stock available
    When I try to add another CD to the cart
    Then the cart should only contain 5 items