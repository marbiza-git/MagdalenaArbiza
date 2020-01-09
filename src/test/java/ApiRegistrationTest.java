import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.UUID;

public class ApiRegistrationTest {

    private static String url = "https://credapi.credify.tech/api/brportorch/v2/login";
    private static final String username = "username";
    private static final String usernameValue = "coding.challenge.login@upgrade.com";
    private static final String password = "password";
    private static final String passwordValue = "On$3XcgsW#9q";
    private static final String wrongUsernameValue = "wrong.login@upgrade.com";
    private JSONObject jsonObject;
    private RequestSpecification request;

    @Test(description = "Validation with correct credentials")
    public void validateCorrectCredentials() {

        initAPI(usernameValue, passwordValue);
        Response response = request.post(url);

        Assert.assertTrue(response.getStatusCode()==200);
        LOGGER.info("Status code is OK: " + response.getStatusCode());
    }

    @Test(description = "Validation on Product Type")
    public void validateValuesOnPayload(){

        initAPI(usernameValue, passwordValue);
        Response response = request.post(url);

        Assert.assertEquals(response.path("loansInReview.productType[0]"), "PERSONAL_LOAN");
        LOGGER.info("Product Type is OK: " + response.path("loansInReview.productType[0]"));
    }

    @Test(description = "Validation with wrong credentials")
    public void validateWrongCredentials() {

        initAPI(wrongUsernameValue, passwordValue);
        Response response = request.post(url);

        Assert.assertTrue(response.getStatusCode()==401);
        Assert.assertEquals(response.path("httpStatus"), "UNAUTHORIZED");

        LOGGER.info("Status code is OK : " + response.getStatusCode() );
        LOGGER.info("Http Status is OK : " + response.path("httpStatus"));
    }

    public void initAPI(String user, String pass){
        jsonObject = new JSONObject();
        jsonObject.put(username, user);
        jsonObject.put(password, pass);

        request = RestAssured.given();
        request.header("x-cf-source-id", "coding-challenge");
        request.header("x-cf-corr-id", UUID.randomUUID().toString());
        request.header("Content-Type","application/json");
        request.body(jsonObject.toJSONString());
    }
}
