package installer;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class HttpRequestLiveTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * @param sheetid
     * @param range
     * @param key
     * @return
     * @throws IOException
     */
    public static List Request(String sheetid, String range, String key) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://sheets.googleapis.com/v4/spreadsheets/"  + sheetid + "/values/" + range + "?key=" + key)
            .build(); // defaults to GET

        Response response = client.newCall(request).execute();

        APOD apod = mapper.readValue(response.body().byteStream(), APOD.class);

        System.out.println("https://sheets.googleapis.com/v4/spreadsheets/"  + sheetid + "/values/" + range + "?key=" + key);
        System.out.println(apod.values);
        
        return apod.values;

    }

}

