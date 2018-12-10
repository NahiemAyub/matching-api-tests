package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetApi extends BaseApi {

    private static final String apiUrl = baseUrl + "booking/";

    public static Response getBookings(){
        return given().get(apiUrl);
    }

    public static Response getBooking(int id, String mediaType) {
        return given()
                .header("Accept", mediaType)
                .get(apiUrl + Integer.toString(id));
    }

}