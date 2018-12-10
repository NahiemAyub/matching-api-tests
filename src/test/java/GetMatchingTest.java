
import api.GetApi;
import responsebuilders.GetExpectedResponse;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class GetMatchingTest {

    @Test
    public void getBookingNoParameterShouldReturn200(){
        Response response = GetApi.getBookings();
        System.out.println(response.getBody().asString().substring(1, response.getBody().asString().length()-1));
        String xyz = response.getBody().asString().substring(1, response.getBody().asString().length()-1);
        JSONObject jsonResponse = new JSONObject(xyz);

        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getBookingIdShouldReturn200(){
        Response response = GetApi.getBooking(49090, "application/json");

        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public  void getAllBookingIds200(){
        Response response = GetApi.getBookings();
        assertEquals(response.getStatusCode(), 200);
        String bookingIDs = new String(response.getBody().asString());

        bookingIDs = bookingIDs.replaceAll("[^-?0-9]+", " ");

        ArrayList listBookingIDs = new ArrayList(Arrays.asList(bookingIDs.trim().split(" ")));
        for (int i = 0; i < listBookingIDs.size() &&
                ((String) listBookingIDs.get(i)).equalsIgnoreCase("") == false; i++) {
            System.out.print(listBookingIDs.get(i) + " ");

            assertEquals(response.getStatusCode(), 200);
        }
    }

    @Test
    public void getBookingInvalidIdShouldReturn404(){
        Response response = GetApi.getBooking(1, "application/json");

        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void getBookingIdWithBadAcceptShouldReturn418(){
        Response response = GetApi.getBooking(49090, "text/plain");

        assertEquals(response.getStatusCode(), 418);
    }


    @Test
    public void getBookingIdShouldReturnBookingData(){
        JSONObject expectedResponse = new GetExpectedResponse().BasicBooking();
        Response response = GetApi.getBooking(49090, "application/json");

        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        String firstname = jsonResponse.getString("firstname");
        String lastname = jsonResponse.getString("lastname");
        int fullPrice = jsonResponse.getInt("totalprice");
        boolean depositPaid = jsonResponse.getBoolean("depositpaid");

        assertEquals(firstname, expectedResponse.getString("firstname"));
        assertEquals(lastname, expectedResponse.getString("lastname"));
        assertEquals(fullPrice, expectedResponse.getInt("totalprice"));
        assertEquals(depositPaid, expectedResponse.getBoolean("depositpaid"));
    }

}