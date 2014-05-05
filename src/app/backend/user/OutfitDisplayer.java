package app.backend.user;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.backend.interfaces.Displayer;
import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.Wardrobe;
import app.frontend.OutfitMakerPanel;

public class OutfitDisplayer implements Displayer, Serializable{
	

	HashMap<JLabel, Item> clothes;

	Image preview;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7521619792431856268L;


	public OutfitDisplayer(HashMap<JLabel, Item> cloth, Image x){
		this.clothes = cloth;
		this.preview = x;
	}
	

	@Override
	public Image getPreview() {
		return preview;
	}


	@Override
	public HashMap<JLabel, Item> getOutfitPanel() {
		// TODO Auto-generated method stub
		return null;
	}


}
