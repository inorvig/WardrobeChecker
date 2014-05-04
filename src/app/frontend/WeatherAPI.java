package app.frontend;

import java.util.HashMap;

import app.frontend.weatherAPI.*;




public class WeatherAPI{
	
	/**
	 * 
	 */

	private String API_KEY = "0febebe1ccf291d7bd87ed46206d0e6b";
	ForecastIO fio;
	HashMap<String, String> data = new HashMap<String, String>();
	String iconpath = "" ;
	String temperature;
	String summary;
	
	public void setupAPI(){
		fio = new ForecastIO(API_KEY); //instantiate the class with the API key. 
		fio.setUnits(ForecastIO.UNITS_US);             //sets the units as SI - optional
		fio.setExcludeURL("hourly,minutely");             //excluded the minutely and hourly reports from the reply
		fio.getForecast("41.8236", "-71.4222"); 
	}
	
	public WeatherAPI(){
		setupAPI();
		getCurrent();
		setIcon();
		
	}
	
	
	public void getCurrent(){
		FIOCurrently currently = new FIOCurrently(fio);
	    String [] f  = currently.get().getFieldsArray();
	    for(int i = 0; i<f.length;i++){
	    	
	    	data.put(f[i], currently.get().getByKey(f[i]).replaceAll("\"", ""));
	    		        
	    }
	    temperature = data.get("temperature").split("\\.")[0];
	    summary = data.get("summary");
	}
	
	public void setIcon(){
		
		String icontype = data.get("icon");
		iconpath = "images/weather/";
		
		if(icontype.equals("clear-day")){
			iconpath = iconpath+"clear-day.gif";
		}
		else if(icontype.equals("clear-night")){
			iconpath = iconpath+"clear-night.gif";
		}
		else if(icontype.equals("rain")){
			iconpath = iconpath+"rain.gif";
		}
		else if(icontype.equals("snow")){
			iconpath = iconpath+"snow.gif";
		}
		else if(icontype.equals("sleet")){
			iconpath = iconpath+"sleet.gif";
		}
		else if(icontype.equals("wind")){
			iconpath = iconpath+"wind.gif";
		}
		else if(icontype.equals("fog")){
			iconpath = iconpath+"fog.gif";
		}
		else if(icontype.equals("cloudy")){
			iconpath = iconpath+"cloudy.gif";
		}
		else if(icontype.equals("partly-cloudy-day")){
			iconpath = iconpath+"partly-cloudy-day.gif";
		}
		else if(icontype.equals("partly-cloudy-night")){
			iconpath = iconpath+"partly-cloudy-night.gif";
		}
		else {
			iconpath = iconpath+"unavailable.gif";
		}
		
		System.out.println(iconpath);
	
	}
	
	
	
//	public static void main(String[] args) {
//		weatherAPI x = new weatherAPI();
//		System.out.println(x.temperature);
//		System.out.println(x.summary);
//
//
//		
//	}
}