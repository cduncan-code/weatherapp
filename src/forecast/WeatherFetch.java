package forecast;

import java.io.IOException;

import java.net.URL;

import obj.Location;
import obj.Response;


public class WeatherFetch {
private Location l;
	
public WeatherFetch(Location loc) { //constructor which sets a location 
		l = loc;
	}
	
public Response fetch() throws IOException {	//this calls parse(url), and returns the parsed response (JSON)
	URL url =  new URL("http://api.openweathermap.org/data/2.5/weather?zip="+l.getZipCode()+",us&appid="+l.getApiKey()+"&units=imperial");
	WeatherParse obj = new WeatherParse(); 
	return obj.parse(url);
}

}