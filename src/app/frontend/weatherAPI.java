package app.frontend;

import java.util.HashMap;

import app.frontend.weatherAPI.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class weatherAPI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String API_KEY = "0febebe1ccf291d7bd87ed46206d0e6b";
	ForecastIO fio;
	HashMap<String, String> data = new HashMap<String, String>();
	String iconpath = "";
	String temperature;

	public void setupAPI() {
		fio = new ForecastIO(API_KEY); // instantiate the class with the API
										// key.
		fio.setUnits(ForecastIO.UNITS_US); // sets the units as SI - optional
		fio.setExcludeURL("hourly,minutely"); // excluded the minutely and
												// hourly reports from the reply
		fio.getForecast("41.8236", "-71.4222");
	}

	public weatherAPI() {
		setupAPI();
		getCurrent();
		setIcon();

	}

	public void getCurrent() {
		FIOCurrently currently = new FIOCurrently(fio);
		String[] f = currently.get().getFieldsArray();
		for (int i = 0; i < f.length; i++) {

			data.put(f[i], currently.get().getByKey(f[i]).replaceAll("\"", ""));

		}
		temperature = data.get("temperature");
	}

	public void setIcon() {

		String icontype = data.get("icon");
		iconpath = "/img/weatherIcons/";

		if (icontype.equals("clear-day")) {
			iconpath = iconpath + "clear-day.gif";
		} else if (icontype.equals("clear-night")) {
			iconpath = iconpath + "clear-night.gif";
		} else if (icontype.equals("rain")) {
			iconpath = iconpath + "rain.gif";
		} else if (icontype.equals("snow")) {
			iconpath = iconpath + "snow.gif";
		} else if (icontype.equals("sleet")) {
			iconpath = iconpath + "sleet.gif";
		} else if (icontype.equals("wind")) {
			iconpath = iconpath + "wind.gif";
		} else if (icontype.equals("fog")) {
			iconpath = iconpath + "fog.gif";
		} else if (icontype.equals("cloudy")) {
			iconpath = iconpath + "cloudy.gif";
		} else if (icontype.equals("partly-cloudy-day")) {
			iconpath = iconpath + "partly-cloudy-day.gif";
		} else if (icontype.equals("partly-cloudy-night")) {
			iconpath = iconpath + "partly-cloudy-night.gif";
		} else {
			iconpath = iconpath + "unavailable.gif";
		}

		System.out.println(iconpath);

		java.net.URL url = getClass().getResource(iconpath);
		if (url == null)
			System.out.println("Could not find image!");

		BufferedImage myPicture;
		try {

			myPicture = ImageIO.read(getClass().getResource(iconpath));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		weatherAPI x = new weatherAPI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(x);
		frame.setSize(420, 170); // set frame size
		frame.setVisible(true); // display frame
	}
}