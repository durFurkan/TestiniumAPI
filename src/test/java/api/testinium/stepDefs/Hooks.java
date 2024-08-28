package api.testinium.stepDefs;

import api.testinium.utilities.ConfigurationReader;
import org.junit.After;
import org.junit.Before;

import static io.restassured.RestAssured.reset;


public class Hooks {
    @After
    public void tearDown(){
        reset();
    }
}
