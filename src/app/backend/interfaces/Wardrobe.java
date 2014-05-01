package app.backend.interfaces; 

import java.util.Collection;

public interface Wardrobe{

	public String getName();

	public Collection<Item> getItems();

	public void addItem(Item toAdd);

	public boolean removeItem(Item toRem);
}