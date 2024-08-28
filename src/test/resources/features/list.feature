Feature: List Functionality
  @createList
  Scenario: Create a new list
    When The user sends a POST request and able to create a list
    Then The user verifies that status code is "200"