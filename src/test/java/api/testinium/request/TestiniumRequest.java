package api.testinium.request;

import api.testinium.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestiniumRequest {
    public static Response response;

    public static Response get(String endPoint,String id){
        response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",id)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .get(ConfigurationReader.get("BOARD_BASE_URL" ));
        return response;
    }
    public static Response postBoard(String boardName) {
        response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("name", boardName)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .post(ConfigurationReader.get("BOARD_BASE_URL"));
        return response;
    }

    public static Response postCard(String listId, String cardName) {
        response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("name", cardName)
                .queryParam("idList", listId)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .post(ConfigurationReader.get("CARD_BASE_URL"));
        return response;
    }

    public static Response putCard(String cardId, String newName) {
        response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("name", newName)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .put(ConfigurationReader.get("CARD_BASE_URL") + cardId);
        return response;
    }

    public static Response deleteCard(String cardId) {
        response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .delete(ConfigurationReader.get("CARD_BASE_URL")+ cardId);
        return response;
    }

    public static Response deleteBoard(String boardId) {
        response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("key", ConfigurationReader.get("KEY"))
                .queryParam("token", ConfigurationReader.get("TOKEN"))
                .when()
                .delete(ConfigurationReader.get("BOARD_BASE_URL") + boardId);
        return response;
    }

    public static Response postList(String boardId, String listName) {
        return RestAssured.given()
                .accept(ContentType.JSON)
                .queryParam("name", listName)
                .queryParam("idBoard", boardId)
                .when()
                .post("https://api.trello.com/1/lists/");
    }
}
