package nl.bos.cid;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AppTest {
    private static final String API_URL = "https://api.issuu.com/call/reader/api/dynamic/computertotaal/";
    private static final String PREFIX = "computer-idee";
    private static final String API_URL_FORMAT = "%s%s_%s-%s_%s%s";
    private static final String METADATA = "metadata";
    private static final String TITLE = "title";

    @Test
    @Ignore
    public void readAPITest() throws IOException {
        JSONObject json = App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "10", "2020", "2020", "0410"));
        Assert.assertNotNull(json);
        JSONObject metadata = (JSONObject) json.get(METADATA);
        Assert.assertEquals("Computer-Idee 10-2020", metadata.get(TITLE));

        json = App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "09", "2020", "2020", "0327"));
        Assert.assertNotNull(json);
        metadata = (JSONObject) json.get(METADATA);
        Assert.assertEquals("Computer Idee 9-2020", metadata.get(TITLE));

        json = App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "08", "2020", "2020", "1703"));
        Assert.assertNotNull(json);
        metadata = (JSONObject) json.get(METADATA);
        Assert.assertEquals("Computer Idee 08-2020", metadata.get(TITLE));

        json = App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "01", "2020", "2019", "1206"));
        Assert.assertNotNull(json);
        metadata = (JSONObject) json.get(METADATA);
        Assert.assertEquals("Computer Idee 1-2020", metadata.get(TITLE));

        json = App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "26", "2019", "2019", "1126"));
        Assert.assertNotNull(json);
        metadata = (JSONObject) json.get(METADATA);
        Assert.assertEquals("Computer-Idee 26-2019", metadata.get(TITLE));
    }

    @Test(expected = FileNotFoundException.class)
    public void readAPIFailTest() throws IOException {
        App.readAPI(String.format(API_URL_FORMAT, API_URL, PREFIX, "10", "2020", "2020", "0411"));
    }
}