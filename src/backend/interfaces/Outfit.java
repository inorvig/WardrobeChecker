package backend.interfaces; 

import java.util.Collection;

public interface Outfit{

	//The outfit's name
	public String getName();

	// Any extra tags the outfit has gotten (casual, business, etc.)
	public Collection<String> getOutfitTags();

	// All the items in the outfit
	public Collection<Item> itemsInOutfit();

	// Gives the wardrobe that all the items belong to; null if the items are spread out amongst various wardrobes 
	public Wardrobe whatWardrobe();

	// Any info the GUI needs to reconstruct the picture
	//public Displayer getDisplayInfo();
}