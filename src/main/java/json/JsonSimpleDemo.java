package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleDemo {
    final static String json =
        """
        {
            "name": "Boris",
            "position": "KGB",
            "age": 42
        }
        """;


    public static void main(String[] args) throws ParseException {
        JSONParser parser = new JSONParser();

        JSONObject object = (JSONObject) parser.parse(json); //-> JsonObject, JsonArray

        System.out.println("object.get(\"name\") = " + object.get("name"));

        object.put("surname", "Ivanov");

        System.out.println(object.toJSONString());


    }
}
