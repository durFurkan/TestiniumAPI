Feature: Card Functionality
  @createCard
  Scenario: Create Card
    When The user sends a POST request and able to create cards
    Then The user verifies that status code is "200"
  @updateCard
  Scenario: Update a Card
    When The user sends a PUT request and able to update a card
    Then The user verifies that status code is "200"
    And The user verifies that the updates are successful
  @deleteCard
  Scenario: Delete Card
    When The user sends a DELETE request and able to delete cards
    Then The user verifies that status code is "200"
