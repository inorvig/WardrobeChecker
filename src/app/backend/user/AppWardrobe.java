package app.backend.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import app.backend.interfaces.Item;
import app.backend.interfaces.Wardrobe;

public class AppWardrobe implements Wardrobe, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 106311970249868006L;
	String name;
	HashSet<Item> items;
	WardrobeType type;
	
	public static enum WardrobeType{
		CLOSET, SUITCASE;
	}

	public AppWardrobe(String name, WardrobeType type) {
		//System.out.println("just made a wardrobe with name"+ name);
		this.name = name;
		this.items = new HashSet<Item>();
		this.type = type;
	}
	
	@Override
	public WardrobeType getType(){
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<Item> getItems() {
		return items;
	}

	@Override
	public void addItem(Item toAdd) {
		items.add(toAdd);
	}

	@Override
	public boolean removeItem(Item toRem) {
		return items.remove(toRem);
	}

}
