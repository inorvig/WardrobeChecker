package app.backend.interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;


public interface Displayer {

	//gets panel outfit was made in
	public HashMap<JLabel, Item> getOutfitPanel();
	
	//gets a preview image of the outfit
	public Image getPreview(); 
}
