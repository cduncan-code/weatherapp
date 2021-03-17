package obj;


public class Location {
	private static final String APIKEY = "21bbb1a437d85648e81291331fdd52f1";
	//private String Location; //possible expansion
	//private int Days;
	private String ZipCode;
	private String CountryCode = "us"; //only work in us rn
	
	
	public Location(){
		
	}
	
	
	public Location(String ZipCode) {
		this.ZipCode = ZipCode;
		this.CountryCode = getCountryCode();
	}

	
	public void setZipCode(String ZipCode)
	{
		this.ZipCode = ZipCode;
	}
	
	public String getZipCode() {
		return ZipCode;
	}
	
	public String getApiKey() {
		return APIKEY;
	}

	public String getCountryCode() {
		return CountryCode;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
