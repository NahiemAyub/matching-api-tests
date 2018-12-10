package responsebuilders;

import org.json.JSONObject;

public class GetExpectedResponse {

    public JSONObject EmptyBooking(){

        JSONObject booking = new JSONObject();
        booking.put("firstname", "");
        booking.put("lastname", "");
        booking.put("totalprice", "");
        booking.put("depositpaid", "false");
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","");
        bookingDates.put("checkout","");
        booking.put("bookingdates",bookingDates);

        return booking;
    }

    public JSONObject BasicBooking(){

        JSONObject booking = new JSONObject();
        booking.put("firstname", "NamNam");
        booking.put("lastname", "Ayub");
        booking.put("totalprice", 786.9);
        booking.put("depositpaid", true);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2018-12-07");
        bookingDates.put("checkout","2018-12-08");
        booking.put("bookingdates",bookingDates);

        return booking;
    }
}
