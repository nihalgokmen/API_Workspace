package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;
import pojos.HerokuappExpBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Post_Pojo extends HerokuAppBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
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


    	            	Response Body = Expected Data
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
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){

        // 1- Url ve Request Body hazirla
        specHerokuApp.pathParam("pp1","booking");

        BookingDatesPOJO bookingDates = new BookingDatesPOJO("2021-06-01", "2021-06-10");

        BookingPOJO reqBody = new BookingPOJO("Ali","Bak",500,false,bookingDates,"wifi");

        // 2- Expected Data hazirla

        HerokuappExpBodyPOJO expData = new HerokuappExpBodyPOJO(24,reqBody);

        // 3- Response'i kaydet

        Response response = given()
                                    .spec(specHerokuApp)
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody)
                                    .post("/{pp1}");
        response.prettyPrint();

        // 4- Assertion

        HerokuappExpBodyPOJO respPojo = response.as(HerokuappExpBodyPOJO.class);

        assertEquals(expData.getBooking().getFirstname(), respPojo.getBooking().getFirstname());
        assertEquals(expData.getBooking().getLastname(), respPojo.getBooking().getLastname());
        assertEquals(expData.getBooking().getBookingdates().getCheckin(), respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expData.getBooking().getBookingdates().getCheckout(), respPojo.getBooking().getBookingdates().getCheckout());



    }


}
