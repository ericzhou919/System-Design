package tiny_url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String longUrl = "https://www.example.com/very/long/url/to/simplify";
        String apiKey = "your_tinyurl_api_key";
        String apiUrl = "https://tinyurl.com/api-create.php?url=" + URLEncoder.encode(longUrl, "UTF-8") + "&api_key=" + apiKey;
        
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String shortUrl = in.readLine();
        in.close();
        
        System.out.println("Long URL: " + longUrl);
        System.out.println("Short URL: " + shortUrl);
    }
}
