package app.backend.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import app.backend.interfaces.Item;
import app.backend.interfaces.Wardrobe;

public class AppWardrobe implements Wardrobe, Serializable {
	String name;
	HashSet<Item> items;

	public AppWardrobe(String name) {
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
