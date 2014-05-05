package app.backend.user;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import app.backend.interfaces.Displayer;
import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.Wardrobe;

public class AppOutfit implements Outfit, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2053839682943380075L;
	String name;
	HashSet<Item> items;
	Wardrobe wardrobe;
	BufferedImage preview;
	Displayer displayInfo;

	public AppOutfit(String name, Wardrobe wardrobe, 
			Collection<Item> itemsInOutfit, Displayer displayInfo) {

		this.name = name;
		this.wardrobe = wardrobe;
		this.items = new HashSet<Item>();
		this.displayInfo = displayInfo;

		for (Item item : itemsInOutfit) {
			items.add(item);
		}
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void addPreview(BufferedImage image){
		this.preview = image;
		
	}
	
	public BufferedImage getPreview(){
		return this.preview;
	}

	// ADD TAG METHOD NEEDED??
	@Override
	public Collection<String> getOutfitTags() {
		return null;
	}

	@Override
	public Collection<Item> itemsInOutfit() {
		return items;
	}

	@Override
	public Wardrobe whatWardrobe() {
		return wardrobe;
	}


	@Override
	public Displayer getDisplayInfo() {
		return displayInfo;
	}
}
