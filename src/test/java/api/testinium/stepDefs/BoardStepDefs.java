package api.testinium.stepDefs;

import api.testinium.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static api.testinium.request.TestiniumRequest.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardStepDefs {
    private String boardId;
    private String listId;
    private String cardId1;
    private String cardId2;


    @Given("The user sends a POST request and able to create a board")
    public void createBoard() {
        response = postBoard("Test");
        ConfigurationReader.set("boardId",response.path("id"));
    }

    @Then("The user verifies that status code is {string}")
    public void the_user_verifies_that_status_code_is(String statusCode) {
        assertEquals(statusCode,String.valueOf(response.statusCode()));
    }
    @Given("The user sends a DELETE request and able to delete a board")
    public void the_user_sends_a_delete_request_and_able_to_delete_a_board() {
        response=deleteBoard(ConfigurationReader.get("boardId"));
    }

}
