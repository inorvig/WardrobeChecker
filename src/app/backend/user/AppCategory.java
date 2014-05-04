package app.backend.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;
import app.backend.interfaces.Wardrobe;

public class AppCategory implements Category, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4567651211184531887L;
	String name;
	String imagePath;
	Collection<Item> items;

	public AppCategory(String name, Collection<Item> items) {
		this.name = name;
		this.imagePath = "defaultpath";
		this.items = items;
	}

	public AppCategory(String name, String imagePath, Collection<Item> items) {
		this.name = name;
		this.imagePath = imagePath;
		this.items = items;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}

	@Override
	public Collection<Item> getItems() {
		return items;
	}
	
	@Override
	public Collection<Item> getItemsinWardrobe(Wardrobe wardrobe){
		Collection<Item> result = new ArrayList<Item>();
		for (Item i: items){
			if (i.whichWardrobe() == wardrobe){
				result.add(i);
			}
		}
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
