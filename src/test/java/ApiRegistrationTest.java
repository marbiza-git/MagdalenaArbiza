import com.jayway.restassured.RestAssured;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.UUID;
import static org.hamcrest.Matchers.equalTo;

public class ApiRegistrationTest {

    private String jsonBody = "{\"username\": \"coding.challenge.login@upgrade.com\", \"password\": \"On$3XcgsW#9q\"}";

    @Test(description = "Validation with correct credentials")
    public void validateCorrectCredentials() {
        String body = RestAssured
                .given()
                    .baseUri("https://credapi.credify.tech/api/brportorch/v2/login")
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", UUID.randomUUID())
                .header("Content-Type","application/json")
                .body(jsonBody)
                .when()
                .post("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().extract().body().asString();
    }

    @Test(description = "Validation on Product Type")
    public void validateValuesOnPayload(){
        String body = RestAssured
                .given()
                .baseUri("https://credapi.credify.tech/api/brportorch/v2/login")
                .and()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", UUID.randomUUID())
                .header("Content-Type","application/json")
                .body(jsonBody)
                .when()
                .post("/")
                .then().log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().assertThat().body("loansInReview.productType[0]", Is.is("PERSONAL_LOAN"))
                .and().extract().body().asString();
    }

    @Test(description = "Validation with wrong credentials")
    public void validateWrongCredentials() {
        String wrongJsonBody = "{\"username\": \"coding.wrong.login@upgrade.com\", \"password\": \"On$3XcgsW#9q\"}";
        String body = RestAssured
                .given()
                .baseUri("https://credapi.credify.tech/api/brportorch/v2/login")
                .and()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", UUID.randomUUID())
                .header("Content-Type","application/json")
                .body(wrongJsonBody)
                .when()
                .post("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(401)))
                .and().assertThat().body("httpStatus", Is.is("UNAUTHORIZED"))
                .and().extract().body().asString();
    }
}
