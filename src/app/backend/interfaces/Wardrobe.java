package app.backend.interfaces;

import java.util.Collection;

import app.backend.user.AppWardrobe.WardrobeType;

public interface Wardrobe {

	public String getName();

	public Collection<Item> getItems();

	public void addItem(Item toAdd);

	public boolean removeItem(Item toRem);
	
	public WardrobeType getType();
}