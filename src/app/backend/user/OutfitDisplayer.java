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
import app.frontend.OutfitMakerPanel;

public class OutfitDisplayer implements Displayer, Serializable{
	
	OutfitMakerPanel outfitPanel;
	Image preview;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7521619792431856268L;

	public OutfitDisplayer(OutfitMakerPanel oPanel, Image x){
		this.outfitPanel = oPanel;
		this.preview = x;
	}
	
	@Override
	public OutfitMakerPanel getOutfitPanel() {
		return outfitPanel;
	}

	@Override
	public Image getPreview() {
		// TODO Auto-generated method stub
		return preview;
	}


}
