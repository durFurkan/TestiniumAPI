package api.testinium.common;

import api.testinium.utilities.ConfigurationReader;
import static api.testinium.request.TestiniumRequest.*;

public class DataForCard {
    public void createCards() {
        String[] cardNames = {"cardName1", "cardName2"};
        String[] cardIds = {"cardId1", "cardId2"};

        for (int i = 0; i < 2; i++) {
            response=postCard(ConfigurationReader.get("listId"),"furkanCard" + i);
            ConfigurationReader.set(cardNames[i],response.path("name"));
            ConfigurationReader.set(cardIds[i],response.path("id"));
        }
    }

    public void deleteCards(){
        for (int i = 0; i < 2; i++) {
            response=deleteCard(ConfigurationReader.get("listId"));
        }
    }
}
