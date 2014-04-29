package backend.user;

import java.util.Collection;
import java.util.HashSet;

import backend.interfaces.Item;
import backend.interfaces.Wardrobe;

public class AppWardrobe implements Wardrobe {
	String name;
	HashSet<Item> items;
	
	public AppWardrobe(String name){
		this.name = name;
		this.items = new HashSet<Item>();
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
