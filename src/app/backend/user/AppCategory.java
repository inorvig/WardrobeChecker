package app.backend.user;

import java.util.Collection;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;

public class AppCategory implements Category{
	
	String name;
	String imagePath;
	Collection<Item> items;
	
	
	public AppCategory(String name, Collection<Item> items){
		this.name = name;
		this.imagePath = "defaultpath";
		this.items = items;
	}
	public AppCategory(String name, String imagePath, Collection<Item> items){
		this.name = name;
		this.imagePath= imagePath;
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
