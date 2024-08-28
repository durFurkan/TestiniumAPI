package api.testinium.stepDefs;

import api.testinium.common.DataForCard;
import api.testinium.utilities.ConfigurationReader;
import io.cucumber.java.en.*;

import static api.testinium.request.TestiniumRequest.*;
import static org.junit.Assert.*;

public class CardStepDefs {
    DataForCard dataForCard = new DataForCard();
    @When("The user sends a POST request and able to create cards")
    public void the_user_sends_a_post_request_and_able_to_create_cards() {
        dataForCard.createCards();
    }
    @When("The user sends a PUT request and able to update a card")
    public void the_user_sends_a_put_request_and_able_to_update_a_card() {
        response=putCard(ConfigurationReader.get("cardId"),"furkanNewCard");
        ConfigurationReader.set("newCardName",response.path("name"));
    }
    @Then("The user verifies that the updates are successful")
    public void the_user_verifies_that_the_updates_are_successful() {
        assertNotEquals(ConfigurationReader.get("cardName"), ConfigurationReader.get("newCardName"));
    }
    @When("The user sends a DELETE request and able to delete cards")
    public void the_user_sends_a_delete_request_and_able_to_delete_cards() {
        dataForCard.deleteCards();
    }
}
