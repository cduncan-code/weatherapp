package forecast;

import java.io.IOException;

import java.net.URL;

import obj.Location;
import obj.Response;


public class WeatherFetch {
private Location l;
	
public WeatherFetch(Location loc) {
		l = loc;
	}
	
public Response fetch() throws IOException {	
	URL url =  new URL("http://api.openweathermap.org/data/2.5/weather?zip="+l.getZipCode()+",us&appid="+l.getApiKey()+"&units=imperial");
	Response parse = WeatherParse.Parse(url);
	return parse;
}

}