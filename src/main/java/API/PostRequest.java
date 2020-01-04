package API;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.UUID;

public class PostRequest{

    private String responseJson;

    public PostRequest(String user, String pass){

        String jsonBody = "{\"username\": \"" +user+"\"" + ",\"password\": " +pass+"\""+ "}";
        Response response = RestAssured.given()
                .body(jsonBody)
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", UUID.randomUUID())
                .header("Content-Type","application/json")
                .post("https://credapi.credify.tech/api/brportorch/v2/login");
        responseJson = response.getBody().asString();
    }

    public String getResponse(){
        return responseJson;
    }

}
