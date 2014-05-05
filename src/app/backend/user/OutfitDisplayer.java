package app.backend.user;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Collection;

import javax.swing.JPanel;

import app.backend.interfaces.Displayer;
import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.Wardrobe;

public class OutfitDisplayer implements Displayer, Serializable{
	
	JPanel outfitPanel;
	Image preview;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7521619792431856268L;

	public OutfitDisplayer(JPanel oPanel, Image x){
		this.outfitPanel = oPanel;
		this.preview = x;
	}
	
	@Override
	public JPanel getOutfitPanel() {
		return outfitPanel;
	}

	@Override
	public Image getPreview() {
		// TODO Auto-generated method stub
		return preview;
	}


}
