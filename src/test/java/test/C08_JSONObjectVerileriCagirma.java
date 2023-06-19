package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {

    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */

    @Test
    public void jsonPath01() {

        JSONObject cepTel = new JSONObject();

        cepTel.put("type", "iPhone");
        cepTel.put("number", "0123-4567-8888");

        JSONObject evTel = new JSONObject();

        evTel.put("type", "home");
        evTel.put("number", "0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();

        phoneNumbers.put(0, cepTel);
        phoneNumbers.put(1, evTel);

        JSONObject adress = new JSONObject();
        adress.put("streetAddress", "naist street");
        adress.put("city", "Nara");
        adress.put("postalCode", "630-0192");

        JSONObject kisiBiligisi = new JSONObject();

        kisiBiligisi.put("firstName", "John");
        kisiBiligisi.put("lastName", "doe");
        kisiBiligisi.put("age", 26);
        kisiBiligisi.put("adress",adress);
        kisiBiligisi.put("phoneNumbers",phoneNumbers);

        System.out.println("kisi biligisi : " + kisiBiligisi);


        /*
        {
        "firstName":"John",
        "lastName":"doe",
        "address":{
                    "streetAddress":"naist street",
                    "city":"Nara",
                    "postalCode":"630-0192"
                    },
        "age":26,
        "phoneNumbers":[
                        {
                           "number":"0123-4567-8888",
                           "type":"iPhone"
                         },
                        {
                            "number":"0123-4567-8910",
                            "type":"home"
                         }
                        ]
          }
         */

        System.out.println("Isim : " + kisiBiligisi.get("firstName"));
        System.out.println("Soyisim : " + kisiBiligisi.get("lastName"));
        System.out.println("Yas : " + kisiBiligisi.get("age"));
        System.out.println("streetAddress : " + kisiBiligisi.getJSONObject("adress").get("streetAddress"));
        System.out.println("city : " + kisiBiligisi.getJSONObject("adress").get("city"));
        System.out.println("postalCode : " + kisiBiligisi.getJSONObject("adress").get("postalCode"));

        System.out.println("Tel No : " + kisiBiligisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Type : " + kisiBiligisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Ev Tel No : " + kisiBiligisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
        System.out.println("Type : " + kisiBiligisi.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));

    }
}
