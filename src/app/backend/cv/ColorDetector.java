package app.backend.cv;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ColorDetector implements ColorDetecting {

	public ColorDetector(){}
	
	private String determineColor (Color compare){
		String result = "";
		try{
		List<Color> presets = new ArrayList<Color>();
		String hex = String.format("#%02x%02x%02x", compare.getRed(), compare.getGreen(), compare.getBlue());
		ScriptEngineManager factory = new ScriptEngineManager();
	    ScriptEngine engine = factory.getEngineByName("JavaScript");

	    engine.put("n_match", hex);
	    result = (String) engine.eval(new FileReader("src/app/backend/cv/ntc.js"));	
		}
		catch (Exception e){
			System.out.println("oops");
		}
	    return result;
	}
	@Override
	public String getObjectColor(String imagePath) {
		String result = "";
		try {
			BufferedImage image = ImageIO.read(new File(imagePath));
			int background  = image.getRGB(0,0);
			Color col = new Color(background, true);
			System.out.println(col.getRed()+ ", "+ col.getGreen()+ ", "+ col.getBlue() + ", is the background color");
			int[][][] channels = new int [256][256][256];
			for (int x = 0; x< image.getWidth(); x++){
				for (int y = 0; y < image.getHeight(); y++){
					int color = image.getRGB(x, y);
					Color othercol = new Color(color, true);
					int alpha = othercol.getAlpha();
	                int red = othercol.getRed();
	                int green = othercol.getGreen();
	                int blue = othercol.getBlue();
	                channels[red][green][blue]++;
				}
			}
			int max = channels[0][0][0];
			int r = 0;
			int g = 0;
			int b = 0;
			for (int i = 0; i< channels.length; i++){
				for (int j = 0; j< channels[0].length; j++){

					for (int k = 0; k < channels[0][0].length;k++){
						if (!((i == col.getRed()) && (j == col.getGreen()) && (k == col.getBlue()))){
							if ((channels[i][j][k]) > max){
							max = channels[i][j][k];
							r = i;
							g = j;
							b = k;
						}
						}
					}
				}
			}
			Color toTest = new Color (r, g, b);
			System.out.println(determineColor(toTest));
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	


}
