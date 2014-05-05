package app.backend.interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public interface Displayer {

	//gets panel outfit was made in
	public JPanel getOutfitPanel();
	
	//gets a preview image of the outfit
	public Image getPreview(); 
}
