package sample;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

public class DB {

    private static final String link = "https://reqres.in/api/users?page=";

    public static String getPages() throws Exception {
        {
                URL url = new URL(link + 1);
                    try {
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        InputStreamReader reader = new InputStreamReader(url.openStream());
                        JsonParser parser = new JsonParser();
                        JsonObject mainObject = parser.parse(reader).getAsJsonObject();
                        return (mainObject.get("total_pages").toString());
                    } catch (Exception e) {
                        return null;
                    }
                }
    }

    public static String getData(int page) throws Exception {
        {
            try {
                String data = "";
                URL url = new URL(link + page);

                InputStreamReader reader = new InputStreamReader(url.openStream());

                String fname = null;
                String sname = null;
                JsonParser parser = new JsonParser();
                JsonObject mainObject = parser.parse(reader).getAsJsonObject();

                JsonArray pItem = mainObject.getAsJsonArray("data");
                for (JsonElement user : pItem) {
                    JsonObject userObject = user.getAsJsonObject();
                    userObject.get("first_name");
                    fname = userObject.get("first_name").toString();
                    sname = userObject.get("last_name").toString();
                    data = data + fname + " " + sname + "\n";
                }
                return data;
            } catch (Exception e) {
            }
        }
        return "";
    }
}