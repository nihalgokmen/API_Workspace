package testData;

import java.util.HashMap;
import java.util.Objects;

public class TestDataDummy {

    public int basariliStatutCode = 200;
    public String contentType = "application/json";

    /*
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */


    public HashMap dataBodyOlusturMap(){

        HashMap <String, Object> data = new HashMap<>();

        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");

        return data;
    }

    public HashMap expectedBodyOlusturMap(){

        HashMap <String, Object> expectedBody = new HashMap<>();

        expectedBody.put("status","success");
        expectedBody.put("data",dataBodyOlusturMap());
        expectedBody.put("message","Successfully! Record has been fetched.");

        return expectedBody;
    }
}
