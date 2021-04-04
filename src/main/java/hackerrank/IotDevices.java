package hackerrank;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class IotDevices {
    public static void main(String[] args) {
        String status = "STOPPED";
        String dateStr = "03-2019";

        IotDevices p = new IotDevices();
        System.out.println(p.countDevices(status, dateStr, 45));
    }

    public int countDevices(String status, String dateStr, int threshold) {
        int count = 0;
        String url = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + status;
        JsonObject response = getUrl(url);
        int pages = response.get("total_pages").getAsInt();
        for (int i = 1; i <= pages; i++) {
            JsonObject page = getUrl(url + "&page=" + i);
            JsonArray arr = page.getAsJsonArray("data");
            for (int j = 0; j < arr.size(); j++) {

                JsonObject row = arr.get(i).getAsJsonObject();
                String date = row.get("timestamp").getAsString();
                String converted = timeStampToString(date);
                if (row.getAsJsonObject("operatingParams").get("rootThreshold").getAsInt() > threshold && converted.equals(dateStr)) {
                    count++;
                }
            }
        }
        return count;
    }


    public String timeStampToString(String timestamp) {
        String formattedDate = new SimpleDateFormat("MM-YYYY").format(Long.parseLong(timestamp));
        return formattedDate;
    }

    public JsonObject getUrl(String url) {
        var client = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject obj = new JsonParser().parse(response.body()).getAsJsonObject();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
