package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {

    /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void post01(){

        // 1- Url ve Request Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Hasan");
        reqBody.put("lastname", "Bak");
        reqBody.put("totalprice", 700);
        reqBody.put("depositpaid", true);
        reqBody.put("bookingdates", bookingdates);
        reqBody.put("additionalneeds", "wi-fi");

        // 2- Expected Data hazirla

        // 3- Response'i kaydet
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post(url);

        response.prettyPrint();

        // 4- Assertions

        response
                .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType("application/json; charset=utf-8")
                        .body("booking.firstname", equalTo("Hasan"),
                        "booking.lastname" , equalTo("Bak"),
                                 "booking.totalprice" , equalTo(700),
                                 "booking.depositpaid" , equalTo(true),
                                 "booking.additionalneeds" , equalTo("wi-fi"),
                                 "booking.bookingdates.checkin" , equalTo("2021-06-01"),
                                 "booking.bookingdates.checkout" , equalTo("2021-06-10"));
    }
}
