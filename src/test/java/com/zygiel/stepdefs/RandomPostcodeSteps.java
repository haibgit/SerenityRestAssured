package com.zygiel.stepdefs;

import com.zygiel.PostcodesEndpoints;
import io.cucumber.java.en.*;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class RandomPostcodeSteps extends BaseTest {

    @Given("the request to the random postcodes endpoint")
    public void theRequestToTheRandomPostcodesEndpoint() {
        SerenityRest.given()
                .baseUri(BASE_URI);
    }

    @When("the request is made with get method to random postcode")
    public void theRequestIsMadeWithGetMethodToRandomPostcode() {
        SerenityRest.when().get(PostcodesEndpoints.RANDOM.getUrl());
    }

    @Then("the randomly generated postcode is returned")
    public void theRandomlyGeneratedPostcodeIsReturned() {
        restAssuredThat(response -> response
                .statusCode(HttpStatus.SC_OK)
                .body("result", is(notNullValue())));
    }
}
