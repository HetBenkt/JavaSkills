package nl.bos.cid;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final String API_URL = "https://api.issuu.com/call/reader/api/dynamic/computertotaal/";
    private static final String PREFIX = "computer-idee";
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) {
        int year = 2020;
        int yearId = year;
        int editionFrom = 10;
        int editionTo = 10;
        int id = 0;

        while (editionFrom <= editionTo) {
            try {
                String editionStr = StringUtils.leftPad(String.valueOf(editionFrom), 2, '0');
                String idStr = StringUtils.leftPad(String.valueOf(id), 4, '0');
                String dataFormat = String.format("Try edition[%s], year[%s], id[%s%s]", editionStr, year, yearId, idStr);

                if (id % 100 == 0) {
                    Logger.getLogger(App.class.getName()).info(dataFormat);
                }
                String url = String.format("%s%s_%s-%s_%s%s", API_URL, PREFIX, editionStr, year, yearId, idStr);
                if (App.doGet(url)) {
                    String apiUrl = String.format("Found API: %s", url);
                    Logger.getLogger(App.class.getName()).info(apiUrl);
                    String finalUrl = String.format("URL: https://e.issuu.com/embed.html?d=computer-idee_%s-%s_%s%s&hideIssuuLogo=false&hideShareButton=true&u=computertotaal", editionStr, year, yearId, idStr);
                    Logger.getLogger(App.class.getName()).info(finalUrl);
                    id = 0;
                    yearId = year;
                    editionFrom++;
                } else {
                    id++;
                    if (id == 9999) {
                        yearId--;
                        id = 0;
                    }
                }
            } catch (IOException e) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    private static boolean doGet(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
        }
    }

    static JSONObject readAPI(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
