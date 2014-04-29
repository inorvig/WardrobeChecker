package backend.user;

import java.util.Collection;
import java.util.HashSet;

import backend.interfaces.Item;
import backend.interfaces.Outfit;
import backend.interfaces.Wardrobe;

public class AppOutfit implements Outfit {
	String name;
	HashSet<Item> items;
	Wardrobe wardrobe;
	
	public AppOutfit(String name, Wardrobe wardrobe, Collection<Item> itemsInOutfit){
	
		this.name = name;
		this.wardrobe = wardrobe;
		this.items = new HashSet<Item>();
		
		for (Item item: itemsInOutfit){
			items.add(item);
		}
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	
//ADD TAG METHOD NEEDED??
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

}
