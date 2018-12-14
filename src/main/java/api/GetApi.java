package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetApi extends BaseApi {

    private static final String matchApiUrl = baseUrlMatch + "match/";

    public static Response getMatch(String searchterm, String mediaType) {
        return given()
                .header("Accept", mediaType)
                .get(matchApiUrl + searchterm);
    }

}