package app.backend.interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import app.frontend.OutfitMakerPanel;

public interface Displayer {

	//gets panel outfit was made in
	public OutfitMakerPanel getOutfitPanel();
	
	//gets a preview image of the outfit
	public Image getPreview(); 
}
