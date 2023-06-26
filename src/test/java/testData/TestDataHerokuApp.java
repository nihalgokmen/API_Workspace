package testData;

import org.json.JSONObject;

public class TestDataHerokuApp {

    public int basariliSatatusCode = 200;

    /*
    Request body
	      {
	      "firstname" : "Ali",
	      "lastname" : “Bak",
	      "totalprice" : 500,
	      "depositpaid" : false,
	      "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
	      "additionalneeds" : "wi-fi"
	       }
     */

    public JSONObject bookingDatesOLusturJSON(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkin","2021-06-10");

        return bookingdates;
    }

    public JSONObject bookingOlusturJSON(){

        JSONObject booking = new JSONObject();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingDatesOLusturJSON());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    /*
    Expected Body
	{
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
     */

    public JSONObject expectedBodyOLusturJSON(){

        JSONObject expData = new JSONObject();

        expData.put("bookingid",24);
        expData.put("booking",bookingDatesOLusturJSON());

        return expData;
    }
}
