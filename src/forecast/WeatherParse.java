package forecast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import obj.Response;

public class WeatherParse {		

	public Response parse(URL src) throws IOException { //retrieves the json information from the url passed
		Gson gson = new Gson();
		URL url = src;
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		InputStream source = conn.getInputStream(); 
        Reader reader = new InputStreamReader(source);
		if(responsecode != 200) throw new RuntimeException("HttpResponseCode: "+responsecode);
		else {
            Response json = gson.fromJson(reader, Response.class);
			return json;
		}
		
	}
	
}
	