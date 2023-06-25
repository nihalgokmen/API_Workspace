package testData;

import org.json.JSONObject;

public class TestDataJsonPlace {

    public JSONObject expectedBodyOlustur(){

        JSONObject expData = new JSONObject();

        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nam impedit esse");

        return expData;
    }
}
