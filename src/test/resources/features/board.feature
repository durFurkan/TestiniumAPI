Feature: Board Functionality
  @createBoard
  Scenario: Create a Board
    Given The user sends a POST request and able to create a board
    Then The user verifies that status code is "200"
  @deleteBoard
  Scenario: Delete Board
    Given The user sends a DELETE request and able to delete a board
    Then The user verifies that status code is "200"



