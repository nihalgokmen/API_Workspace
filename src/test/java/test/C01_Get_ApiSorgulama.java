package test;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
    */

    // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
    // 2 - Eger soruda bize verilmisse Expected Data hazirla
    // 3 - Bize donen Response'i Actual Data olarak kaydet
    // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek


    @Test
    public void get01(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - Eger soruda bize acikca verilmisse Expected Data hazirla

        // 3 - Bize donen Response'i Actual Data olarak kaydet
        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Content Type : "+response.getContentType());
        System.out.println("Server Header Degeri : "+response.getHeader("Server"));
        System.out.println("Status Line : "+response.getStatusLine());
        System.out.println("Response Suresi : "+response.getTime());



    }

}
