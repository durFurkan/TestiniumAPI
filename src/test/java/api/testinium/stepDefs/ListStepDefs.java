package api.testinium.stepDefs;

import api.testinium.utilities.ConfigurationReader;
import io.cucumber.java.en.When;

import static api.testinium.request.TestiniumRequest.postList;
import static api.testinium.request.TestiniumRequest.response;

public class ListStepDefs {

    @When("The user sends a POST request and able to create a list")
    public void the_user_sends_a_post_request_and_able_to_create_a_list() {
        response=postList(ConfigurationReader.get("boardId"),"furkanList");
        ConfigurationReader.set("listId",response.path("id"));
    }

}
